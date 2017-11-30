package com.Enum;

public class StudentType {
	
	public enum Salary
	{
		BA(1),A(2,"srikanth"),AA(3);
		
	  private	int grade1;
	  private String name;
	  
		Salary(int grade)
		{
			this.grade1=grade;
			
		}
		public int getGrade()
		{
			return this.grade1;
		}
		
		Salary(int grade,String name)
		{
			this.grade1=grade;
			this.name=name;
			
		}
		
					}
		public static void main(String[] args) {
		System.out.println(Salary.BA.grade1);
		System.out.println(Salary.A.grade1);
		
		
	}
	

}
