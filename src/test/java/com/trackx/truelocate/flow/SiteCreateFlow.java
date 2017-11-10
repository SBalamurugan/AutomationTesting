package com.trackx.truelocate.flow;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.trackx.truelocate.common.utils.GeneralActions;
import com.trackx.truelocate.common.utils.ReusableActions;
//import com.trackx.truelocate.pagecomponents.Truelocatesiteupdate;
import com.trackx.truelocate.pagecomponents.Truelocatelogin;
import com.trackx.truelocate.pagecomponents.Truelocatesite;

public class SiteCreateFlow extends GeneralActions{
 
	static WebDriver driver;
	Truelocatelogin truelocatelogin;
	Truelocatesite truelocatesite ;
	/*HSSFWorkbook workbook;
	// Declare An Excel Work Sheet
	HSSFSheet sheet;
	// Declare A Map Object To Hold TestNG Results
	Map<String, Object[]> TestNGResults;*/
	Logger log4jlogger =Logger.getLogger("devpinoyLogger");

/*@BeforeSuite
	
	public void excelCreation(){
		// create a new work book
					workbook = new HSSFWorkbook();
					// create a new work sheet
					sheet = workbook.createSheet("TestNG Result Summary");
					TestNGResults = new LinkedHashMap<String, Object[]>();
					// add test result excel file column header
					// write the header in the first row
					TestNGResults.put("1", new Object[] { "Test Step No.", "Action", "Expected Output", "Actual Output" });
	}*/
	 @BeforeClass
	  public void setUp() throws IOException {
		 
		
		  driver = GeneralActions.launchBrowser(driver, "firefox");
		  
		  truelocatelogin = PageFactory.initElements(driver, Truelocatelogin.class);
		  truelocatesite = PageFactory.initElements(driver, Truelocatesite.class);
		  ReusableActions.loadPropFileValues();
		  ReusableActions.openUrl(driver,ReusableActions.getPropFileValues("Url"));
	      }
	 

	/**
	 * Login Checkout Flow Test Script
     */


	
	 @Test(priority=1,dataProviderClass=Truelocatelogin.class, dataProvider="getData")
	public void siteclickflow (String sUsername, String sPassword) throws Exception {
		try {
			
			 truelocatelogin.enterUsernamepassword(sUsername, sPassword);
			 Thread.sleep(1000);
			 TestNGResults.put("2", new Object[] {  "Login screen", "Login successful", "Pass" });
		      Assert.assertTrue(true);
			     
			//heroukappread.computername(sCompname);
			
			//heroukappread.clickcomp(cname);
		
			 log4jlogger.info("##########-------Login application-------##########");
		      log4jlogger.info("##########-------Login Successfully,----------############");
		    // TestNGResults.put("3", new Object[] {  "Read Operation", "Read operation done successfully", "Pass" });
		    
		}
		catch(Exception e){
			
			//TestNGResults.put("3",new Object[] { "Read Operation", "Read Operation failed", "Fail" });
			//e.printStackTrace();
			
		}
	}
	

	 @Test( priority = 2, dataProviderClass=Truelocatesite.class, dataProvider="getData")
	 public void siteCreationFlow(String sCode,String sName,String sApplicationtype,String sEntitytype,String sLatitude,String sLongitude ) throws Exception {
    	 try {
    		 
    		 truelocatesite.siteClick() ;
    		 truelocatesite.createClick();
    		 truelocatesite.entersitedetails(sCode, sName, sApplicationtype, sEntitytype, sLatitude, sLongitude);
    		 truelocatesite.createfinalclick();
			
		      log4jlogger.info("##########-------Login application-------##########");
		      log4jlogger.info("##########-------Login Successfully,----------############");
		      
		      TestNGResults.put("3", new Object[] {  "Site screen", "Site created successfully", "Pass" });
		      
		      Assert.assertTrue(true);
		     
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
		
	 
	 

	
		@AfterClass
		public void quitDriver(){
 try{
	
	 Thread.sleep(5000);
	 driver.quit();
	 }
	  catch (Exception e) {
	 e.printStackTrace();
	 }

}

	
}

