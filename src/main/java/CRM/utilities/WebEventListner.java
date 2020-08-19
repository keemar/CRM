package CRM.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverEventListener;

import CRM.base.base;

// WebDriverEventListener is use to log selenium actions
public class WebEventListner extends base implements WebDriverEventListener{

	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured : "+ error);	
		try {
			TestUtil.capturescreenshot(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	public void beforeNavigateTo(String url, WebDriver driver) {
		System.out.println("Before Navigated to url '"+ url + "'");		

	}

	public void afterNavigateTo(String url, WebDriver driver) {
		System.out.println("After Navigated to url '"+ url + "'");		

	}

	public void beforeNavigateBack(WebDriver driver) {
		System.out.println("Before Navigated back to prevoius page");		

	}

	public void afterNavigateBack(WebDriver driver) {
		System.out.println("After Navigated back to prevoius page");		

	}

	public void beforeAlertAccept(WebDriver driver) {
		System.out.println("Before Accepting the alert");		

	}

	public void afterAlertAccept(WebDriver driver) {
		System.out.println("After Accepting the alert");		

	}

	public void afterAlertDismiss(WebDriver driver) {
		System.out.println("After Dismissing the alert");		

	}

	public void beforeAlertDismiss(WebDriver driver) {
		System.out.println("Before Dismissing the alert");		

	}


	public void beforeNavigateForward(WebDriver driver) {
		System.out.println("Before Navigated forward to prevoius page");		

	}

	public void afterNavigateForward(WebDriver driver) {
		System.out.println("After Navigated forward to prevoius page");		

	}

	public void beforeNavigateRefresh(WebDriver driver) {
		System.out.println("Before refreshing the page");		

	}

	public void afterNavigateRefresh(WebDriver driver) {
		System.out.println("After refreshing the page");		

	}
	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Before clicking on element : " +element.toString() );		

	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("After clicking on element : " +element.toString() );		

	}
	public void beforeFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Trying to find Element By : " + by.toString());
	}

	public void afterFindBy(By by, WebElement element, WebDriver driver) {
		System.out.println("Found Element By : " + by.toString());
	}


	public void beforeChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void afterChangeValueOf(WebElement element, WebDriver driver, CharSequence[] keysToSend) {
		// TODO Auto-generated method stub

	}

	public void beforeScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterScript(String script, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void beforeSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterSwitchToWindow(String windowName, WebDriver driver) {
		// TODO Auto-generated method stub

	}


	public <X> void beforeGetScreenshotAs(OutputType<X> target) {
		// TODO Auto-generated method stub

	}

	public <X> void afterGetScreenshotAs(OutputType<X> target, X screenshot) {
		// TODO Auto-generated method stub

	}

	public void beforeGetText(WebElement element, WebDriver driver) {
		// TODO Auto-generated method stub

	}

	public void afterGetText(WebElement element, WebDriver driver, String text) {
		// TODO Auto-generated method stub

	}

}
