package com.stringutil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletResponse;

import com.first.pojo.Student;

public class FileGeneratorUtil {
	
	public static String FileFileGenerator(HttpServletResponse resp,String filetypes,List<Student> student,String folderpath) throws Exception
	{
	String[]ft=filetypes.split(",");
	for (String string : ft) {
	IFileGenerator fileGenerator=null;
	switch(string)
	{
	case "pdf":fileGenerator=new PDFFileGenerator();break;
	case "doc":fileGenerator=new WordFileGenerator();break;
	case "xls":fileGenerator=new XlsFileGenerator();break;
		
	}
	fileGenerator.generateFile(student, folderpath);
	
	}
	File file=new File(folderpath);
	
	
	File[] files=file.listFiles();
	String zipoutfile="D:\\output"+System.currentTimeMillis()+FileFormat.PDF;
	FileOutputStream fos=new FileOutputStream(zipoutfile);
	ZipOutputStream zos=new ZipOutputStream(fos);
	
	
	for (File file2 : files) {
		
		ZipEntry entry=new ZipEntry(file2.getName());
		zos.putNextEntry(entry);
		
		FileInputStream fis = new FileInputStream(file2);
		
		//PrintWriter pw=resp.getWriter();
		
		int data = fis.read();

		while (data != -1) {

			zos.write(data);

			data = fis.read();
		}
		fis.close();
		
		
	}

	zos.close();	
	

	//fis.close();
		
	return zipoutfile;
	}
	
	
	
	
	

}
