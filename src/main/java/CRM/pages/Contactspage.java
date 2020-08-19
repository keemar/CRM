package CRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CRM.base.base;

public class Contactspage extends base{


	@FindBy(xpath="//div[text()='Contacts']")
	@CacheLookup  // locally memory will be created and web elements will get stored so instead of checking in dom page it will check here and 
	//execution will be fast.but dom page got refreshed/changed means we will get stale element ecpetion.so better to use if element address wont change.
	WebElement lblcontactspagelabel;


	@FindBy(xpath="//div[@class='ui checked fitted read-only checkbox']//label")
	@CacheLookup  // we can improve script performance
	WebElement cbcontactcheckbox;
	
	@FindBy(xpath="//i[@class='trash icon']")
	WebElement btntrashicon;
	
	
	@FindBy(xpath="//button[contains(text(),'New')]")
	@CacheLookup
	WebElement btnaddnewcontact;
	
	@FindBy(xpath="//input[@name='first_name']")
	@CacheLookup
	WebElement txtfirstname;

	@FindBy(xpath="//input[@name='last_name']")
	@CacheLookup
	WebElement txtlastname;

	@FindBy(xpath="//button[@class='ui linkedin button']")
	@CacheLookup
	WebElement btnsave;

	@FindBy(xpath="//div[@class='ui header item mb5 light-black']")
	@CacheLookup
	WebElement lblnewcontactname;


	public Contactspage(){

		PageFactory.initElements(driver, this);
	}

	public boolean validatecontactspagelabel() {
		return lblcontactspagelabel.isDisplayed();
	}

	
		
	public void createnewcontact(String fname,String lname) {
		btnaddnewcontact.click();
		txtfirstname.sendKeys(fname);
		txtlastname.sendKeys(lname);
		btnsave.click();
		String labelname= lblnewcontactname.getText();
		System.out.println(" label name :" + labelname);
		
		
		
	}
	
	public void contactspagecheckbox() {
		//driver.switchTo().frame("downloadFrame");
		cbcontactcheckbox.click();

	}
	
	public void contactspagetrashicon() {
		btntrashicon.click();

	}
	
	
	
}
