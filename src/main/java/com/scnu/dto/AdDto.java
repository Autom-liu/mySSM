package com.scnu.dto;

import org.springframework.web.multipart.MultipartFile;

import com.scnu.bean.Ad;

public class AdDto extends Ad {
	private String img;				// 用于展示图片的完整链接
	private MultipartFile imgFile; // 属性名称和表单保持一致就可以接收到了

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public MultipartFile getImgFile() {
		return imgFile;
	}

	public void setImgFile(MultipartFile imgFile) {
		this.imgFile = imgFile;
	}

	@Override
	public String toString() {
		return "AdDto [" + super.toString()  + "]";
	}
	
}
