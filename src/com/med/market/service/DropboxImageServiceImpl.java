package com.med.market.service;

import java.io.File;
import java.io.FileInputStream;
import java.util.Locale;

import com.dropbox.core.DbxClient;
import com.dropbox.core.DbxEntry;
import com.dropbox.core.DbxRequestConfig;
import com.dropbox.core.DbxWriteMode;

public class DropboxImageServiceImpl implements ImageService {
	private static final String APP_KEY = "urd2dot7053u9rh";
	private static final String APP_SECRET = "xkq4ao79kz9vbbo";
	private static final String ACCESS_TOKEN = "yu7yx6KkC1IAAAAAAAAAAamaSYjp0vN-lSJnCVrkCKQ_G91CGeFS8115kZCVGvx8";
	
	@Override
	public String processImage(String imagePath, String imageName) throws Exception {
		DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0",
				Locale.getDefault().toString());
		DbxClient client = new DbxClient(config, ACCESS_TOKEN);
		File inputFile = new File(imagePath + "/" + imageName);
		FileInputStream inputStream = new FileInputStream(inputFile);
		try {
			client.createTemporaryDirectUrl("/" + imageName);
			DbxEntry.File uploadedFile = client.uploadFile("/" + imageName,
					DbxWriteMode.add(), inputFile.length(), inputStream);
		} finally {
			inputStream.close();
		}
		String url = client.createShareableUrl("/" + imageName);
		url = url.replace("www.dropbox.com", "dl.dropboxusercontent.com");
		return url;
	}

	@Override
	public void deleteImage(String imageName) throws Exception {
		DbxRequestConfig config = new DbxRequestConfig("JavaTutorial/1.0",
				Locale.getDefault().toString());
		DbxClient client = new DbxClient(config, ACCESS_TOKEN);
		client.delete("/" + imageName);
	}
}
