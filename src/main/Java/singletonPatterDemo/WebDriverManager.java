package singletonPatterDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebDriverManager {

	private volatile static WebDriverManager instance;
	private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();

	private WebDriverManager() {

	}

	private void initDriver(String browser) {
		switch (browser.toLowerCase().trim()) {
		case "chrome":
			tlDriver.set(new ChromeDriver());
			break;

		case "firefox":
			tlDriver.set(new FirefoxDriver());
			break;

		case "edge":
			tlDriver.set(new EdgeDriver());
			break;

		default:
			throw new RuntimeException("Please passs the right Browser...");
		}

	}

	public static WebDriverManager getInstance(String browser) {
		if (instance == null) {
			synchronized (WebDriverManager.class) {
				if (instance == null) {
					instance = new WebDriverManager();
				}

			}
		}

		if (tlDriver.get() == null) {
			instance.initDriver(browser);
		}

		return instance;

	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public static void quitBrowser() {
		if (tlDriver.get() != null) {
			tlDriver.get().quit();
			tlDriver.remove();
		}
	}

}
