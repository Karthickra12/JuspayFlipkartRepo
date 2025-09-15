package testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.commons.text.RandomStringGenerator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Baseclass {

	public static WebDriver driver;
	public static Properties prop;
	
	
	@BeforeClass
	public void setup() throws FileNotFoundException {
		
		FileInputStream fis = new FileInputStream("./src//test//resources//config.properties");
		 prop = new Properties();
		 try {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		 driver = new ChromeDriver();
		 driver.get(prop.getProperty("url"));
		 driver.manage().window().maximize();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 
	}
	
	
	@AfterClass
	public void Teardown() {
		if(driver != null) {
			driver.quit();
		}
	}
	
	

}
