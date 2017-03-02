package com.sample.library;

import org.apache.log4j.PropertyConfigurator;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.apache.log4j.Logger;

public class Retryanalizser implements IRetryAnalyzer  { 
	 private static final Logger logger = Logger.getLogger(Retryanalizser.class);
	    int retryCount = 0;
	    int retryMaxCount = 1;
	    
	    static {
	    PropertyConfigurator.configure(GenericLib.sDirPath+"Config.properties");
	    }
	    
	    @Override
	    public boolean retry(ITestResult tr) {
	    	
	        if (tr.getAttributeNames().contains("retry") == false) {
	        	if(retryCount < retryMaxCount){
	                logger.info("Retrying " + tr.getName() + " with status "
	                        + tr.getStatus() + " for the " + (retryCount+1) + " of "
	                        + retryMaxCount + " times.");
	                
	                retryCount++;
	                
	                return true;
	        	}        	
	    	}
	        logger.debug("Skipping retry!");
	        return false;
	    }
}
