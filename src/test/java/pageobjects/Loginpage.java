package pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Loginpage extends Basepage {

	 Actions act;
	public Loginpage(WebDriver driver) {
		super(driver);
		this.act = new Actions(driver);
	}
	
	@FindBy(xpath = "//input[@title= \"Search for Products, Brands and More\"]") WebElement Searchfield;
	@FindBy(xpath = "//div[@class = \"tUxRFH\"]//div[@class = \"col col-7-12\"]/div[text() = \"Apple iPhone 16 Plus (White, 512 GB)\"]") WebElement productname;
	@FindBy(xpath = "//div[contains(@class,'Nx9bqj') and contains(@class,'CxhGGd')]") WebElement productprice;
	@FindBy(xpath = "//button[@class = \"QqFHMw vslbG+ _3Yl67G _7Pd1Fp\"]") WebElement buynowbtn;
	@FindBy(xpath = "//input[@type = \"text\"]") WebElement emailfield ;
	@FindBy(xpath = "//button[@type = \"submit\"]") WebElement continuebtn ;
	@FindBy(xpath = "//input[@type='text' and @maxlength='6']") WebElement enterotp;

	
	public void myaccbtnclick() {
		
		Searchfield.click();
		Searchfield.sendKeys("Iphone 16plus");
		Searchfield.sendKeys(Keys.ENTER);
	}
	
	public void productnameclick() {
		if(productname.isDisplayed()) {
		productname.click();
		}
		wait.until(ExpectedConditions.numberOfWindowsToBe(2)); 
		utilities.windowhandler.switchwindow(driver);
		/*ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
	    driver.switchTo().window(tabs.get(1));
	    */
	    String title = driver.getTitle();
		System.out.println("Title of page is:"+ title);

	    
	}
	
	public void productpriceget() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class,'Nx9bqj') and contains(@class,'CxhGGd')]")
				));
		String price = productprice.getText();
		System.out.println("Price of Product: "+ price);
	}
	
	public void buynowbtnclick() {
		wait.until(ExpectedConditions.elementToBeClickable(buynowbtn));
		act.moveToElement(buynowbtn).click().perform();
		System.out.println("Signin page displayed");
	}
	
	public void emailenter() {
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//input[@type='text']")));
		emailfield.sendKeys("karthikijay234@gmail.com");
		continuebtn.click();
		 wait.until(ExpectedConditions.refreshed(
			            ExpectedConditions.visibilityOf(enterotp)
			        ));
		if(enterotp.isDisplayed()) {
			System.out.println("Otp Needed: "+ "?");
		}
		
	}
}
