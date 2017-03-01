package com.sample.scripts;

import java.util.ArrayList;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.sample.library.BaseLib;
import com.sample.library.GenericLib;
import com.sample.library.Parallelbaselib;
import com.sample.library.Retryanalizser;
import com.sample.po.VoonikLoginPO;

public class VoonikLogin extends BaseLib
{
	VoonikLoginPO Voonikloginpo=null;
	
 @Test(priority=1,enabled=true,description="Search a object and add that to cart and delete that from the bag")
  public void testlogin() throws Throwable
  {
	  Voonikloginpo=new VoonikLoginPO(driver);
	  
	  try
	  {
	  loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"URL"));
	  Thread.sleep(8000);	
      Voonikloginpo.Login(GenericLib.getCongigValue(GenericLib.sConfigFile, "USERNAME"),GenericLib.getCongigValue(GenericLib.sConfigFile, "PASSWORD"));
	  Voonikloginpo.elementStatus(Voonikloginpo.getEleSearchBox(),"Search textbox","enabled");
	  Thread.sleep(3000);
	  Voonikloginpo.getEleSearchBox().sendKeys("watch");
	  Voonikloginpo.elementStatus(Voonikloginpo.getEleSearchBox(),"enter","enabled");
	  Thread.sleep(3000);
	  Voonikloginpo.getEleSearchBox().sendKeys(Keys.ENTER);
	  Voonikloginpo.elementStatus(Voonikloginpo.getEleItem(),"perticularitem","selected");
	  Thread.sleep(3000);
	  Voonikloginpo.getEleItem().click();
	  Thread.sleep(4000);
	  
	  ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
	  driver.switchTo().window(tabs.get(1));
	  
