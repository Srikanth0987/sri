package com.thread.runnable;

import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class Test {
	
	public static void main(String[] args) {
		
		ThreadPoolExecutor exceutor=(ThreadPoolExecutor) Executors.newFixedThreadPool(1);
		
		
		RunnableTest test=new RunnableTest();
		
		Future fu= exceutor.submit(test);
		
		
		
	}

}
