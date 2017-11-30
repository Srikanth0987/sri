
package com.Enum;
public class EumCount {
	
	private enum CHAR
	{
		A(1,'a'),B(2,'b'),C(3,'c');
		
		
	private int number;
	private char c;

	CHAR(int number,char c)
	{
		this.number=number;
		this.c=c;
			
	}
	public int getNumber()
	{
			return this.number;
	}
	
	public char getC()
	{
		return this.c;
		
	}
		
	}
	public static void main(String[] args) {
		
		System.out.println(CHAR.A.c+"::"+CHAR.A.number);
		int count =0;		
		String str="abc";
		
	   CHAR[]chars=CHAR.values();
				
		for(int i=0;i<str.length();i++)
		{
			char tempch=str.charAt(i);
							
		for(int j=0;j<chars.length;j++)
		{
			if(chars[j].getC()==tempch)
			{
			count=count+chars[j].getNumber();
						
			}
			
			
		}
		}
		System.out.println(count);
		
		
	}

}
