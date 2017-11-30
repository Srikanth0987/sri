package com.first.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.first.pojo.Student;
import com.first.service.IStudentService;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.stringutil.FileGenerator;
import com.stringutil.FileGeneratorUtil;

@RestController
public class FileUploadContoller {

	@Autowired
	@Qualifier("studentService")
	
	private IStudentService Service;

	@RequestMapping("fileupload")
	public void test(MultipartFile multipartFile) {

		String name = multipartFile.getOriginalFilename();

		try {

			multipartFile.transferTo(new File("D://uploads//" + name));
			File file = new File("D://uploads//" + name);
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line = br.readLine();

			while (line != null) {
				String[] values = line.split(" ");
				Student student = new Student();
				student.setName(values[0]);
				student.setAge(Integer.parseInt(values[1]));
				student.setQual(values[2]);
				student.setPhone(Long.parseLong(values[3]));
				student.setPin(Integer.parseInt(values[4]));
				Service.getsavedata(student);
				line = br.readLine();
			}

		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("File Name is::" + name);
	}

	@RequestMapping("filedownload//{fileno}")
	public void test2(HttpServletResponse res, @PathVariable("fileno") Integer fileid) {
		try {
			
			File files=new File("D://uploads//");
			String[] filename= files.list();

			res.addHeader("Content-Disposition", "attachment;filename="+filename[fileid]);

			PrintWriter pw = res.getWriter();

			FileInputStream fis = new FileInputStream("D://uploads//" +filename[fileid]);

			int data = fis.read();

			while (data != -1) {

				pw.write(data);

				data = fis.read();
			}
			fis.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}	
		
	@RequestMapping(value = "/allstudentdownload", method = RequestMethod.GET)
	public void getDowanloadFileAllStudents(HttpServletResponse response) throws IOException {
		{
			List<Student> students = Service.getAllStudents();
			String fileName = "temp" + System.currentTimeMillis();//.xls
			
			FileOutputStream fos=new FileOutputStream("D://uploads//" +fileName);
			FileWriter fw = new FileWriter(fileName);
			BufferedWriter bw = new BufferedWriter(fw);
			for (Student student : students) {

				String line = student.getId() + "," + student.getName() + "," + student.getAge() + ","
						+ student.getQual() + "," + student.getPhone() + "," + student.getPin();
				bw.write(line);
				bw.newLine();
			}
			
			bw.close();

			response.addHeader("Content-Disposition", "attachment;filename=" + fileName);

			PrintWriter pw = response.getWriter();

			FileInputStream fis = new FileInputStream(fileName);

			int data = fis.read();

			while (data != -1) {

				pw.write(data);

				data = fis.read();
			}
			fis.close();
			fos.close();

		}
		
			}
	
	@RequestMapping(value = "/allExcelfile", method = RequestMethod.GET)
	public void ExcelFile(HttpServletResponse response) throws IOException
	{
		PrintWriter pw = response.getWriter();
		
		List<Student> studentlist = Service.getAllStudents();
				
		String fileName = "temp" + ".xls";

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
	
		/*HSSFRow row = sheet.createRow(0);
		row.createCell(0).setCellValue("1");
		row.createCell(1).setCellValue("srikanth");
		row.createCell(2).setCellValue("MCA");
		row.createCell(3).setCellValue("Hanamkonda");
		row.createCell(4).setCellValue("506001");
		*/
		
		
		try {
			
			FileOutputStream fos = new FileOutputStream("D:\\temp\\" + fileName);
			workbook.write(fos);
		
			workbook.close();
			response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
			FileInputStream fis = new FileInputStream("D:\\temp\\" +fileName);

			int data = fis.read();

			while (data != -1) {

				pw.write(data);

				data = fis.read();
			}
			fis.close();
			fos.close();

		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@RequestMapping(value = "/allPdffile", method = RequestMethod.GET)
	public void PdfFile(HttpServletResponse response) throws Exception, DocumentException {

		List<Student> studentlist = Service.getAllStudents();
		String fileName = "temp" + ".pdf";

		Document doc = new Document();
		FileOutputStream fos = new FileOutputStream("D:\\temp\\" + fileName);
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
		
		PrintWriter pw = response.getWriter();
		response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
		FileInputStream fis = new FileInputStream("D:\\temp\\" + fileName);

		int data = fis.read();

		while (data != -1) {

			pw.write(data);

			data = fis.read();
		}
		fis.close();
		fos.close();

	}	

	@RequestMapping(value = "/docFile", method = RequestMethod.GET)
	public void DocFile(HttpServletResponse response) throws IOException, DocumentException {

		List<Student> studentlist = Service.getAllStudents();
		String fileName = "temp" + ".doc";

		FileOutputStream fos = new FileOutputStream("D:\\temp\\" + fileName);
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
		PrintWriter pw = response.getWriter();
		response.addHeader("Content-Disposition", "attachment;filename=" + fileName);
		FileInputStream fis = new FileInputStream("D:\\temp\\" + fileName);

		int data = fis.read();

		while (data != -1) {

			pw.write(data);

			data = fis.read();
		}
		fis.close();
		
	}
	
	@RequestMapping(value = "/AllFiles/{filetype}", method = RequestMethod.GET)
	public void getAllFiles(HttpServletResponse response,@PathVariable String filetype) throws Exception
		{
		List<Student> studentlist = Service.getAllStudents();
		String filename="temp" +System.currentTimeMillis();
		String filepath=null;		
		switch(filetype){
		case "pdf":{
			filename=filename+".pdf";
			filepath="D:\\temp\\"+filename;
			FileGenerator.GeneratePdf(filepath, studentlist);
		}//case:1
		break;
		
		case "doc":{
			
			filename=filename+".doc";
			filepath="D:\\temp\\"+filename;
			FileGenerator.GenerateDoc(filepath, studentlist);

			break;
		}//case: 2
		
		case "xls":{
			filename=filename+".xls";
			filepath="D:\\temp\\"+filename;
			FileGenerator.GenerateXls(filepath, studentlist);
	
		}//case:3
				}//switch
		
		PrintWriter pw = response.getWriter();
		response.addHeader("Content-Disposition", "attachment;filename=" + filename);
		FileInputStream fis = new FileInputStream(filepath);

		int data = fis.read();

		while (data != -1) {

			pw.write(data);

			data = fis.read();
		}
		fis.close();
		
	}	
	
	@RequestMapping(value = "/AllDoc/{filetype}", method = RequestMethod.GET)
	public void AllDoc(HttpServletResponse resp, @PathVariable String filetype) throws Exception {
		List<Student> student = Service.getAllStudents();
		String folderpath = "D:\\temp\\folderpath_" + System.currentTimeMillis();
		File file = new File(folderpath);
		file.mkdirs();
				
		String fos= FileGeneratorUtil.FileFileGenerator(resp, filetype, student, folderpath);
		
		
		resp.addHeader("Content-Disposition", "attachment;filename=abc.zip");
				
		FileInputStream fis = new FileInputStream(fos);
		
		PrintWriter pw = resp.getWriter();

		int data = fis.read();

		while (data != -1) {

			pw.write(data);

			data = fis.read();
		}

		fis.close();
	}

}
