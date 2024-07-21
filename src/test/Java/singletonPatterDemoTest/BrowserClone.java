package singletonPatterDemoTest;

import singletonPatterDemo.BrowserSingleton;

public class BrowserClone {
	
	public static void main(String[] args) {
		BrowserSingleton instance1 = BrowserSingleton.getInstance();
		try {
			BrowserSingleton instance2 = (BrowserSingleton)instance1.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	

}
