
package com.stringutil;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.first.pojo.Student;

public class XlsFileGenerator implements IFileGenerator {

	@Override
	public String generateFile(List<Student> student, String folderpath) throws Exception {
	
		String file=System.currentTimeMillis()+".xls";
	
		FileOutputStream fos = new FileOutputStream(folderpath+"\\"+file);
		HSSFWorkbook workbook = new HSSFWorkbook();
		HSSFSheet sheet = workbook.createSheet("WorkSheet");
				
			for(int i=0;i<student.size();i++)
		{
			HSSFRow row = sheet.createRow(i);
			row.createCell(0).setCellValue(student.get(i).getName());
			row.createCell(1).setCellValue(student.get(i).getAge());
			row.createCell(2).setCellValue(student.get(i).getQual());
			row.createCell(3).setCellValue(student.get(i).getPhone());
			row.createCell(4).setCellValue(student.get(i).getPin());
						
		}
		workbook.write(fos);
		workbook.close();
		fos.close();
		
	
		return file;
	}

}
