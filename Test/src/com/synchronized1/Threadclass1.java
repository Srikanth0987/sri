package com.synchronized1;

public class Threadclass1 extends Thread{
	
	Account account=null;
	
	public Threadclass1(Account account)
	{
		this.account=account;
		
	}
		@Override
	public void run() {
		
		for(int i=1;i<=10;i++)
		{
			account.Deposit(account);
			
			System.out.println("Deposit::"+i);
			
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
			
		}
		
				
		}
	

}
