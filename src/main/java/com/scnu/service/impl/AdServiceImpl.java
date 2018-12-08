package com.scnu.service.impl;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.scnu.bean.Ad;
import com.scnu.bean.PageBean;
import com.scnu.contanst.PageCodeEnum;
import com.scnu.dao.AdDao;
import com.scnu.dto.AdDto;
import com.scnu.service.AdService;
import com.scnu.util.UploadUtil;

import ch.qos.logback.core.joran.util.beans.BeanUtil;

@Service
public class AdServiceImpl implements AdService {
	@Autowired
	private AdDao adDao;
	@Value("${adImage.savePath}")
	private String adImageSavePath;
	@Value("${adImage.url}")
	private String imgUrl;
	
	@Override
	public PageCodeEnum add(AdDto adDto) {
		Ad ad = new Ad();
		BeanUtils.copyProperties(adDto, ad);
		try {
			String fileName = UploadUtil.uploadFile(adDto.getImgFile(), adImageSavePath);
			if(fileName != null) {
				ad.setImgFileName(fileName);
				adDao.insert(ad);
				return PageCodeEnum.SUCCESS;
			} else {
				return PageCodeEnum.PARAM_FILE;
			}
		} catch (IllegalStateException | IOException e) {
			// TODO 需要添加日志
			e.printStackTrace();
			return PageCodeEnum.EXCEPTION;
		}
	}

	@Override
	public PageBean<AdDto> searchByPage(AdDto adDto) {
		PageBean<AdDto> result = new PageBean<AdDto>();
		result.setData(new ArrayList<AdDto>());
		Ad condition = new Ad();
		BeanUtils.copyProperties(adDto, condition);
		Long count = adDao.selectCount(condition);
		condition.getPage().setTotalCount(count);
		BeanUtils.copyProperties(condition.getPage(), result);		// 封装分页参数
		List<Ad> adList = adDao.selectByPage(condition);
		for(Ad ad: adList) {
			AdDto retBean = new AdDto();
			ad.setPage(null);		// 不需要分页参数
			BeanUtils.copyProperties(ad, retBean);
			retBean.setImg(imgUrl + ad.getImgFileName());	// 处理图片保存路径
			result.getData().add(retBean);
		}
		return result;
	}
	
	public PageCodeEnum delete(Long id) {
		String imgFileName = selectById(id).getImgFileName();
		int result = adDao.delete(id);
		if(result == 1) {
			UploadUtil.deleteFile(adImageSavePath + imgFileName);
			return PageCodeEnum.SUCCESS;
		} else {
			return PageCodeEnum.EXCEPTION;
		}
	}

	@Override
	public AdDto selectById(Long id) {
		Ad ad = adDao.selectById(id);
		AdDto retBean = new AdDto();
		BeanUtils.copyProperties(ad, retBean);
		retBean.setImg(imgUrl + ad.getImgFileName());	// 处理图片保存路径
		return retBean;
	}

	@Override
	public PageCodeEnum edit(AdDto adDto) {
		Ad ad = new Ad();
		BeanUtils.copyProperties(adDto, ad);
		MultipartFile uploadFile = adDto.getImgFile();
		if (uploadFile != null && uploadFile.getSize() > 0) {
			String imgFileName = selectById(ad.getId()).getImgFileName();
			try {
				String fileName = UploadUtil.uploadFile(adDto.getImgFile(), adImageSavePath);
				ad.setImgFileName(fileName);
				UploadUtil.deleteFile(adImageSavePath + imgFileName);
			} catch (IllegalStateException | IOException e) {
				// TODO 需要添加日志
				e.printStackTrace();
				return PageCodeEnum.EXCEPTION;
			}
		}
		adDao.update(ad);
		return PageCodeEnum.SUCCESS;
	}

}
