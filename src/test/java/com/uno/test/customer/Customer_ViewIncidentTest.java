package com.uno.test.customer;

import java.io.File;
import java.lang.reflect.Method;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
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
import com.uno.excelUtility.TestUtil;
import com.uno.pages.customer.Customer_HomePage;
import com.uno.pages.customer.Customer_TicketSummaryPages;
import com.uno.pages.customer.Customer_ViewIncidentPage;
import com.uno.pages.rm.RM_HomePage;
import com.uno.pages.rm.RM_LoginPage;

import com.uno.pages.sd.SD_LoginPage;

public class Customer_ViewIncidentTest extends BaseCode {

	
	String xlFilePath = "D:\\UnoPoint\\UnoPointService\\src\\main\\java\\com\\uno\\excelFile\\Technician_ViewIncident.xlsx";
	String sheetId = "Id";
	String sheetAssetId = "AssetId";
	String sheetTicketId = "TicketId";
	String sheetStatus = "Status";
	String sheetTicketType = "TicketType";
	String sheetCTS = "CTS";
	String sheetState = "State";
	String sheetCustomer = "Customer";
	String sheetEngineer = "Engineer";
	String sheetCreatedByRole = "CreatedByRole ";
	String sheetCreatedBy = "CreatedBy";
	String sheetCategory = "Category";
	String sheetSubCategory = "SubCategory";

	String idColumn = "txt_Id";
	String assetIdColumn = "txt_AssetId";
	String currentDir = System.getProperty("user.dir");

	public Customer_ViewIncidentTest() {

		super();

	}
	//String browserName 
	//@Parameters("browserName")
	@BeforeClass(alwaysRun = true)
	public void Login() throws Exception {
		initialization();
		//initialization(browserName);
		sd_LoginPage = new SD_LoginPage();

		Thread.sleep(3000);

		// click on customer
		driver.findElement(By.xpath("//label[@id='customer']")).click();
		// rdoCustomer.click();
		Thread.sleep(2000);

		// click on skip button
		driver.findElement(By.className("skippopup")).click();

		sd_LoginPage = new SD_LoginPage();
		customer_HomePage = sd_LoginPage.customerLogin(properties.getProperty("loginIdForCustomer"),
				properties.getProperty("password"));

		Thread.sleep(2000);
	}
	@BeforeMethod(alwaysRun = true)
	public void ViewTicket(Method method) throws Exception {
	
		String path = currentDir + "/Recording/" + method.getName();
		startRecording(path, method.getName());
	
		try {
			customer_HomePage = new Customer_HomePage();
			Thread.sleep(2000);
			tabHomeInCustomer.click();
			Thread.sleep(2000);
			customer_ViewIncidentPage = customer_HomePage.ViewIncidentTab();
			customer_ViewIncidentPage = new Customer_ViewIncidentPage();
		} catch (Exception e) {
			driver.close();
			initialization();
			//initialization(browserName);
			sd_LoginPage = new SD_LoginPage();
	
			Thread.sleep(3000);
	
			// click on customer
			driver.findElement(By.xpath("//label[@id='customer']")).click();
			// rdoCustomer.click();
			Thread.sleep(2000);
	
			// click on skip button
			driver.findElement(By.className("skippopup")).click();
	
			sd_LoginPage = new SD_LoginPage();
			customer_HomePage = sd_LoginPage.customerLogin(properties.getProperty("loginIdForCustomer"),
					properties.getProperty("password"));
			
			customer_HomePage = new Customer_HomePage();
			customer_ViewIncidentPage = customer_HomePage.ViewIncidentTab();
			customer_ViewIncidentPage = new Customer_ViewIncidentPage();
		}
	}

