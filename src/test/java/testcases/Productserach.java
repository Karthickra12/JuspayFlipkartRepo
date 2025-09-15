package testcases;

import org.testng.annotations.Test;

import pageobjects.Loginpage;
import testbase.Baseclass;

public class Productserach extends Baseclass{

	@Test
	public void registertests() throws InterruptedException {
		
		Loginpage lp = new Loginpage(driver);
		lp.myaccbtnclick();
		lp.productnameclick();
		lp.productpriceget();
		lp.buynowbtnclick();
		lp.gettitle();
		//driver.navigate().refresh();
		Thread.sleep(5);
		lp.emailenter();
	}
	
}
