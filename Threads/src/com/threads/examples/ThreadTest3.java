package com.threads.examples;

public class ThreadTest3 {

	public static void main(String[] args){
		
		System.out.println("Current thread is " + Thread.currentThread().getName());
		Thread3 th1 = new Thread3("thread 1");
		Thread3 th2 = new Thread3("thread 2");
		
		th1.setPriority(2);
		th2.setPriority(7);
		
		th1.start();
		th2.start();
		
		
		
	}
}
