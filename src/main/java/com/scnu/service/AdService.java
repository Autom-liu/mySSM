package com.scnu.service;

import com.scnu.bean.PageBean;
import com.scnu.contanst.PageCodeEnum;
import com.scnu.dto.AdDto;

public interface AdService {

	/**
	 * 新增广告
	 * @param adDto
	 * @return 是否新增成功，返回码
	 */
	PageCodeEnum add(AdDto adDto);

	PageBean<AdDto> searchByPage(AdDto adDto);

	PageCodeEnum delete(Long id);
	
	AdDto selectById(Long id);

	PageCodeEnum edit(AdDto adDto);
}
