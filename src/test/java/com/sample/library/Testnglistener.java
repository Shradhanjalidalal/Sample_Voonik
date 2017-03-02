package com.sample.library;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.relevantcodes.extentreports.DisplayOrder;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.NetworkMode;

public class Testnglistener implements ITestListener
{
	public static ArrayList sTestName= new ArrayList<String>();
	public static ArrayList sStatus= new ArrayList<String>();
	private ExtentReports reporter =  new ExtentReports(System.getProperty("user.dir")+" "+"Reports\\report.html", true, DisplayOrder.NEWEST_FIRST, NetworkMode.ONLINE, Locale.ENGLISH);
	private ExtentTest testReporter;
	
	@Override
	public void onTestStart(ITestResult result) 
	{
	  testReporter = reporter.startTest(result.getMethod().getMethodName(),result.getMethod().getDescription());
	  testReporter.log(LogStatus.INFO, "Starting test " +result.getMethod().getMethodName());
	  
	}
	@Override
	public void onTestSuccess(ITestResult result)
	{
	  testReporter.log(LogStatus.PASS, "Test PASSED");
	  reporter.endTest(testReporter);
	  System.out.println("The name of the testcase passed is :"+result.getName());	
	  GenericLib.setStatus(result.getName().toString(), "Passed",sTestName,sStatus);
	}
    @Override
	public void onTestFailure(ITestResult result)
	{
		try{
			capture(Parallelbaselib.driver,result.getName());
			String screenShotPath = capture(Parallelbaselib.driver, result.getName());
			//To get the error in the report un comment below line
			testReporter.log(LogStatus.FAIL, result.getThrowable());
			testReporter.log(LogStatus.FAIL, "Find the Snapshot For the error : "+ testReporter.addScreenCapture(screenShotPath));
			}
		catch (Exception e) 
		{
			 e.printStackTrace();
			
			 
		}
			reporter.endTest(testReporter);
			reporter.flush();
	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("The name of the testcase Skipped is :"+result.getName());
		GenericLib.setStatus(result.getName().toString(), "Skipped",sTestName,sStatus);
		reporter.flush();
		
	}
    @Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) 
    {
		
	}
    @Override
	public void onStart(ITestContext result) 
	{
	    reporter.loadConfig(new File(System.getProperty("user.dir")+"Sample_voonik/extent-config.xml"));
	    GenericLib.setStatus(result.getName().toString(), "Started",sTestName,sStatus);
		reporter.addSystemInfo("Reported by :", "Shradha");
	
	  	
	}
    @Override
	public void onFinish(ITestContext context) {
    	
		reporter.flush();
		GenericLib.setStatus(context.getName().toString(), "Finished",sTestName,sStatus);
	//	reporter.close();
		
	}
	public static String capture(WebDriver driver,String screenShotName)throws IOException
	{
	  Date date = new Date(0);
	  SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy_hh-mm-ss");
	  String sdate = sdf.format(date);
	  TakesScreenshot ts = (TakesScreenshot)driver;
      File source = ts.getScreenshotAs(OutputType.FILE);
	  String dest =GenericLib.sDirPath+"\\screenshots\\"+screenShotName+"_"+sdate+"_test.png";
	  File destination = new File(dest);
	  FileUtils.copyFile(source, destination);
      return dest;
    }	
}
