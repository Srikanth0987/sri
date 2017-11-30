package com.synchronized1;

public class Threadclass2 extends Thread{
	
	Account account =new Account();
	
	public Threadclass2(Account account)
	{
		this.account=account;
		
	}
	
		@Override
	public void run() {
		for(int i=1;i<=10;i++)
		{
			account.withdraw(account);
			
			System.out.println("withdraw::"+i);
			
				}
				}

}
