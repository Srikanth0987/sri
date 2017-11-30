package com.genrics;

public class OurGenricArry<T> {

	private Object values[]=new Object[10];
	
	int count=0;
	
	public void  add(T object)
	{
		if(count==values.length)
		{
		
		Object[] temp=new Object[values.length*2];
			
		for(int i=0;i<values.length;i++)
		{
			temp[i]=values[i];
						
		}
			values=temp;
			
		}
		values[count]=object;	
		count++;
			
	}
	
	public Object get(int index)
	{
		return values[index];
				
				}
	public int size()
	{
		
		return count;
		
		
	}
	
}
