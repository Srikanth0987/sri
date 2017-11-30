package com.innerclass;

public interface ABC {
	
	public int add(int a,int b);

}
class test implements ABC
{
	
	
	public static void main(String[] args) {
		
		ABC a=new ABC() {
			
			public int add(int a, int b) {
				
				int c=a+b;
					
				return c;
				
			}
		};
		System.out.println(a.add(1, 2));
		
	}

	@Override
	public int add(int a, int b) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
}