package com.stringutil;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.first.pojo.Student;
import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class FileGenerator {
	public static void GeneratePdf(String filepath,List<Student> studentlist) throws FileNotFoundException,Exception
	{
		Document doc = new Document();
		FileOutputStream fos = new FileOutputStream( filepath);
		PdfWriter.getInstance(doc, fos);
		doc.open();
		Paragraph para = new Paragraph("Sample text........");

		PdfPTable ptab = new PdfPTable(6);

		for (Student std : studentlist) {
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
	
	}
	
	public static void GenerateDoc(String filepath,List<Student> studentlist) throws Exception
	{
		FileOutputStream fos = new FileOutputStream(filepath);
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph para = document.createParagraph();
		XWPFRun run = para.createRun();
		run.setText("welcome to microsoft document...");
		
		
		XWPFTable table = document.createTable();
		
		for (Student student : studentlist) {
			
			XWPFTableRow row = table.createRow();
			row.addNewTableCell().setText(student.getName());
			row.addNewTableCell().setText(student.getAge() + "");
			row.addNewTableCell().setText(student.getQual());
			row.addNewTableCell().setText(student.getPhone() + "");
			row.addNewTableCell().setText(student.getPin() + "");

		}
		document.write(fos);
		fos.close();
	
	}
	public static void GenerateXls(String filepath,List<Student> studentlist) throws Exception
	{
		FileOutputStream fos = new FileOutputStream(filepath);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("WorkSheet");
			for(int i=0;i<studentlist.size();i++)
		{
			HSSFRow row = sheet.createRow(i);
			row.createCell(0).setCellValue(studentlist.get(i).getName());
			row.createCell(1).setCellValue(studentlist.get(i).getAge());
			row.createCell(2).setCellValue(studentlist.get(i).getQual());
			row.createCell(3).setCellValue(studentlist.get(i).getPhone());
			row.createCell(4).setCellValue(studentlist.get(i).getPin());
						
		}
		fos.close();
		workbook.close();
	}
	
}
