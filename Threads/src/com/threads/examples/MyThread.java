package com.threads.examples;

public class MyThread implements Runnable{

	private String threadName;
	
	public MyThread(String threadName){
		
		this.threadName = threadName;
		System.out.println("Thread " + this.threadName + " created!");
		
	}
	@Override
	public void run() {
		
		int sum = 0;
		for (int x = 1; x < 11; x++){
			
			sum += x;
			if (sum > 15){
				try {
					Thread.sleep(800);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		
		System.out.println("Sum is " + sum + " by " + this.threadName);
		
	}
	
	

}
