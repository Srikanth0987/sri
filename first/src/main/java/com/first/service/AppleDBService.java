package com.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.first.Dao.StudentDAO;
import com.first.pojo.Student;

public class AppleDBService implements IStudentService{
	
	@Autowired
	private StudentDAO studentDAO;
	
	@Override
	public Student getStudentById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getsavedata(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletedata(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatedata(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getStudents(List<Student> students) {
		// TODO Auto-generated method stub
		
	}

	/*@Override
	public List<Student> getdata() {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public List<Student> getdata(String name, Integer id) {
		
		return null;
	}

	

	@Override
	public List<Student> pagerequest(Integer PageNo, Integer PageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	
}
