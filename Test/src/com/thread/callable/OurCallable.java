package com.thread.callable;

import java.util.concurrent.Callable;

public class OurCallable implements Callable<Integer> {

	@Override
	public Integer call() throws Exception {
		
		int count=0;
		
		for(int i=0;i<10;i++)
		{
			Thread.sleep(50);
		
			count=count+i;
		}
		return count;
				
				
	}

}
