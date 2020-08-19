package CRM.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CRM.base.base;
import CRM.pages.Homepage;
import CRM.pages.LoginPage;

public class LoginpageTest extends base{

	public LoginPage lp;
	Homepage hp;

	LoginpageTest(){
		super();
	}

	@BeforeMethod
	void setup() {
		initilization();
		lp = new LoginPage();

	}

	@Test(priority=1)
	public void loginpagetitletest() {

		String actualtitle =lp.validateloginpagetitle();
		log.info("verifying login page title");
		Assert.assertEquals(actualtitle, prop.getProperty("Loginpagetitle"));
	}

	@Test(priority=2)
	public void loginpagelogo() {
		log.info("verifying login page logo");
		Assert.assertTrue(lp.validateloginpagelogo());
	}
	
	@Test(priority=3)
	public void logintest() throws InterruptedException {
		log.info("verifying login page credentials");
		hp=lp.login(prop.getProperty("UserID"), prop.getProperty("Password"));

	}
	
	@AfterMethod
	void teardown() {
		driver.quit();	
	}
}
