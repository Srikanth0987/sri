package com.threadcommunication;

public class Bucket {
	
	private boolean filled;
	
	public  boolean isFilled() {
		return filled;
	}
	public  void setFilled(boolean filled) {
		this.filled = filled;
	}
	public synchronized String getWater() {
		
		if(filled==true) //consumer water...
		{
			try {
				wait();
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
		String data=this.water;
		filled=true;
		notifyAll();
		System.out.println();
		return data;
	}
	public synchronized void setWater(String water) {
		if(filled==false)
		{
			try {
				wait();
			} catch (InterruptedException e) {
				// 
				e.printStackTrace();
			}
		}
		
	this.water = water;
	filled=false;
	notifyAll();
	}
	private String water;
	
}
