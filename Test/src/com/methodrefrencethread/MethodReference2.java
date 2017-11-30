package com.methodrefrencethread;

import java.util.concurrent.Callable;

import org.omg.Messaging.SyncScopeHelper;

public class MethodReference2 {
	
	public static void abc()
	{
		System.out.println("static abc::");
	}
	public static void main(String[] args) {
		
		Thread t=new Thread(new test());
		t.start();
		
		Thread t1=new Thread(new Runnable() {
				
			public void run() {
				
			System.out.println("runnable interface implementation");
			
			}
		});
		
		t1.start();
		
		Thread t2=new Thread(()->System.out.println("lamda expression...."));
		
		
		Thread t3=new Thread(MethodReference2::abc);
		
		System.out.println("MethodReference2::");
		
		
		 
	}
	

}

class test implements Runnable
{

	@Override
	public void run() {
		
		System.out.println("Runnable run method");
	}
	
	
	
}

class test2 implements Callable
{

	@Override
	public Object call() throws Exception {
		
		String s="hello";
		return s;
	}
	
	
	
}

