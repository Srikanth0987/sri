package com.byfunction;

import java.util.function.BiFunction;

public class ByFunctionTest {

	public static int add(int a,int b)
	{
		return a+b;
		
		}
	public static float sub(int a,int b)
	{
		return a-b;
		
		}
	
	
	public static double mul(int a,double b)
	{
		return a*b;
		
	
	}
	
	
	public static double div(int a,double b)
	{
		return a/b;
		
	
	}
	
	public static void main(String[] args) {
		
		BiFunction<Integer, Integer,Integer>bi=ByFunctionTest::add;
		
		System.out.println(bi.apply(10, 5));
		
		
 BiFunction<Integer, Integer,Float>bi1=ByFunctionTest::sub;
		
  System.out.println(bi1.apply(10, 5));
		
  BiFunction<Integer, Double,Double> bi2=ByFunctionTest::mul;
	
  System.out.println(bi2.apply(10, (double) 5));
	
		
		
	}
	

	
}
