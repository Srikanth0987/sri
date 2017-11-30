package com.threads;

public class ThreadTest extends Thread{
	
	
	@Override
	public void run() {
	
		for(int i=0;i<=5;i++)
		{
			System.out.println(Thread.currentThread().getName()+"**"+i);
		}
	
	}
	public static void main(String[] args) {
		
		ThreadTest t1=new ThreadTest();
		
		ThreadTest t2=new ThreadTest();
		
		t1.start();
		
		t2.start();
		
	}

}
