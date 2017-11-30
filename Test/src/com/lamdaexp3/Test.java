package com.lamdaexp3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
	
	public static void main(String[] args) {
		
		Person p1=new Person(101, "Hyd", "sai", QualEnum.TEN);
		Person p2=new Person(101, "wgl", "ravi", QualEnum.MCA);
		Person p3=new Person(101, "karimnagar", "surya", QualEnum.BSC);
		Person p4=new Person(101, "Hanamkonda", "srikanth", QualEnum.TWE);
		
		List<Person> list=new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);
		list.add(p4);
		
	Collections.sort(list,(person1,person2)->{
		 
	  int w= person1.getQual().getValue();
	  int w1=person2.getQual().getValue();
	 
	 return w-w1;
				
	});
		list.forEach((person3)->System.out.println(person3.getQual()+"::"+person3.getName()+"::"+person3.getLocation()));
		
	}
}
