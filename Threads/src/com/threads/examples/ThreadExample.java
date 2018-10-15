package com.threads.examples;

public class ThreadExample {

	public static void main(String[] args){
		
		Counter counter = new Counter();
		
	    System.out.println("Current thread is " + Thread.currentThread().getName());
	    
	    for(int i=0; i<10; i++){
	    	
	    	new Thread("Thread " + i){
	    		
	    		public void run(){
	    			System.out.println(this.getName() + " is running.");
	    			counter.add(1);
	    			System.out.println("counter is " + counter.getCounter());
	    		}
	    	}.start();
	    	
	    }
	 }
}
