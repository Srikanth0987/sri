package com.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPoolTest {
	
	public static void main(String[] args) {
		
		ThreadPoolExecutor executor=(ThreadPoolExecutor) Executors.newFixedThreadPool(1);
		
		OurCallable callable=new OurCallable();
		
		Future<Integer> future=executor.submit(callable);
		
		int count=0;
		
		for(int i=0;i<10;i++)
		{
			
			count=count+i;
					}
		
		try {
			System.out.println(count+future.get());
			
						
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