	@DataProvider
	public String[][] idData() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(xlFilePath, sheetId);

	}

	@Test(priority = 1, groups = { "Smoke Testing" }, dataProvider = "idData", description = "1. If User Click on Go button of ID search field with blank details, then alert box should display as 'Please Enter Incident ID'"
			+ "2. In ID field if user enter alphabets then alert box should display as 'Please Enter The Numeric Value for Incident ID'"
			+ "3. If user enter incident number which is not present in view ticket dashboard then after click on Go button, 0 count is showing"
			+ "4. If User enter correct  ID  and  click on Go button, then system  should display Incident of same  ID")
	@Description("1. If User Click on Go button of ID search field with blank details, then alert box should display as 'Please Enter Incident ID'"
			+ "2. In ID field if user enter alphabets then alert box should display as 'Please Enter The Numeric Value for Incident ID'"
			+ "3. If user enter incident number which is not present in view ticket dashboard then after click on Go button, 0 count is showing"
			+ "4. If User enter correct  ID  and  click on Go button, then system  should display Incident of same  ID")
	public void VerifyIDTextBox(String txt_Id) throws Exception {

		customer_ViewIncidentPage.verifyIdTextBox(txt_Id);

	}

	@DataProvider
	public String[][] assetIdData() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(xlFilePath, sheetAssetId);

	}

	@Test(priority = 2, groups = { "Smoke Testing" }, dataProvider = "assetIdData", description = "1. If User Click on Go button of Asset ID search field with blank details, then alert box should display as 'Please Enter Asset ID'"
			+ "2. If User enter Asset ID which is not present in system then after click on Go button, It should display 0 count in Incident dashboard"
			+ "3. If User enter correct Asset ID and click on Go button, then System should display all Incidents of same Asset ID")
	@Description("1.If User Click on Go button of Asset ID search field with blank details, then alert box should display as 'Please Enter Asset ID'"
			+ "2. If User enter Asset ID which is not present in system then after click on Go button, It should display 0 count in Incident dashboard"
			+ "3. If User enter correct Asset ID and click on Go button, then System should display all Incidents of same Asset ID")
	public void verifyAssetIdTextBox(String txt_AssetId) throws Exception {

		customer_ViewIncidentPage.verifyAssetIdTextBox(txt_AssetId);

	}

	@DataProvider
	public String[][] ticketIdData() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(xlFilePath, sheetTicketId);

	}

	@Test(priority = 3, groups = { "Smoke Testing" }, dataProvider = "ticketIdData", description = "1. If User Click on Go button of Ticket ID search field with blank details, then alert box should display as 'Please Enter Customer Ticket ID'"
			+ "2. If User enter Ticket ID which is not present in system then after click on Go button, It should display 0 count in Incident dashboard"
			+ "3. If User enter correct Ticket ID  and  click on Go button, then system  should display Incident of same ticket ID")
	@Description("1. If User Click on Go button of Ticket ID search field with blank details, then alert box should display as 'Please Enter Customer Ticket ID'"
			+ "2. If User enter Ticket ID which is not present in system then after click on Go button, It should display 0 count in Incident dashboard"
			+ "3. If User enter correct Ticket ID  and  click on Go button, then system  should display Incident of same ticket ID")
	public void verifyTicketIdTextBox(String txt_TicketId) throws Exception {

		customer_ViewIncidentPage.verifyTicketIdTextBox(txt_TicketId);

	}

	@DataProvider
	public String[][] statusData() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(xlFilePath, sheetStatus);
		
	}

	@Test(priority = 4, groups = { "Smoke Testing" }, dataProvider = "statusData", description = "If User select particular status option then in view ticket page, all tickets should display where status should be as per selected status option in filter")
	@Description("If User select particular status option then in view ticket page, all tickets should display where status should be as per selected status option in filter")
	public void verifyStatusDropDown(String data) throws Exception {
		Thread.sleep(1000);
		customer_ViewIncidentPage.verifyStatusDropDown(data);

	}

		@DataProvider
	public String[][] TicketTypeData() throws Exception {
		TestUtil data = new TestUtil();	
		return data.getCellData(xlFilePath, sheetTicketType);

	}

	@Test(priority = 5, groups = { "Smoke Testing" }, dataProvider = "TicketTypeData", description = "If user select particular ticket type then in dashboard, all tickets should display as per selected ticket type filter")
	@Description("If user select particular ticket type then in dashboard, all tickets should display as per selected ticket type filter")
	public void verifyTicketTypeDropDown(String data) throws Exception {
		Thread.sleep(1000);
		customer_ViewIncidentPage.verifyTicketTypeDropDown(data);

	}

	@DataProvider
	public String[][] StateData() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(xlFilePath, sheetState);

	}

	@Test(priority = 6, groups = { "Smoke Testing" }, dataProvider = "StateData", description = "If user select particular CTS then in dashboard, all tickets should display as per selected CTS filter")
	@Description("If user select particular CTS then in dashboard, all tickets should display as per selected CTS filter")
	public void verifyStateDropDown(String data) throws Exception {
		customer_ViewIncidentPage.verifyStateDropDown(data);

	}

		@DataProvider
	public String[][] CustomerData() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(xlFilePath, sheetCustomer);

	}

	@Test(priority = 7, groups = { "Smoke Testing" }, dataProvider = "CustomerData", description = "If User select Particular Customer name option then all calls entries should display related to same selected customer in dashboard")
	@Description("If User select Particular Customer name option then all calls entries should display related to same selected customer in dashboard")
	public void verifyCustomerDropDown(String data) throws Exception {
		customer_ViewIncidentPage.verifyCustomerDropDown(data);

	}

	@DataProvider
	public String[][] EngineerData() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(xlFilePath, sheetEngineer);

	}

	@Test(priority = 8, groups = { "Smoke Testing" }, dataProvider = "EngineerData", description = "If User select Particular Engineer name option then all calls entries should display where In Engineer column selected Engineer name should display")
	@Description("If User select Particular Engineer name option then all calls entries should display where In Engineer column selected Engineer name should display")
	public void verifyEngineerDropDown(String data) throws Exception {
		customer_ViewIncidentPage.verifyEngineerDropDown(data);

	}
