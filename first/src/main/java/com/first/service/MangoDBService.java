package com.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.first.Dao.StudentDAO;
import com.first.exception.DefalutNameException;
import com.first.pojo.Student;

@Service

public class MangoDBService implements IStudentService {

	@Autowired
	private StudentDAO studentDAO;
		
	public Student getStudentById(Integer id)
	{
		return null;
	}
	
	public List<Student> getAllStudents(){
		return null;
	}
	
	public Student getsavedata( Student student)
	{
		
	List<Student> findstudent=studentDAO.findByName(student.getName());
	
	if(findstudent.size()>0)
	{
		try {
			throw new DefalutNameException();
		} catch (DefalutNameException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
	studentDAO.save(student);

		return student;
		}
		
	public void deletedata(Student student)
	{
		studentDAO.delete(student);
		
			}
	public void updatedata(Student student)
	{
		studentDAO.save(student);
		
		}
	
	public void getStudents(List<Student> students)
	{
		studentDAO.save(students);
	
	}

	/*@Override
	public List<Student> getdata() {
		// TODO Auto-generated method stub
		return studentDAO.getData();
	}*/

	@Override
	public List<Student> getdata(String name, Integer id) {
		// TODO Auto-generated method stub
		return studentDAO.getData(name,id);
	}

	@Override
	public List<Student> pagerequest(Integer PageNo, Integer PageSize) {
		
		return null;
	}

	

}
