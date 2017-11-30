package com.staticimport;

import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.sort;
import static java.sql.DriverManager.getConnection;





public class Test {
	
	public static void main(String[] args) {
		
		ArrayList al=new ArrayList();
		al.add("b");
		al.add("c");
		al.add("a");
		
		Collections.sort(al);
		for (Object object : al) {
			
			System.out.println(object);
			
						
			//getConnection("");
				}
		
	}

}
