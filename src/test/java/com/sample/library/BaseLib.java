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


public class BaseLib {
	public static WebDriver driver;
	public static int sStatusCnt=0;
	WebDriverWait wait=null;
	
	@Parameters({ "browser" }) 
	@BeforeMethod
	public void setUp(){
		try{
		if(GenericLib.getCongigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("Chrome")){
			System.setProperty("webdriver.chrome.driver",GenericLib.sDirPath+"\\resources\\jars\\chromedriver.exe");
			System.out.println("Chrome Browser is set");
			driver = new ChromeDriver();
		}else if(GenericLib.getCongigValue(GenericLib.sConfigFile, "BROWSER").equalsIgnoreCase("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver",GenericLib.sDirPath+"\\resources\\jars\\geckodriver.exe");
			System.out.println("Firefox Browser is set");
			driver = new FirefoxDriver();
			
		}
		/*else{
			System.setProperty("webdriver.ie.driver", GenericLib.sDirPath+"\\resources\\jars\\IEDriverServer.exe");
			System.out.println("InternetExplorer Browser is set");
			driver = new InternetExplorerDriver();
		}*/
		
		}
		catch(Exception e){
			System.out.println("Problem in launching driver");
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

	public void loadURL(String sUrl)
	{
		try{
			driver.get(sUrl);
			driver.manage().timeouts().implicitlyWait(70, TimeUnit.SECONDS);
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
