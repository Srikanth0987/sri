package com.threadcommunication;

public class ProducerThread extends Thread{
	private Bucket bucket=null;

	public ProducerThread(Bucket bucket)
	{
		this.bucket=bucket;
		
			}
			@Override
		public void run() {
		
		for(int i=0;i<=50;i++)
		{
			
			bucket.setWater("setting water"+i);
			
			System.out.println("setting water:"+i);
		}
		
	}

}
