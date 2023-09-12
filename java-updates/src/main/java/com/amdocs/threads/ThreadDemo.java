package com.amdocs.threads;

public class ThreadDemo {

	public static void main(String[] args) {
		
		//using extending of 
		YourThread yt = new YourThread();
		
		//It will invoke the run method by default.
		yt.start();  //Invoke the run
		
		//Using implementaion of runnable interface
		MyThead mt= new MyThead();
		Thread t1=new Thread(mt);
		t1.start();
		
		
	}

}
