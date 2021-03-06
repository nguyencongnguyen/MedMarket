package com.med.market.service;


public interface ImageService {
	String processImage(String imagePath, String imageName) throws Exception;
	void deleteImage(String imageName) throws Exception;
	String createThumbnail(String imageName, String tmpFolder) throws Exception;
}
