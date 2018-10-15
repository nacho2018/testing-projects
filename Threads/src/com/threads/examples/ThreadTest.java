package com.threads.examples;

public class ThreadTest {

	
	public static void main(String[] args){
		
		MyThread th1 = new MyThread("Thread-1");
		MyThread th2 = new MyThread("Thread-2");
		
		
		th1.run();
		th2.run();
	}
}
