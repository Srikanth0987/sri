package com.threads;

public class Student123 extends Thread{
	
	private StudentPojo pojo=new StudentPojo();
	
	public Student123 (StudentPojo pojo)
	{
		this.pojo=pojo;
	}
	
    @Override
	public void run() {
	
    	System.out.println(pojo);	

		
	}
	
}
