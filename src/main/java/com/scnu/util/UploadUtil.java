package com.scnu.util;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import com.scnu.contanst.PageCodeEnum;

public class UploadUtil {
	public static String uploadFile(MultipartFile uploadFile, String savePath) throws IllegalStateException, IOException {
		if (uploadFile != null && uploadFile.getSize() > 0) {
			String generateFileName = UUID.randomUUID().toString().replaceAll("-", "");
			String ext  = FilenameUtils.getExtension(uploadFile.getOriginalFilename()); 
			File fileFolder = new File(savePath);
			if (!fileFolder.exists()) {
				fileFolder.mkdirs();
			}
			String fileName = generateFileName + "." + ext;
			File file = new File(savePath + fileName);
			uploadFile.transferTo(file);
			return fileName;
		} else {
			return null;
		}
	}
	
	public static boolean deleteFile(String path) {
		File file = new File(path);
		return file.isFile() && file.delete();
	}
}
