package com.sample.library;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class Parallelbaselib {
	public static WebDriver driver;
	public static int sStatusCnt=0;
	WebDriverWait wait=null;
	
	@Parameters({ "browser" }) 
	@BeforeMethod
	public void setup(String browser){
		if(browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver","D:\\Ibrahim\\Project\\Sample_voonik\\resources\\jars\\geckodriver.exe");
			  driver = new FirefoxDriver();
		 
		  } else if (browser.equalsIgnoreCase("chrome")) { 
				 
				 
			  System.setProperty("webdriver.chrome.driver","D:\\Ibrahim\\Project\\Sample_voonik\\resources\\jars\\chromedriver.exe");
			 
				driver = new ChromeDriver();
			 
			  } 	 
	}
	
	
	@AfterMethod
	public void tearDown(){
	//	driver.quit();
	}

	public void loadURL(String sUrl)
	{
		try{
			driver.get(sUrl);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			driver.manage().window().maximize();
		}catch(AssertionError e){
			
			throw e;
		}	
	}
	
	public void visibilityOfElementWait(WebElement webElement,String elementName)
	{
	   try 
	   {
		   wait = new WebDriverWait(driver, 15);
	       wait.until(ExpectedConditions.visibilityOf(webElement));
	   } 
	   catch (Exception e) 
	   {
	     	BaseLib.sStatusCnt++;
	      	
	   }
	} 

}
