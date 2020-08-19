package CRM.testpages;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CRM.base.base;
import CRM.pages.Contactspage;
import CRM.pages.Homepage;
import CRM.pages.LoginPage;
import CRM.utilities.TestUtil;

public class ContactspageTest extends base{

	LoginPage lp;
	Homepage hp;
	Contactspage conpg;
	String sheetname="Contacts";

	ContactspageTest(){
		super();
	}


	@BeforeMethod
	void setup() throws Exception {
		initilization();
		lp = new LoginPage();
		hp=lp.login(prop.getProperty("UserID"), prop.getProperty("Password"));
		conpg=hp.contactspagelink();


	}

	@Test(priority=1)
	public void contactspagelabeltest() {
		Assert.assertTrue(conpg.validatecontactspagelabel());
	}

	@DataProvider
	public Object[][] getcontacttestdata() throws IOException {

		Object[][] data=TestUtil.gettestdata(sheetname);
		return data;

	}

	@Test(priority=2,dataProvider = "getcontacttestdata")
	public void addnewcontact(String fname,String lname) {
		conpg.createnewcontact(fname, lname);
	}


	@Test(priority=2,enabled=false)
	public void validateContactsPageCheckbox() {
		conpg.contactspagecheckbox();
	}

	@Test(priority=3)
	public void validateContactsPageThrashIcon() {
		conpg.contactspagetrashicon();
	}

	@AfterMethod
	void teardown() {
		driver.quit();	
	}

}
