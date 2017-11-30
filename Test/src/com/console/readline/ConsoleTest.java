package com.console.readline;

public class ConsoleTest {

	public static void main(String[] args) {
		
		System.out.println("Enter the Text::");
		String str=System.console().readLine();
		System.out.println(str);
		
	}
}
