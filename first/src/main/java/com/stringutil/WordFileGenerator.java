package com.stringutil;

import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;

import com.first.pojo.Student;

public class WordFileGenerator implements IFileGenerator {

	@Override
	public String generateFile(List<Student> student, String folderpath) throws Exception {
		
		String file=System.currentTimeMillis()+".doc";
		FileOutputStream fos = new FileOutputStream(folderpath+"\\"+file);
		XWPFDocument document = new XWPFDocument();
		XWPFParagraph para = document.createParagraph();
		XWPFRun run = para.createRun();
		run.setText("welcome to microsoft document...");
		
		
		XWPFTable table = document.createTable();
		
		for (Student student1 : student) {
			
			XWPFTableRow row = table.createRow();
			row.addNewTableCell().setText(student1.getName());
			row.addNewTableCell().setText(student1.getAge() + "");
			row.addNewTableCell().setText(student1.getQual());
			row.addNewTableCell().setText(student1.getPhone() + "");
			row.addNewTableCell().setText(student1.getPin() + "");

		}
		document.write(fos);
		fos.close();
		return file;
	}

}
