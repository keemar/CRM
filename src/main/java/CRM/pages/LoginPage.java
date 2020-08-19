package CRM.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import CRM.base.base;

public class LoginPage extends base{

	//objects/pagefactory
	
	@FindBy(xpath ="//img[@alt='Cogmento Free CRM']")
	WebElement loginlogo;
	
	@FindBy(linkText = "Log In")
	WebElement loginlink;
	
	@FindBy(name = "email")
	WebElement emailid;
	
	@FindBy(name = "password")
	WebElement pswd;
	
	
	@FindBy(xpath = "(//div[contains(text(),'Login')])[1]")
	WebElement loginbtn;
	
	
	//Intilization
	public LoginPage(){
		
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateloginpagetitle() {
		return driver.getTitle();
	}
	
	public boolean validateloginpagelogo() {
		return loginlogo.isDisplayed();
	}
	
	
	public Homepage login(String username,String pwd) throws InterruptedException{
		
		loginlink.click();
		Thread.sleep(2000);
		emailid.clear();
		emailid.sendKeys(username);
		Thread.sleep(1000);
		pswd.clear();
		pswd.sendKeys(pwd);
		Thread.sleep(1000);
		loginbtn.click();
		Thread.sleep(2000);
		
		return new Homepage();
		
	}
}
