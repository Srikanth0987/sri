package com.stringutil;

import java.io.FileOutputStream;
import java.util.List;

import com.first.pojo.Student;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class PDFFileGenerator implements IFileGenerator{

	@Override
	public String generateFile(List<Student> student, String folderpath) throws Exception {
		
		String file=System.currentTimeMillis()+".pdf";
		
		
		Document doc = new Document();
		FileOutputStream fos = new FileOutputStream( folderpath+"\\"+file);
		PdfWriter.getInstance(doc, fos);
		doc.open();
		Paragraph para = new Paragraph("Sample text........");

		PdfPTable ptab = new PdfPTable(6);

		for (Student std : student) {
			ptab.addCell(std.getId() + "");
			ptab.addCell(std.getName());
			ptab.addCell(std.getAge() + "");
			ptab.addCell(std.getQual());
			ptab.addCell(std.getPhone() + "");
			ptab.addCell(std.getPin() + "");
		}
		
		
		
		

		doc.add(para);
		doc.add(ptab);
		doc.close();
		return file;
	}
	
	
	
	 

}
