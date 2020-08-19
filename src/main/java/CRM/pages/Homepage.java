package CRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CRM.base.base;

public class Homepage extends base{


	@FindBy(xpath="//div[@class ='header item']")
	WebElement homepagelogo;

	@FindBy(xpath="//span[@class = 'user-display'][contains(text(),'keerthi sandupatla')]")
	WebElement usernamelabel;

	@FindBy(xpath="//span[@class ='item-text' and contains(text(),'Calendar')]")
	WebElement calendarlink;

	@FindBy(xpath="//span[@class ='item-text' and contains(text(),'Contacts')]")
	WebElement contactslink;


	@FindBy(xpath="//span[@class ='item-text' and contains(text(),'Companies')]")
	WebElement companieslink;

	@FindBy(xpath="//span[@class ='item-text' and contains(text(),'Deals')]")
	WebElement dealslink;

	//Intilization
	public Homepage(){

		PageFactory.initElements(driver, this);
	}

	//Actions
	public String validatehomepagetitle() {
		return driver.getTitle();
	}

	public boolean validatehomepagelogo() {
		return homepagelogo.isDisplayed();
	}

	public boolean validateusernamelabel() {
		return usernamelabel.isDisplayed();
	}

	public Calendarpage calendarpagelink(){
		calendarlink.click();
		return new Calendarpage();
	}


	public Contactspage contactspagelink(){
		contactslink.click();
		return new Contactspage();
	}

	public Companiespage compinespagelink(){
		companieslink.click();
		return new Companiespage();
	}

	public Dealspage dealspagelink(){
		dealslink.click();
		return new Dealspage();
	}


}
