package com.aliottisimon;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Main2 {

	public static void main(String[] args) throws IOException {

		//copyFile();
		copyFileWithBuffer();

	}

	public static void readFile() {

		File fileToRead = new File("C:\\dossier\\simon.txt");
		FileInputStream fis = null;

		try {
			fis = new FileInputStream(fileToRead);
			int data;

			while ((data = fis.read()) >= 0) {
				System.out.println(data);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
	}

	public static void writeFile() throws IOException {

		FileOutputStream fop = null;
		File file = null;

		try {
			file = new File("C:\\dossier\\testwrite.txt");
			fop = new FileOutputStream(file);
			String content = "Salut Comment ca va ?";

			if (!file.exists()) {
				file.createNewFile();
			}
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fop.close();
		}

	}

	public static void copyFile() throws IOException {

		File fileToRead = new File("C:\\dossier\\simon.txt");
		File file = null;

		FileInputStream fis = null;
		FileOutputStream fop = null;

		try {

			file = new File("C:\\dossier\\testwrite.txt");
			fop = new FileOutputStream(file);

			if (!file.exists()) {
				file.createNewFile();
			}

			fis = new FileInputStream(fileToRead);
			int data;

			while ((data = fis.read()) >= 0) {
				fop.write(data);
			}
			fop.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			fop.close();
			fis.close();
		}
	}

	public static void copyFileWithBuffer() throws IOException {
		
		File fileToRead = new File("C:\\dossier\\monkey.jpg");
		File file = null;

		FileInputStream fis = null;
		FileOutputStream fop = null;

		BufferedInputStream bis = null;
		BufferedOutputStream bos = null;
		
		try {

		
					
			file = new File("C:\\dossier\\copy.jpg");
			fop = new FileOutputStream(file);

			
			
			if (!file.exists()) {
				file.createNewFile();
			}

			fis = new FileInputStream(fileToRead);
			int data;
			bis = new BufferedInputStream(fis);
			bos = new BufferedOutputStream(fop);
			
			
			while ((data = bis.read()) >= 0) {
				bos.write(data);
			}
			
			//bos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
		}
	}
	
}
