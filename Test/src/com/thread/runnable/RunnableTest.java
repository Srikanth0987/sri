package com.thread.runnable;

public class RunnableTest implements Runnable{

	@Override
	public void run() {
		
		String str="";
		for(int i=0;i<=100;i++)
		{
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			System.out.println(Thread.currentThread().getName()+"::"+i);
			
			str=str+i;
		}
		
	}

}
