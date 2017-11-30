package com.first.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import com.first.Dao.StudentDAO;
import com.first.exception.DefalutNameException;
import com.first.pojo.Student;
import com.stringutil.AuditUtil;
import com.stringutil.StringUtil;

@Service
@Primary
public class StudentService implements IStudentService {
    @Autowired
	private AuditUtil aut;
	
	@Autowired
	private StudentDAO studentDAO;

	@Autowired
	StringUtil ut;

	public Student getStudentById(Integer id) {
		return studentDAO.findOne(id);
	}

	public List<Student> getAllStudents() {

		ut.sample();

		return studentDAO.findAll();
	}

	/*public Student getsavedata(Student student) {

		List<Student> findstudent = studentDAO.findByName(student.getName());

		if (findstudent.size() > 0) {

		}

		studentDAO.save(student);

		return student;
	}
*/
	@Transactional	
	public Student getsavedata(Student student)
	{

		List<Student> findstudent = studentDAO.findByName(student.getName());
		
		if(student.getId()!=null)
		{
			Student oldstudent=this.getStudentById(student.getId());
			aut.Audit(oldstudent, student);
			
		}
		
		if (findstudent.size() > 0) {

		}

		studentDAO.save(student);

		

		
		return student;
	}
	
	
	public void deletedata(Student student) {
		studentDAO.delete(student);

	}

	public void updatedata(Student student) {
		studentDAO.save(student);

	}

	public void getStudents(List<Student> students) {
		studentDAO.save(students);

	}
	  @Override
	public List<Student> getdata(String name, Integer id) {

		return studentDAO.getData(name, id);
	}
	 
	 public List<Student> pagerequest(Integer PageNo,Integer PageSize) {
		 
		 PageRequest page=new PageRequest(PageNo, PageSize);
		 
		 Page<Student> pagestudents=  studentDAO.findAll(page);
		 return pagestudents.getContent();
		 		 
		}

}
