package com.itcuties.java;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class JavaDownloadFile {

	public static void main(String[] args) {
		try {
			JavaDownloadFile downloader = new JavaDownloadFile();
			downloader.download("http://fbapp.itcuties.com/middle/_DSC4598.jpg", "D:\\tmp");
			downloader.download("http://fbapp.itcuties.com/middle/_DSC4516.jpg", "D:\\tmp");
			downloader.download("http://fbapp.itcuties.com/middle/_DSC4796.jpg", "D:\\tmp");
			downloader.download("http://fbapp.itcuties.com/middle/_DSC4776.jpg", "D:\\tmp");
			downloader.download("http://fbapp.itcuties.com/middle/_DSC4505.jpg", "D:\\tmp");
			downloader.download("http://fbapp.itcuties.com/middle/_DSC4448.jpg", "D:\\tmp");
			downloader.download("http://fbapp.itcuties.com/middle/_DSC4590.jpg", "D:\\tmp");
			downloader.download("http://fbapp.itcuties.com/middle/_DSC4514.jpg", "D:\\tmp");
			downloader.download("http://fbapp.itcuties.com/middle/_DSC4698.jpg", "D:\\tmp");
			downloader.download("http://fbapp.itcuties.com/middle/_DSC4434.jpg", "D:\\tmp");
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Method downloads file from URL to a given directory.
	 * @param fileURL	- 	file URL to download
	 * @param destinationDirectory	- directory to download file to
	 * @throws IOException
	 */
	private void download(String fileURL, String destinationDirectory) throws IOException {
		// File name that is being downloaded
		String downloadedFileName = fileURL.substring(fileURL.lastIndexOf("/")+1);
		
		// Open connection to the file
        URL url = new URL(fileURL);
        InputStream is = url.openStream();
        // Stream to the destionation file
        FileOutputStream fos = new FileOutputStream(destinationDirectory + "/" + downloadedFileName);
 
        // Read bytes from URL to the local file
        byte[] buffer = new byte[4096];
        int bytesRead = 0;
        
        System.out.print("Downloading " + downloadedFileName);
        while ((bytesRead = is.read(buffer)) != -1) {
        	System.out.print(".");	// Progress bar :)
        	fos.write(buffer,0,bytesRead);
        }
        System.out.println("done!");
 
        // Close destination stream
        fos.close();
        // Close URL stream
        is.close();
	}
	
}
