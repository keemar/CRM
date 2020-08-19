package CRM.testpages;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import CRM.base.base;
import CRM.pages.Calendarpage;
import CRM.pages.Companiespage;
import CRM.pages.Contactspage;
import CRM.pages.Dealspage;
import CRM.pages.Homepage;
import CRM.pages.LoginPage;

public class HomepageTest extends base{

	LoginPage lp;
	Homepage hp;
	Calendarpage calpg;
	Contactspage conpg;
	Companiespage compg;
	Dealspage dealpg;


	HomepageTest(){
		super();
	}

	@BeforeMethod
	void setup() throws Exception {
		initilization();
		lp = new LoginPage();
		hp=lp.login(prop.getProperty("UserID"), prop.getProperty("Password"));
		//Assert.assertEquals(new Homepage(), hp);
	}

	@Test(priority=1)
	public void homepagetitletest() {

		String actualtitle =hp.validatehomepagetitle();
		Assert.assertEquals(actualtitle, prop.getProperty("Homepagetitle"));
	}


	@Test(priority=2)
	public void homepagelogotest() {
		Assert.assertTrue(hp.validatehomepagelogo());
	}

	@Test(priority=3)
	public void homepageuserlabeltest() {
		Assert.assertTrue(hp.validateusernamelabel());
	}

	@Test(priority=4)
	public void clickCalendarlink() {
		calpg = hp.calendarpagelink();
		//Assert.assertEquals(new Calendarpage(),calpg );
	}

	@Test(priority=5)
	public void clickContactslink() {
		conpg = hp.contactspagelink();
		//Assert.assertEquals(new Contactspage(),conpg );
	}

	@Test(priority=6)
	public void clickCompanieslink() {
		compg = hp.compinespagelink();
		//Assert.assertEquals(new Companiespage(),compg );
	}

	@Test(priority=7)
	public void clickdealslink() {
		dealpg = hp.dealspagelink();
		//Assert.assertEquals(new Dealspage(),dealpg );
	}
	
	@AfterMethod
	void teardown() {
		driver.quit();	
	}
}
