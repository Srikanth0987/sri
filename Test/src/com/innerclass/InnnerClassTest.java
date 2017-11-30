package com.innerclass;

public class InnnerClassTest {
	
public static void main(String[] args) {
	

	Runnable runnable=new Runnable()
	{
		@Override
		public void run() {
		System.out.println("hello");	
		}
		};
		
		Runnable ss=()->{
			
			//body---
			//lamda expression shortcut way 
			System.out.println("Lamda expression");
			
		};
		
		Thread tt=new Thread(ss);	
		tt.start();
		
	
Thread t=new Thread(runnable);
t.start();

Runnable r=new Test();

Thread t1=new Thread(r);
t1.start();
}

}
	

	
	

