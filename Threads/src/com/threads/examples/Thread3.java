package com.threads.examples;

public class Thread3 extends Thread{
	
	private String name;
	
	public Thread3(String name){
		
		this.name = name;
		System.out.println("Thread " + this.name + " is created.");
	}
	
	public void run(){
		
		System.out.println("Thread " + this.name + " is running.");
		
	}

}
