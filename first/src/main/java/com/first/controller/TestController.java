package com.first.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.first.pojo.Student;

@RestController
public class TestController {

	@RequestMapping("getData")
	public String getData(){
		return "Helllo we are in slokam tech.";
	}
	
	@RequestMapping("getArrayData")
	public String[] getArrayData(){
		String arr[]={"abc","bca","dca","asdf"};
		return arr;
	}
	
	@RequestMapping("getStudentData")
	public Student getStudentData(){
		  Student std = new Student("name", 11, "MMM", 234234L);
		return std;
	}
	
	@RequestMapping("getStudentList")
	public List<Student> getStudentList(){
		  
		  Student std1 = new Student("name1", 11, "MMM1", 1234234L);
		  Student std2 = new Student("name2", 12, "MMM2", 2234234L);
		  Student std3 = new Student("name3", 13, "MMM3", 3234234L);
		  Student std4 = new Student("name4", 14, "MMM4", 4234234L);
		  Student std5 = new Student("name5", 15, "MMM5", 5234234L);
		  
		  List<Student> students = new ArrayList<>();
		  students.add(std1);
		  students.add(std2);
		  students.add(std3);
		  students.add(std4);
		  students.add(std5);
		  
		return students;
	}
	
	@RequestMapping("getMapData")
	public Map<Integer, Student> getMapData(){
		
		  Student std1 = new Student("name1", 11, "MMM1", 1234234L);
		  Student std2 = new Student("name2", 12, "MMM2", 2234234L);
		  Student std3 = new Student("name3", 13, "MMM3", 3234234L);
		  Student std4 = new Student("name4", 14, "MMM4", 4234234L);
		  Student std5 = new Student("name5", 15, "MMM5", 5234234L);
		
		Map<Integer, Student> map = new HashMap<>();
		map.put(1, std1);
		map.put(2, std2);
		map.put(3, std3);
		map.put(4, std4);
		map.put(5, std5);
		return map;
	}
	
	
	
	
	
	
	
	
	
	
}
