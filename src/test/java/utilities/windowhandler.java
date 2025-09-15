package utilities;

import java.util.Set;

import org.openqa.selenium.WebDriver;

import pageobjects.Basepage;

public class windowhandler extends Basepage {

	public windowhandler(WebDriver driver) {
		super(driver);
	}
	
	public static void switchwindow(WebDriver driver) {
		String parentwindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		System.out.println("Parent window title: " + driver.getTitle());
		for(String window: allwindows) {
			if(!window.equals(parentwindow)) {
				driver.switchTo().window(window);
				System.out.println("Switched to window: " + driver.getTitle());
				return;
		}
	}
	}
	
	public static String getcurrentwindowtitle(WebDriver driver) {
		return driver.getTitle();
	}
	
	public static void closesubwindow( WebDriver driver) {
		String parentWindow = driver.getWindowHandle();
		Set<String> allwindows = driver.getWindowHandles();
		 System.out.println("Parent window title before closing child windows: " + driver.getTitle());
		for(String window : allwindows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				System.out.println("close window: " + driver.getTitle());
				driver.close();		
			}
		}
		driver.switchTo().window(parentWindow);
        System.out.println("Switched back to parent window: " + driver.getTitle());
	}
	
	public static void closespecificwindow(WebDriver driver, String windowtitletoclose) {
		Set<String> window = driver.getWindowHandles();
		for(String  specificwindow : window) {
			driver.switchTo().window(specificwindow);
			if(driver.getTitle().equals(windowtitletoclose)) {
				System.out.println("Closing window: " + driver.getTitle());
	            driver.close();
	            return;
			}
		}
	}
	
}
