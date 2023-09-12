package com.amdocs.threads;

public class MyThead implements Runnable{

	@Override
	public void run() {
		for (int i = 0; i <= 5; i++) {
			//Scheduling the thread
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Thank You...");
		}
		
	}

}
