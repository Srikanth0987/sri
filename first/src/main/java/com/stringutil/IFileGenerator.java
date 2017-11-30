package com.stringutil;

import java.util.List;


import com.first.pojo.Student;

public interface IFileGenerator {
	
	
	public String generateFile(List<Student> student,String folderpath) throws Exception;

	
}
