package com.threads;

public class Tmain {
	
	public static void main(String[] args) {
		
		StudentPojo pojo=new StudentPojo();
		
		Student123 t1=new Student123(pojo);
		Student123 t2=new Student123(pojo);
		
		t1.start();
		t2.start();
		
	}

}
