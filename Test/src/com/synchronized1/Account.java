package com.synchronized1;

public class Account {
	
	private long amount;
	private long balance;
	
	public void setBalance(long balance) {
		this.balance = balance;
	}

	public void Deposit(Account account)
	{
		this.amount=this.balance+amount;
		
	}
	
	public void withdraw(Account account)
	{
		
		this.amount=this.balance-amount;
	}
	
	public long getbalance()
	{
		return balance;
		
		
	}

}
