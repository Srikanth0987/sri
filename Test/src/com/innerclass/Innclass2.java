package com.innerclass;
public class Innclass2 {
		
		public static void main(String[] args) {
			
			ABC a=new ABC() {
				
				public int add(int a, int b) {
					int c=a+b;
						
					return c;
					
				}
			};
			System.out.println(a.add(1, 2));
		
		

		/*@Override
		public int mult(int a, int b) {
			
			int c=a*b;
			
			return c;
		}
		*/
		sri s=(int a1,int b1)->{
			
			int d=a1*b1;
			
			return d;
			
		
			};	
			System.out.println(s.mult(1, 2));
		}
}


interface sri{
	
	public int mult(int a,int b);
	
}