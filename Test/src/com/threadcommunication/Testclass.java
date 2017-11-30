package com.threadcommunication;

public class Testclass {

	public static void main(String[] args) {
		
		Bucket bucket=new Bucket();
		
		ProducerThread producer=new ProducerThread(bucket);
		
		ConsumerThread consumer=new ConsumerThread(bucket);
		
		producer.start();
		
		consumer.start();
		
	}
}
