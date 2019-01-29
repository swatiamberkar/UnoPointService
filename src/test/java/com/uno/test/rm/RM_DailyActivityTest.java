package com.uno.test.rm;

import io.qameta.allure.Description;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.rm.RM_DailyActivityPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_IncidentPage;
import com.uno.pages.rm.RM_LoginPage;

public class RM_DailyActivityTest extends BaseCode {
	

	
	RM_LoginPage rm_LoginPage;
	RM_HomePage rm_HomePage;
	RM_IncidentPage rm_IncidentPage;
		RM_DailyActivityPage rm_DailyActivityPage;

		public RM_DailyActivityTest() {

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
		public void ViewTicket() throws Exception {

			rm_HomePage = new RM_HomePage();
			rm_IncidentPage = rm_HomePage.IncidentTab();
			Thread.sleep(1000);
			rm_DailyActivityPage = rm_IncidentPage.DailyActivityTab();
			Thread.sleep(1000);

		}

		@Test(priority = 1, groups = { "Add Daily Activity Popup" }, description = "If User click on Add activity button in Daily Activity form, then Add Daily Activity popup should display.")
		@Description("If User click on Add activity button in Daily Activity form, then Add Daily Activity popup should display ")
		public void varifyHeadingOfAddDailyActivityPopup() throws Exception {

			rm_DailyActivityPage.varifyHeadingOfAddDailyActivityPopup();

		}

		@Test(priority = 2, groups = { "Add Daily Activity Popup" }, description = "1. If User click on Add button in Add Daily Activity popup with blank date then notification should display as 'Please Select Date.'"
				+ "2. If User not select time then notification should display as 'Please Select Time.'"
				+ "3. If User click on Add button in Add Daily Activity popup with blank location field then notification should display as 'Please Select Location.'"
				+ "4. If User keep 'All' option in Incident ID and click on Add button then notification should display as 'Please Select Incident ID.'"
				+ "5. If User select Incident ID from list then as per selected ID, customer name should get autofill"
				+ "6. If User click on Add button in Add Daily Activity popup without select Activity Header field then notification should display as 'Please Select Activity Header.'"
				+ "7. If User click on Add button in Add Daily Activity popup with blank activity field then notification should display as 'Please Select Activity.'"
				+ "8. If User click on Add button in Add Daily Activity popup with blank activity remark field then notification should display as 'Please Select Activity Remark.'")
		@Description("1. If User click on Add button in Add Daily Activity popup with blank date then notification should display as 'Please Select Date.'"
				+ "2. If User not select time then notification should display as 'Please Select Time.'"
				+ "3. If User click on Add button in Add Daily Activity popup with blank location field then notification should display as 'Please Select Location.'"
				+ "4. If User keep 'All' option in Incident ID and click on Add button then notification should display as 'Please Select Incident ID.'"
				+ "5. If User select Incident ID from list then as per selected ID, customer name should get autofill"
				+ "6. If User click on Add button in Add Daily Activity popup without select Activity Header field then notification should display as 'Please Select Activity Header.'"
				+ "7. If User click on Add button in Add Daily Activity popup with blank activity field then notification should display as 'Please Select Activity.'"
				+ "8. If User click on Add button in Add Daily Activity popup with blank activity remark field then notification should display as 'Please Select Activity Remark.'")
		public void checkNotificationWithoutSelectionInAddDailyActivityPopup()
				throws Exception {

			rm_DailyActivityPage
					.checkNotificationWithoutSelectionInAddDailyActivityPopup();

		}

		@Test(priority = 3, groups = { "Add Daily Activity From" }, description = "After enter all details if user click on Add button then daily activity entry should get create in Daily activity table and notification should display as 'Activity Added Successfully.'")
		@Description("After enter all details if user click on Add button then daily activity entry should get create in Daily activity table and notification should display as 'Activity Added Successfully.'")
		public void checkNotificationWithSelectionAndVarifyDataInAddDailyActivityFrom()
				throws Exception {

			rm_DailyActivityPage
					.checkNotificationWithSelectionAndVarifyDataInAddDailyActivityFrom();

		}

		@Test(priority = 4)
		public void checkDataFilterByIncidentID() throws Exception {

			rm_DailyActivityPage.checkDataFilterByIncidentID();

		}
		

	/*	@Test(priority = 5)
		public void checkDataFilterByCustomerName() throws Exception {

			rm_DailyActivityPage.checkDataFilterByCustomerName();

		}*/

		@Test(priority = 6)
		public void checkDataFilterByActivityHeader() throws Exception {

			rm_DailyActivityPage.checkDataFilterByActivityHeader();
			

		}

		@Test(priority = 7)
		public void checkDateAccordingFromAndToDate() throws Exception {

			rm_DailyActivityPage.checkDateAccordingFromAndToDate();

		}

		@Test(priority = 8)
		public void checkDaysAccordingDates() throws Exception {

			rm_DailyActivityPage.checkDaysAccordingDates();

		}

		@Test(priority = 9)
		public void checkTimeAccordingTAT() throws Exception {

			rm_DailyActivityPage.checkTimeAccordingTAT();

		}

		@Test(priority = 10, groups = { "Update Daily Activity From" }, description = "1. If User click on Update icon then 'Update Daily Activity' popup should display with all details of selected activity"
				+ "	2. after update any details if user click on Update button then daily activity should get update with same details  and notification should display as 'Activity Updated Successfully.'")
		@Description("1. If User click on Update icon then 'Update Daily Activity' popup should display with all details of selected activity"
				+ "2. after update any details if user click on Update button then daily activity should get update with same details  and notification should display as 'Activity Updated Successfully.'")
		public void updateDailyActivity() throws Exception {

			rm_DailyActivityPage.updateDailyActivity();

		}

		@Test(priority = 11, groups = { "Delete Daily Activity From" }, description = "1. If User click on Delete symbol of daily activity then alert message should display as 'Do you want to delete this Daily Activity? '"
				+ "2. If User click on OK button then same daily activity should get delete with notification should display as 'Activity Deleted Successfully.'"
				+ "3. After delete daily activity, Total count should descrese with 1")
		@Description("1. If User click on Delete symbol of daily activity then alert message should display as 'Do you want to delete this Daily Activity? '"
				+ "2. If User click on OK button then same daily activity should get delete with notification should display as 'Activity Deleted Successfully.'"
				+ "3. After delete daily activity, Total count should descrese with 1")
		public void DeleteDailyActivity() throws Exception {

			rm_DailyActivityPage.deleteDailyActivity();

		}
		
		@Test(priority = 12, groups = { "Delete Daily Activity From" }, description = "If User click on Cancel button then daily activity should not get delete. ")
				
		@Description("If User click on Cancel button then daily activity should not get delete.")
		public void ClickOnDeleteSymbolInDailyActivity() throws Exception {

			rm_DailyActivityPage.clickOnDeleteSymbolInDailyActivity();

		}

		@AfterMethod
		public void writeResult(ITestResult result) throws Exception {

		
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

					rm_LoginPage = new SD_LoginPage();
					rm_HomePage = rm_LoginPage.Login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);
*/
					// takeScreenshot(dateTimeStamp,driver,methodName);
					// System.out.println("Log Message:: @AfterMethod: Method-"+methodName+"- has Failed");
					// Do your excel writing stuff here

				} else if (result.getStatus() == ITestResult.SKIP) {
					System.out.println("================");
					System.out.println(result.getMethod().getMethodName());
					System.out.println("======Skip======");
					/*driver.quit();
					initialization();

					rm_LoginPage = new SD_LoginPage();
					rm_HomePage = rm_LoginPage.Login(
							properties.getProperty("loginIdForSd"),
							properties.getProperty("password"));
					Thread.sleep(1000);*/
					// System.out.println("Log Message::@AfterMethod: Method-"+methodName+"- has Skipped");

				}
			
		}

		@AfterClass
		public void TearDown() {
			driver.quit();
		}

	}



