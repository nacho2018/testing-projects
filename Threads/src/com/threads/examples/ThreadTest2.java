package com.threads.examples;

public class ThreadTest2 {

	public static void main(String[] args){
		
		ThreadPro th1 = new ThreadPro("Thread-1");
		ThreadPro th2 = new ThreadPro("Thread-2");
		
		th1.start();
		th2.start();
	}
}