	  Thread.sleep(4000);
	  Voonikloginpo.elementStatus(Voonikloginpo.getEleCart(),"ADD to cart","enabled");
      WebElement element = driver.findElement(By.xpath("//a[@id='add_to_cart']"));
	  JavascriptExecutor executor = (JavascriptExecutor)driver;
	  Thread.sleep(6000);
	  executor.executeScript("arguments[0].click();", element);
	  Voonikloginpo.elementStatus(Voonikloginpo.getEleCartClick(),"Cart Icon","displayed");
	  Thread.sleep(3000);
	  Voonikloginpo.getEleCartClick().click();
	  Voonikloginpo.elementStatus(Voonikloginpo.getEledelete(),"delete","enabled");
	  Thread.sleep(6000);
	  Voonikloginpo.getEledelete().click();
	  Voonikloginpo.elementStatus(Voonikloginpo.getEleStartShopping(),"start shopping button","enabled");
	  Thread.sleep(3000);
	  Voonikloginpo.getEleStartShopping().click();
	  Voonikloginpo.elementStatus(Voonikloginpo.getEleProfileTab(),"profile tab","enabled");
	  Thread.sleep(3000);
	  Voonikloginpo.getEleProfileTab().click();
	  Thread.sleep(3000);
	  Voonikloginpo.elementStatus(Voonikloginpo.getEleSignOut(),"sign out","enabled");
	  Thread.sleep(5000);
	  Voonikloginpo.getEleSignOut().click();
	  }
	  
	  catch(AssertionError e)
	  {
		  throw e;
	  }
  }
  @Test(priority=2,enabled=true,description="Filter the product and add to cart")
    public void FilteringProduct() throws Exception 
    {
	    Voonikloginpo=new VoonikLoginPO(driver);
		try
		{
			  loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"URL"));
			  Thread.sleep(8000);	
		      Voonikloginpo.Login(GenericLib.getCongigValue(GenericLib.sConfigFile, "USERNAME"),GenericLib.getCongigValue(GenericLib.sConfigFile, "PASSWORD"));
		      String titl = driver.getTitle();
		      if(titl.equals("Online Shopping Site: Shop For Women Clothes, Shoes, Bags, Watches in India"))
		      {
	                //To Skip Test
	            throw new SkipException("Test Check_Checkbox Is Skipped");
	            }   
		       else
		      {
		      Voonikloginpo.elementStatus(Voonikloginpo.getEleSearchBox(),"Search textbox","enabled");
			  Thread.sleep(3000);
			  Voonikloginpo.getEleSearchBox().sendKeys("watch");
			  Voonikloginpo.elementStatus(Voonikloginpo.getEleSearchBox(),"enter","enabled");
			  Thread.sleep(3000);
			  Voonikloginpo.getEleSearchBox().sendKeys(Keys.ENTER);
			  Voonikloginpo.elementStatus(Voonikloginpo.getEleFilterPrice(),"filter price","selected");
			  Thread.sleep(3000);
			  Voonikloginpo.getEleFilterPrice().click();
			  Voonikloginpo.elementStatus(Voonikloginpo.getEleFilterDiscount(),"filter discount","selected");
			  Thread.sleep(3000);
			  Voonikloginpo.getEleFilterDiscount().click();
			  Voonikloginpo.elementStatus(Voonikloginpo.getEleFilterColour(),"filter colour","selected");
			  Thread.sleep(3000);
			  Voonikloginpo.getEleFilterColour().click();
			  Voonikloginpo.elementStatus(Voonikloginpo.getEleFilteredProduct(),"filtered product","selected");
			  Thread.sleep(3000);
			  Voonikloginpo.getEleFilteredProduct().click();
			  Thread.sleep(4000);
			  ArrayList<String> tabs=new ArrayList<String>(driver.getWindowHandles());
			  driver.switchTo().window(tabs.get(1));
			  Voonikloginpo.elementStatus(Voonikloginpo.getEleCart(),"ADD to cart","enabled");
		      WebElement element = driver.findElement(By.xpath("//a[@id='add_to_cart']"));
			  JavascriptExecutor executor = (JavascriptExecutor)driver;
			  Thread.sleep(6000);
			  executor.executeScript("arguments[0].click();", element);
			  Voonikloginpo.elementStatus(Voonikloginpo.getEleCartClick(),"Cart Icon","displayed");
			  Thread.sleep(3000);
			  Voonikloginpo.getEleCartClick().click();
			  Voonikloginpo.elementStatus(Voonikloginpo.getEleWishList(),"wish list","enabled");
			  Thread.sleep(6000);
			  Voonikloginpo.getEleWishList().click();
			  Voonikloginpo.elementStatus(Voonikloginpo.getEleStartShopping(),"start shopping button","enabled");
			  Thread.sleep(3000);
			  Voonikloginpo.getEleStartShopping().click();
			  Voonikloginpo.elementStatus(Voonikloginpo.getEleProfileTab(),"profile tab","enabled");
			  Thread.sleep(3000);
			  Voonikloginpo.getEleProfileTab().click();
			  Thread.sleep(3000);
			  Voonikloginpo.elementStatus(Voonikloginpo.getEleSignOut(),"sign out","enabled");
			  Thread.sleep(3000);
			  Voonikloginpo.getEleSignOut().click();
		      } 
		}
		catch(AssertionError e)
		{
			throw e;
		}
    }
  @Test(priority=3,enabled=true,description="Check functionality on change password",retryAnalyzer=Retryanalizser.class)	
    public void ChangePassword() throws Exception 
    {
	  Voonikloginpo=new VoonikLoginPO(driver);
	  try
	  {
		  loadURL(GenericLib.getCongigValue(GenericLib.sConfigFile,"URL"));
		  Thread.sleep(8000);	
	      Voonikloginpo.Login(GenericLib.getCongigValue(GenericLib.sConfigFile, "USERNAME"),GenericLib.getCongigValue(GenericLib.sConfigFile, "PASSWORD")); 
	      Voonikloginpo.elementStatus(Voonikloginpo.getEleProfileTab(),"profile tab","enabled");
		  Thread.sleep(3000);
		  Voonikloginpo.getEleProfileTab().click();
		  Voonikloginpo.elementStatus(Voonikloginpo.getEleMyProfile(),"my profile","enabled");
		  Thread.sleep(3000);
		  Voonikloginpo.getEleMyProfile().click();
		  Thread.sleep(3000);
		  Voonikloginpo.elementStatus(Voonikloginpo.getEleChangePassword(),"change password","selected");
		  Thread.sleep(3000);
		  Voonikloginpo.getEleChangePassword().click();
		  Voonikloginpo.elementStatus(Voonikloginpo.getEleCurrentPassword(),"current password","displayed");
		  Thread.sleep(3000);
		  Voonikloginpo.getEleCurrentPassword().sendKeys("raghukiran92");
		  Voonikloginpo.elementStatus(Voonikloginpo.getEleNewPassword(),"new password","displayed");
		  Thread.sleep(10000);
		  Voonikloginpo.getEleNewPassword().sendKeys("raghukiran");
		  Voonikloginpo.elementStatus(Voonikloginpo.getEleConfirmPassword(),"confirm password","displayed");
		  Thread.sleep(5000);
		  Voonikloginpo.getEleConfirmPassword().sendKeys("raghukiran");
		  Voonikloginpo.elementStatus(Voonikloginpo.getEleUpdateButton(),"update button","selected");
		  Thread.sleep(3000);
		  Voonikloginpo.getEleUpdateButton().click();
		  
	  }
	  catch(AssertionError e)
	  {
		  throw e;  
	  }
    }
	
	
	


    
	  
 }



