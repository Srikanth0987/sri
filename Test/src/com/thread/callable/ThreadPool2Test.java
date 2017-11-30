package com.thread.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadPool2Test {
	
	public static void main(String[] args) throws InterruptedException, ExecutionException {
		
		ThreadPoolExecutor executor=(ThreadPoolExecutor)Executors.newFixedThreadPool(3);
		
		CallableTest test1=new CallableTest();
		
		Future<String> result1= executor.submit(test1);
		
		
		CallableTest test2=new CallableTest();
		
		Future<String> result2= executor.submit(test2);
		
		CallableTest test3=new CallableTest();
		
		Future<String> result3= executor.submit(test3);
			
		
		System.out.println(result1.get());
		System.out.println(result2.get());
		System.out.println(result3.get());
		
		executor.shutdown();
		
		
		
		//only one thread going to be created in thread pool then call the call()
		//runnable thread going to be created then call the run method tightly coupled.
		//task and threads are decoupled both are different.
				
	}

}
