package com.lamda2;

import java.util.HashSet;
import java.util.Set;

public class ForechTest {

	public static void main(String[] args) {
		
		Set<String> hashset=new HashSet<>();
		hashset.add("one");
		hashset.add("two");
		hashset.add("three");
		hashset.add("four");
		hashset.add("five");
		
		hashset.forEach((s1)->System.out.println(s1));
		
		}
}
