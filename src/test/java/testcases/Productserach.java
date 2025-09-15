package testcases;

import org.testng.annotations.Test;

import pageobjects.Loginpage;
import testbase.Baseclass;

public class Productserach extends Baseclass{

	@Test
	public void registertests() {
		
		Loginpage lp = new Loginpage(driver);
		lp.myaccbtnclick();
		lp.productnameclick();
		lp.productpriceget();
		lp.buynowbtnclick();
		lp.emailenter();
	}
	
}
