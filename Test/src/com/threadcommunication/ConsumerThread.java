package com.threadcommunication;

public class ConsumerThread extends Thread
{
	private Bucket bucket=null;
	
	public ConsumerThread(Bucket bucket)
	{
		this.bucket=bucket;
		}
	
	@Override
	public void run() {
		
				for(int i=0;i<=50;i++)
		{
			String water=bucket.getWater();
			System.out.println("getting water"+i);
		}
		
	}

}
