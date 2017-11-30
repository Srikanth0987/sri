package com.lamdaexp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class CompTest {

	public static void main(String[] args) {
		
		
		ArrayList al=new ArrayList();  
		al.add(new Student(101,"Vijay",23));  
		al.add(new Student(106,"Ajay",27));  
		al.add(new Student(105,"Jai",21));  
		  
		System.out.println("Sorting by Name...");  
		  
		Collections.sort(al,new NameComparator());  
						
		Iterator itr=al.iterator();  
		while(itr.hasNext()){  
		Student st=(Student)itr.next();  
		System.out.println(st.rollno+" "+st.name+" "+st.age);  
		}  
		  
		System.out.println("sorting by age...");  
		  
	}
}
