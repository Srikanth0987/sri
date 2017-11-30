package com.StudentAvg;

import java.nio.charset.MalformedInputException;

public class StudentTest {

	public void Student(String avg)
	{
		int data;
		if(avg=="avg")
		{
			
			data=30000;
			System.out.println("Avg salary:"+data);
		}
		else if(avg=="belowavg")
		{
			data=40000;
			System.out.println("below Avg salary:"+data);
		}
		else if(avg=="aboveavg")
		{
			data=50000;
			System.out.println("Above salary:"+data);
		}
		
	}
		

	public static void main1(String[] args) {
		StudentTest t=new StudentTest();
		t.Student("avg");
			
	}
	public void test(StudentEnum s)
	{
		if(s==s.Btech)
		{
			System.out.println("btech");
		}
		
	}
	
	public static void main(String[] args) {
		
		
	}
	
}
