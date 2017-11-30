package com.lamdaexp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Test{
	
	public static void main(String[] args) {
		
		Test1 ac=new Test1(1, "sri", 10000l);
		Test1 ac1=new Test1(2, "raju", 20000l);
		Test1 ac2=new Test1(3, "surya", 30000l);
		Test1 ac3=new Test1(4, "ravi", 40000l);
		
				
		List<Test1> aclist=new ArrayList<>();
		aclist.add(ac);
		aclist.add(ac1);
		aclist.add(ac2);
		aclist.add(ac3);
		
		
		/*Collections.sort(aclist,new Comparator<Test1>(){

			@Override
			public int compare(Test1 o1, Test1 o2) {
				
				return o1.getName().compareTo(o2.getName());
			}

					}); 
*/		
		Collections.sort(aclist,(sri1,sri2)->sri1.getName().compareTo(sri2.getName()));
		
		for (Test1 account : aclist) {
			
			System.out.println(account.getName());
			
		}
		}
		}
	

class Test1 {

	private Integer id;
	private String name;
	private long balance;
	
	
	public Test1(Integer id, String name, long balance) {
		super();
		this.id = id;
		this.name = name;
		this.balance = balance;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public long getBalance() {
		return balance;
	}
	public void setBalance(long balance) {
		this.balance = balance;
	}
	
}

