package singletonPatterDemoTest;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import singletonPatterDemo.BrowserSingleton;

public class TestBrowserSingletowithReflectionAPI {
	
	public static void main(String[] args) {
		
		BrowserSingleton instance1 = BrowserSingleton.getInstance();
		BrowserSingleton instance2 = null;
		
		
		
			
			try {
				Constructor<BrowserSingleton> constructor = BrowserSingleton.class.getDeclaredConstructor();
				constructor.setAccessible(true);
				instance2 = constructor.newInstance();
				
				System.out.println("instance1 hashcode :" +instance1.hashCode());
				System.out.println("instance2 hashcode :" +instance2.hashCode());
				
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		
		
		
	}

}
