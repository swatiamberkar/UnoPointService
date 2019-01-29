package com.uno.test.rm;


import io.qameta.allure.Description;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.rm.RM_EngineerActivityPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_IncidentPage;
import com.uno.pages.rm.RM_LoginPage;


public class RM_EngineerActivityTest extends BaseCode{

	
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_IncidentPage rm_IncidentPage;
	RM_EngineerActivityPage rm_EngineerActivityPage;
		
		public RM_EngineerActivityTest() {

			super();

		}
		
		@Parameters("browserName")
		@BeforeClass(alwaysRun = true)
		public void Login(String browserName) throws Exception {

			initialization(browserName);

			rm_LoginPage = new RM_LoginPage();
			rm_HomePage = rm_LoginPage.Login(
					properties.getProperty("loginIdForRM"),
					properties.getProperty("password"));
			Thread.sleep(1000);

		}

		@BeforeMethod(alwaysRun = true)
		public void EngineerActivityTab() throws Exception  {

			rm_HomePage = new RM_HomePage();
			driver.findElement(By.cssSelector("a[href='/erprmwise/RMHomeScreen.do']")).click();
			rm_IncidentPage = rm_HomePage.IncidentTab();
			Thread.sleep(1000);
			rm_EngineerActivityPage =rm_IncidentPage.EngineerActivityTab();
			Thread.sleep(2000);

		}

		@Test(priority = 1, groups = { "Engineer Activity" },
		description = "1. In Engineer activity tab, all incident entries should display for which engineer is assign as per selected filters ")
		@Description ("1. In Engineer activity tab, all incident entries should display for which engineer is assign as per selected filters")
		
		public void verifyEngineerAccordingSelectedEngineer()  {

			rm_EngineerActivityPage.verifyEngineerAccordingSelectedEngineer();

		}
		
		@Test(priority = 2, groups = { "Engineer Activity" }, 
		description = "1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill ")
		@Description ("1. If user select any option from daterange filter then as per selected option, in from and to Date field date should get auto fill")			
		public void checkFromAndToDateAccordingSelectedDateRange() throws Exception  {

			rm_EngineerActivityPage.checkFromAndToDateAccordingSelectedDateRange();

		}
		
		@Test(priority = 3, groups = { "Engineer Activity" }, 
		description = "1. If User click on State filter then as per selected Region filter, states should display in state filter for which call is logged."
					+ "2. All records for selected filter are display in dashboard and Total Records count is change as per entries present in dashboard .")
		@Description ("1. If User click on State filter then as per selected Region filter, states should display in state filter for which call is logged."
					+ "2. All records for selected filter are display in dashboard and Total Records count is change as per entries present in dashboard.")
		public void verifyStateAccordingSelectedState() throws Exception{

			rm_EngineerActivityPage.verifyStateAccordingSelectedState();
			rm_EngineerActivityPage.verifyTotalRecordsAccordingDisplayRow();

		}
		
		@Test(priority = 4, groups = { "Engineer Activity" },
		description = "1. If user select Inc type and click on Go button then entries should display as per selected Inc Type value.")
		@Description ("1. If user select Inc type and click on Go button then entries should display as per selected Inc Type value.")
		public void verifyIncTypeAccordingSelectedSIncType() throws Exception{

			rm_EngineerActivityPage.verifyIncTypeAccordingSelectedSIncType();
		}
		
		@Test(priority = 5, groups = { "Engineer Activity" }, 
		description = "1. If user select Customer filter and click on Go button then entries should display as per selected Customer filter.")
		@Description ("1. If user select Customer filter and click on Go button then entries should display as per selected Customer filter.")
		public void verifyCustomerAccordingSelectedCustomer() throws Exception{

			rm_EngineerActivityPage.verifyCustomerAccordingSelectedCustomer();

		}
		
		/*@Test(priority = 6, groups = { "Engineer Activity" }, 
		description = "1. If User click on Inc Type filter then all Incident type should display  which are present in ticket type master."
				+ "2. In customer filter list all Customer should display as present in Customer master"
				+ "3. In Business Unit filter list all BU should display which are present in system")
		@Description ("1. If User click on Inc Type filter then all Incident type should display  which are present in ticket type master."
				+ "2. In customer filter list all Customer should display as present in Customer master"
				+ "3. In Business Unit filter list all BU should display which are present in system")
		public void verifyIncTypeCustomerAndBUInSuperRole() throws Exception{

			rm_EngineerActivityPage.verifyIncTypeCustomerAndBUInSuperRole();

		}
		*/
		
		@Parameters("browserName")
		@AfterMethod
		public void writeResult(ITestResult result, String browserName) throws Exception {

		
				if (result.getStatus() == ITestResult.SUCCESS) {
					System.out.println("================");
					System.out.println(result.getMethod().getMethodName());
					System.out.println("======PASS======");
				}

				else if (result.getStatus() == ITestResult.FAILURE) {
					System.out.println("================");
					System.out.println(result.getMethod().getMethodName());
					System.out.println("======FAIL======");

					// TestUtil.takeScreenshotAtEndOfTest();
					File scrFile = ((TakesScreenshot) driver)
							.getScreenshotAs(OutputType.FILE);

					String currentDir = System.getProperty("user.dir");

					FileUtils.copyFile(scrFile, new File(currentDir
							+ "/Screenshots/" + result.getMethod().getMethodName()
							+ ".jpg"));

					/*driver.quit();
					initialization();

					rm_LoginPage = new RM_LoginPage();
					rm_HomePage = rm_LoginPage.Login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);*/

					// takeScreenshot(dateTimeStamp,driver,methodName);
					// System.out.println("Log Message:: @AfterMethod: Method-"+methodName+"- has Failed");
					// Do your excel writing stuff here

				} else if (result.getStatus() == ITestResult.SKIP) {
					System.out.println("================");
					System.out.println(result.getMethod().getMethodName());
					System.out.println("======Skip======");
					driver.quit();
					initialization(browserName);

					/*rm_LoginPage = new SD_LoginPage();
					rm_HomePage = rm_LoginPage.Login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);*/

				}
			
		}

		@AfterClass
		public void TearDown() {
			driver.quit();
		}


	}

