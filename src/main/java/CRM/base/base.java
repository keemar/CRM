package CRM.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import CRM.utilities.TestUtil;
import CRM.utilities.WebEventListner;

public class base {
	public static WebDriver driver;
	public static Properties prop;
	public static WebEventListner event_listner;
	public static EventFiringWebDriver ef_webdriver;
	public static Logger log;



	public base(){
		 log = Logger.getLogger("CRMProject");

		File f= new File("./\\Configurations\\Config.properties");
		try {
			FileInputStream fis = new FileInputStream(f);
			prop = new Properties();
			prop.load(fis);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static void initilization() {

		String browser = prop.getProperty("Browser");

		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", prop.getProperty("Chromepath"));
			driver = new ChromeDriver();
			log.info("chrome broswer initilaized");
		}
		else if(browser.equals("firefox")) { 
			System.setProperty("webdriver.gecko.driver", prop.getProperty("Firefoxpath"));
			driver = new FirefoxDriver();
			log.info("Firefox broswer initilaized");

		}
		else if(browser.equals("ie")) { 
			System.setProperty("webdriver.IEDriverServer.driver", prop.getProperty("IEpath"));
			driver = new InternetExplorerDriver();
			log.info("InternetExplorer broswer initilaized");

		}
		
		
		
		ef_webdriver = new EventFiringWebDriver(driver);
		// now create object of EventListnerHandler to register with EventFiringWebdriver.
		event_listner = new WebEventListner();
		ef_webdriver.register(event_listner);
		driver= ef_webdriver;

		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_time_out, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.implicit_time_out, TimeUnit.SECONDS);
		driver.get(prop.getProperty("BaseURL"));
		log.info("Url opened " );


		

	}
}
