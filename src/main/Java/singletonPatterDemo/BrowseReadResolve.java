package singletonPatterDemo;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BrowseReadResolve {
	public static void main(String[] args) {
		try {
			BrowserSingleton instance1 = BrowserSingleton.getInstance();
			
			//Serialize the browser instance
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("browser.json"));
			out.writeObject(instance1);
			out.close();
			
			
			//De-serialize the Browser instance
			ObjectInputStream oi = new ObjectInputStream(new FileInputStream("browser.json"));
			BrowserSingleton instance2 = (BrowserSingleton) oi.readObject();
			oi.close();
			
			System.out.println("instance1 hashcode :" +instance1.hashCode());
			System.out.println("instance2 hashcode :" +instance2.hashCode());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
