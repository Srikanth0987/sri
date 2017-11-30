package com.Annotations;

public class Test2 extends Test
{	
	@Override
	public void m3()
	{
		System.out.println("Test2:m1 method3");
	}
	public static void main(String[] args) {
	
		Test t=new Test2();
		t.m1();
		t.m2();
		
		
	}
	
}
