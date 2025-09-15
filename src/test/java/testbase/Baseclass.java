package testbase;

import java.awt.Desktop;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
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
	
	@AfterSuite
    public void openReport() {
        try {
            File htmlFile = new File("test-output/emailable-report.html");
            if (htmlFile.exists()) {
                Desktop.getDesktop().browse(htmlFile.toURI());
            } else {
                System.out.println("Report file not found!");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	

}
