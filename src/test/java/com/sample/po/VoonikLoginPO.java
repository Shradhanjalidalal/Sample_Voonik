package com.sample.po;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.sample.library.BaseLib;

public class VoonikLoginPO 
{
	 WebDriver driver=null;
	  public VoonikLoginPO(WebDriver driver)
	  {
	    this.driver=driver;
	    PageFactory.initElements(driver,this);
	  }
  // login link	  
  @FindBy(xpath="//div[@id='trow1_right']/div/div[2]/a")
  private WebElement eleLoginLink;
  public WebElement getEleLoginLink()
  {
	  return eleLoginLink;
  }
  //user name textbox 
  @FindBy(xpath="(//div[@class='col-md-12 sclose sclose_btn'])[1]/..//input[@id='user_email']")
  private WebElement eleUserName;
  public WebElement getEleUserName()
  {
	  return eleUserName;
  }
  //password textbox
  @FindBy(xpath="(//div[@class='col-md-12 sclose sclose_btn'])[1]/..//input[@id='user_password']")
  private WebElement elePassword;
  public WebElement getElePassword()
  {
	  return elePassword;
  }
  //signin button
  @FindBy(xpath="(//div[@class='col-md-12 sclose sclose_btn'])[1]/..//button[@class='btn']")
  private WebElement eleSignin;
  public WebElement getEleSignin()
  {
	  return eleSignin;
  }
  //search button
  @FindBy(xpath="//input[@id='global_search_box']")
  private WebElement eleSearchBox;
  public WebElement getEleSearchBox() 
  {
	  return eleSearchBox;
  }
  //choose one item
  @FindBy(xpath="(//div[@id='product_image_listing']/a/img)[3]")
  private WebElement eleItem;
  public WebElement getEleItem()
  {
	  return eleItem;
  }
  //add to cart
  @FindBy(xpath="//a[@id='add_to_cart' AND text()='ADD TO BAG']")
  private WebElement eleCart;
  public WebElement getEleCart()
  {
	  return eleCart;
  }
  //click on cart
  @FindBy(xpath=".//*[@id='trow1_right']/div/div[6]/a/div")
  private WebElement eleCartClick;
  public WebElement getEleCartClick()
  {
	  return eleCartClick;
  }
  //click on delete
  @FindBy(xpath="//span[contains(text(),'DELETE')]")
  private WebElement eledelete;
  public WebElement getEledelete()
  {
	  return eledelete;
  }
  //click on start shooping
  @FindBy(xpath="//a[contains(text(),'START SHOPPING')]")
  private WebElement eleStartShopping;
  public WebElement getEleStartShopping()
  {
	  return eleStartShopping;
  }
  //filtering on price
  @FindBy(xpath="//input[@id='price_33']")
  private WebElement eleFilterPrice;
  public WebElement getEleFilterPrice()
  {
	  return eleFilterPrice;
  }
  //filtering on discount
  @FindBy(xpath="//input[@id='discount_1054']")
  private WebElement eleFilterDiscount;
  public WebElement getEleFilterDiscount()
  {
	  return eleFilterDiscount;
  }
  //filter on colour
  @FindBy(xpath="//input[@id='color_917']")
  private WebElement eleFilterColour;
  public WebElement getEleFilterColour()
  {
	  return eleFilterColour;
  }
  //after filter product choose
  @FindBy(xpath=".//*[@id='product_image_listing']/a/img")
  private WebElement eleFilteredProduct;
  public WebElement getEleFilteredProduct()
  {
	  return eleFilteredProduct;
  }
  //click on wishlist
  @FindBy(xpath="//p[contains(text(),'MOVE TO WISHLIST')]")
  private WebElement eleWishList;
  public WebElement getEleWishList()
  {
	  return eleWishList;
  }
  //click on profile
  @FindBy(xpath="//p[contains(text(),'Raghukiran MR')]")
  private WebElement eleProfileTab;
  public WebElement getEleProfileTab()
  {
	  return eleProfileTab;
  }
  //click on signout button
  @FindBy(xpath="//a[contains(text(),'Signout')]")
  private WebElement eleSignOut;
  public WebElement getEleSignOut()
  {
	  return eleSignOut;
  }
 //click on my profile
  @FindBy(xpath="//a[contains(text(),'My Profile')]")
  private WebElement eleMyProfile;
  public WebElement getEleMyProfile()
  {
	  return eleMyProfile;
  }
 //change password link
  @FindBy(xpath="//p[contains(text(),'Change Password')]")
  private WebElement eleChangePassword;
  public WebElement getEleChangePassword()
  {
	  return eleChangePassword;
  }
  //current password
  @FindBy(xpath="//input[@id='user_current_password']")
  private WebElement eleCurrentPassword;
  public WebElement getEleCurrentPassword()
  {
	  return eleCurrentPassword;
  }
 //new password
  @FindBy(xpath="(//input[@id='user_password'])[1]")
  private WebElement eleNewPassword;
  public WebElement getEleNewPassword()
  {
	  return eleNewPassword;
  }
 //confirm password
  @FindBy(xpath="(//input[@id='user_password_confirmation'])[1]")
  private WebElement eleConfirmPassword;
  public WebElement getEleConfirmPassword()
  {
	  return eleConfirmPassword;
  }
  //Update button
  @FindBy(xpath="(//input[@class='btn'])[1]")
  private WebElement eleUpdateButton;
  public WebElement getEleUpdateButton()
  {
	  return eleUpdateButton;
  }
  
  public void elementStatus(WebElement element, String elementName, String checkType) 
	{
		
		switch(checkType)
		{
			case "displayed":
				try 
			    {
			        element.isDisplayed();
			        
			    } 
			    catch (Exception e) 
			    {
			    	BaseLib.sStatusCnt++;
			    	
			    }
				break;
			case "enabled":
				try 
			    {
			        element.isEnabled();
			        
			    } 
			    catch (Exception e) 
			    {
			    	BaseLib.sStatusCnt++;
			    	
			    }
				break;
			case "selected":
				try 
				{
					element.isSelected();
				    
				} 
				catch (Exception e) 
				{
				   	BaseLib.sStatusCnt++;
				   	
				}
				break;
			}
	}
  public void Login(String username,String password)
  {
     eleLoginLink.click();
	 elementStatus(getEleUserName(), "The Username text field","displayed");
	 getEleUserName().sendKeys(username);
	 elementStatus(getElePassword(), "The Password text field","displayed");
	 getElePassword().sendKeys(password);
	 elementStatus(getEleSignin(), "The Sign in button","displayed");
	 getEleSignin().click();
				
			
		
		}




  
}
