package com.varagrs;

public class VarArgsTest {
	
	public static void sri(char c,String s,Object...o)
	{
	
		for (Object object : o) {
			
			System.out.println(object);
		}
		}
	
	public static void main(String[] args) {
		
		sri('c',"a","b","c");
		
		
	}

}
