package com.first.service;

import java.util.List;
import com.first.exception.DefalutNameException;
import com.first.pojo.Student;

public interface IStudentService {

	public Student getStudentById(Integer id);

	public List<Student> getAllStudents();

	public Student getsavedata(Student student);

	public void deletedata(Student student);

	public void updatedata(Student student);

	public void getStudents(List<Student> students);
	
	public List<Student> getdata(String name,Integer id);
	
	public List<Student> pagerequest(Integer PageNo,Integer PageSize); 
	
}
