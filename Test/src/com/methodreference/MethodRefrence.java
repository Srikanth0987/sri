package com.methodreference;

public class MethodRefrence {
	
	public static void dowork()
	{
		System.out.println("Static method");
		
	}
	public static void main(String[] args) {
		
		Syable s=MethodRefrence::dowork;
		s.say();
		}
}
