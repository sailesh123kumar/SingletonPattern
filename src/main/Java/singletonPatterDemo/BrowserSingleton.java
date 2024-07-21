package singletonPatterDemo;

import java.io.Serializable;

public class BrowserSingleton implements Serializable,Cloneable{
	
	// 1. Private static instance of the class
	private volatile static BrowserSingleton instance;  //to read and create thread properly volatile keyword is used
	
	//2.Private constructor to prevent/avoid instantiation of object
	private BrowserSingleton() {
		if (instance != null) {//handling reflection ap1
			throw new IllegalArgumentException("Object already exists");   //Corner case and to avoid object creation using reflection api
		}
		
	}
	
	//3.public static method to provide access to the instance/object
	public static BrowserSingleton getInstance() {
		if(instance == null) {
			synchronized (BrowserSingleton.class) {    //Thread safety on the first time and also for multi threading instantiation
				if(instance==null) {
					instance = new BrowserSingleton();
				}
			}
		}
		return instance;
	}
	
	//Individual method of class
	public void displayMsg() {
		System.out.println("browser info");
	}
	
	//Add readResolve() - which will be calling during De-Serialization process -- this will return class instance
	protected Object readResolve() {
		return getInstance();
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException("singleton instance cannot be cloned...");
	}
	
	
	

}
