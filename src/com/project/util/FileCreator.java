package com.project.util;

import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;

public class FileCreator {

	private File file;
	
	private String content;
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}


	
	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public void write(){
		 
		try {
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}
			PrintWriter writer = new PrintWriter(new FileWriter(file));
			System.out.println(content);
			writer.println(content);
			writer.close();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