/*
	@DataProvider
	public String[][] CreatedByRoleData() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(xlFilePath, sheetCreatedByRole);

	}

	@Test(priority = 9, groups = { "Smoke Testing" }, dataProvider = "CreatedByRoleData", description = "In Created By Role filter, if user select particular role then entries should display where created role is as per selected filter")
	@Description("In Created By Role filter, if user select particular role then entries should display where created role is as per selected filter")
	public void verifyCreatedByRoleDropDown(String data) throws Exception {
		customer_ViewIncidentPage.verifyCreatedByRoleDropDown(data);

	}

	@DataProvider
	public String[][] CreatedByData() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(xlFilePath, sheetCreatedBy);

	}

	@Test(priority = 10, groups = { "Smoke Testing" }, dataProvider = "CreatedByData", description = "If User select Particular Created By option then all calls entries should display where In Created By  column selected Created By option should display")
	@Description("If User select Particular Created By option then all calls entries should display where In Created By  column selected Created By option should display")
	public void verifyCreatedByDropDown(String data) throws Exception {	
		customer_ViewIncidentPage.verifyCreatedByDropDown(data);

	}

		@DataProvider
	public String[][] CategoryData() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(xlFilePath, sheetCategory);

	}

	@Test(priority = 11, groups = { "Smoke Testing" }, dataProvider = "CategoryData", description = "If User select particular category then all entries with same product category should display in Product category field")
	@Description("If User select particular category then all entries with same product category should display in Product category field")
	public void verifyCategoryDropDown(String data) throws Exception {
		customer_ViewIncidentPage.verifyCategoryDropDown(data);

	}

	@DataProvider
	public String[][] SubCategoryData() throws Exception {
		TestUtil data = new TestUtil();
		return data.getCellData(xlFilePath, sheetSubCategory);

	}

	
	@Test(priority = 12, groups = { "Smoke Testing" }, dataProvider = "SubCategoryData", description = "If User select particular category then all entries with same sub product category should display in sub Product category field")
	@Description("If User select particular category then all entries with same sub product category should display in sub Product category field")
	public void verifySubCategoryDropDown(String data) throws Exception {
	
		customer_ViewIncidentPage.verifySubCategoryDropDown(data);

	}
*/

		@Feature("View Ticket")
	@Test(priority = 14, groups = { "Smoke Testing" }, description = "Count the Ticket in all pages.")
	@Description("Count the Ticket in all pages.")
	public void CountOfPagination() throws Exception {
		customer_ViewIncidentPage.countOfPagination();
	}


	@Feature("View Ticket")
	@Test(priority =16, groups = { "Sanity Testing" }, description = "In view ticket page, if user click on Filter button then pop up should display to filter view incident page. By default All option should display in all filters")
	@Description("In view ticket page, if user click on Filter button then"
			+ " pop up should display to filter view incident page. By default All option"
			+ " should display in all filters")
	public void checkDefaultOptionOfFilterTab() throws Exception {
		customer_ViewIncidentPage.checkDefaultOptionOfFilterTab();

	}

	@Feature("View Ticket")
	@Test(priority = 17, groups = { "Sanity Testing" }, description = "Display Pages As Per Arrows Of Pagination")
	@Description("Display Pages As Per Arrows Of Pagination")
	public void DisplayAsPerArrowsOfPagination() throws Exception {
		customer_ViewIncidentPage.displayAsPerArrowsOfPagination();
	}

	@Feature("View Ticket")
	@Test(priority = 18, groups = { "View Ticket" }, description = "Check Title of View Ticket Page.")
	@Description("Check Title of View Ticket Page.")
	public void TitleOfViewTicketPage() {
		customer_ViewIncidentPage.displayTitleOfViewTicketPage();
	
	}
	
	@Feature("View Ticket")
	@Test(priority = 19, groups = { "View Ticket" }, description = "Display all Incident Id in descending Order.")
	@Description("Display all Incident Id in descending Order.")
	public void DisplayDescendingOrderOfIncidentID() throws Exception {
		customer_ViewIncidentPage.displayDescendingOrderOfIncidentID();
	}
	
	@Feature("View Ticket")
	@Test(priority = 20, groups = { "View Ticket" }, description = "Check Hyper link is present for all ID's")
	@Description("Check Hyper link is present for all ID's")
	public void CheckHyperlinkOfID() throws Exception {
		customer_ViewIncidentPage.checkHyperlinkOfID();
	}

	/*
	@Feature("View Ticket")
	@Test(priority = 23, groups = { "View Ticket" }, description = "Check Blinking Notification is Correct or not.")
	@Description("Check Blinking Notification is Correct or not.")
	public void CheckBlinkingNotification() throws Exception {
		customer_ViewIncidentPage.checkBlinkingNotification();

	}
	
	@Feature("View Ticket")
	@Test(priority = 24, groups = { "View Ticket" }, description = "Check Customer in Incident History Of Customer Page is Same or not.")
	@Description("Check Customer in Incident History Of Customer Page is Same or not.")
	public void checkCustomer() throws Exception {
		customer_ViewIncidentPage.checkCustomer();
	}
	
	@Feature("View Ticket")
	@Test(priority = 25, groups = { "View Ticket" }, description = "Check Asset ID in Incident History Of Asset ID Page is Same or not.")
	@Description("Check Asset ID in Incident History Of Asset ID Page is Same or not.")
	public void checkAssetID() throws Exception {
		customer_ViewIncidentPage.checkAssetID();
	}

	@Feature("View Ticket")
	@Test(priority = 26, groups = { "View Ticket" }, description = "Check Hidden Message Of Flag For Address is Correct or not.")
	@Description("Check Hidden Message Of Flag For Address is Correct or not.")
	public void CheckHiddenMessageOfAddress() throws Exception {
		customer_ViewIncidentPage.checkHiddenMessageOfAddress();
	}
	*/
	
	//String browserName
	//@Parameters("browserName")
	@AfterMethod
	public void writeResult(ITestResult result, Method method ) throws Exception {

		stopRecording();
		String path = currentDir + "/Recording/" + method.getName();
		changeFileName(path, method.getName());

			try {
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

				} else if (result.getStatus() == ITestResult.SKIP) {
					System.out.println("================");
					System.out.println(result.getMethod().getMethodName());
					System.out.println("======Skip======");
					driver.quit();
					initialization();
					//initialization(browserName);

					rm_LoginPage = new RM_LoginPage();
					Thread.sleep(1000);
					rm_HomePage = rm_LoginPage.Login(
							properties.getProperty("loginIdForRM"),
							properties.getProperty("password"));
					
					
				}
			} catch (Exception e) {
				driver.quit();
				initialization();
				//initialization(browserName);

				rm_LoginPage = new RM_LoginPage();
				Thread.sleep(1000);
				rm_HomePage = rm_LoginPage.Login(
						properties.getProperty("loginIdForRM"),
						properties.getProperty("password"));
				Thread.sleep(1000);
				
			}
		

	}

	@AfterClass
	public void TearDown() {
		driver.quit();
	}

}
