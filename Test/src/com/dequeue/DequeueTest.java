package com.dequeue;

import java.util.Deque;
import java.util.LinkedList;

public class DequeueTest {

	public static void main(String[] args) {
		
		Deque dq=new LinkedList<>();
		dq.addFirst("1");
		dq.addFirst("2");
		dq.addFirst("6");
		dq.addLast("10");
		dq.removeFirst();
		
	
		System.out.println(dq);
		
	}
	
}
