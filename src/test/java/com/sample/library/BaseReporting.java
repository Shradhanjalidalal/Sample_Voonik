package com.sample.library;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseReporting 
{

  static public String sDirPath = System.getProperty("user.dir");
  public static String sfileWithPath=sDirPath+"‪\\Sample_voonik Reports";
  static WebDriver driver;
  public static WebDriver getDriver()
  {
      if(driver==null)
      {
          driver = new FirefoxDriver();
      }
      return driver;
   }
  public static void takeSnapShot(WebDriver webdriver,String fileWithPath) throws Exception
  {
       //Convert web driver object to TakeScreenshot
        TakesScreenshot scrShot =((TakesScreenshot)webdriver);
       //Call getScreenshotAs method to create image file
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
       //Move image file to new destination
        String Dest=sfileWithPath;
        File DestFile = new File(Dest);
       //Copy file at destination
        FileUtils.copyFile(SrcFile, DestFile);

         
  
    }
  
}
