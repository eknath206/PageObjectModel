package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.crm.qa.util.TestUtil;
import com.crm.qa.util.WebEventListener;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public static EventFiringWebDriver efDriver;
	public static WebEventListener eventListener;
	
	public TestBase() {
		
		try {
			prop = new Properties();
<<<<<<< HEAD
			FileInputStream fi = new FileInputStream("F:\\eclipse-workspace\\FreeCRMTestDemo_Git\\src\\main\\java\\com\\crm\\qa\\"
=======
			FileInputStream fi = new FileInputStream("F:\\eclipse-workspace\\FreeCRMTestDemo_Git_New\\src\\main\\java\\com\\crm\\qa\\"
>>>>>>> 32384e1eb98e4595a7a418b5e370d884034378d8
					+ "config\\config.properties");
			prop.load(fi);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void initialization() {
		String browserName = prop.getProperty("browser");
		if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "F:\\JarFiles\\chromedriver.exe");
			driver = new ChromeDriver();
		}else if(browserName.equals("firefox")) {
			System.setProperty("webdriver.chrome.driver", "F:\\JarFiles\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		
		efDriver = new EventFiringWebDriver(driver);
		eventListener = new WebEventListener();
		efDriver.register(eventListener);
		driver = efDriver;
		
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		driver.get(prop.getProperty("url"));
	}

}
