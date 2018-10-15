package com.threads.examples;

public class ThreadPro extends Thread{
	
	private String threadName;
	
	public ThreadPro(String threadName){
		
		this.threadName = threadName;
		System.out.println("Thread " + this.threadName + " created!");
		
		
	}

	public void run(){
		
		System.out.println("Thread: " + this.threadName + " is running.");
		try {
			Thread.sleep(800);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
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
