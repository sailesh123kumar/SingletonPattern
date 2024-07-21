package singletonPatterDemoTest;

import singletonPatterDemo.BrowserSingleton;

public class TestBrowserSingleTon {
	
	public static void main(String[] args) {
		
		//BrowserSingleton br = new BrowserSingleton()  //-->Compile time error to change visibility
		
		Runnable task = () -> {
			BrowserSingleton.getInstance().displayMsg();
		};
		
		Thread thread1 = new Thread(task);
		Thread thread2 = new Thread(task);
		Thread thread3 = new Thread(task);
		Thread thread4 = new Thread(task);
		Thread thread5 = new Thread(task);
		
		thread1.start();
		thread2.start();
		thread3.start();
		thread4.start();
		thread5.start();
		
		// wait for all thread to complete
		
		try {
			thread1.join();
			thread2.join();
			thread3.join();
			thread4.join();
			thread5.join();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

}
