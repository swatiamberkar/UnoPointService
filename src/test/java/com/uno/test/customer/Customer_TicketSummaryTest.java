package com.uno.test.customer;





import java.io.File;
import java.lang.reflect.Method;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.uno.baseClass.BaseCode;
import com.uno.pages.customer.Customer_HomePage;
import com.uno.pages.customer.Customer_TicketSummaryPages;
import com.uno.pages.sd.SD_HomePage;
import com.uno.pages.sd.SD_LoginPage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_TicketSummaryPage;
import com.uno.pages.sd.SD_ViewTicketPage;
import com.uno.pages.technician.Technician_HomePage;
import com.uno.pages.technician.Technician_IncidentPage;
import com.uno.pages.technician.Technician_TicketSummaryPage;
import com.uno.pages.technician.Technician_ViewIncidentPage;




public class Customer_TicketSummaryTest extends BaseCode{

	
	SD_LoginPage sd_LoginPage;
	Customer_HomePage customer_HomePage;
	Technician_IncidentPage technician_IncidentPage;
	Technician_ViewIncidentPage technician_ViewIncidentPage;

	Customer_TicketSummaryPages customer_TicketSummaryPage;
	Integer count;
	Integer totalcount;

	
	public Customer_TicketSummaryTest ()
	{
		super();
	}
	@Parameters("browserName")
	@BeforeClass(alwaysRun = true)
	public void Setup(String browserName) throws Exception {

		initialization(browserName);
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
	public void ticketSummary(Method method) throws Exception {
		String path= currentDir + "/Recording/"+ method.getName();
		startRecording(path,method.getName());
		customer_HomePage = new Customer_HomePage();
		tabHomeOfCustomer.click();
		customer_TicketSummaryPage = new Customer_TicketSummaryPages();
			

	}
	
	
	
	@Test(priority=1, groups = { "Open Tab", "Smoke Testing" })
			public void VerifyTotalCountAndStatusOfRequestsOpenTab() throws Exception
			{
			
			customer_TicketSummaryPage.verifyTotalCountAndStatusOfRequestsOpenTab();
			}
	
		
	@Test(priority=2, groups = { "Work In Progress Tab", "Smoke Testing" })
			public void TotalCountAndStatusOfRequestsPausedTab() throws Exception
			{
				customer_TicketSummaryPage.totalCountAndStatusOfRequestsPausedTab();
			}
		
	@Test(priority=3, groups = { "Work In Progress Tab", "Smoke Testing" })
			public void TotalCountAndStatusOfRequestsCancelTab() throws Exception
			{
				customer_TicketSummaryPage.totalCountAndStatusOfRequestsCancelTab();
			}


	@Test(priority=4, groups = { "Work In Progress Tab", "Smoke Testing" })
	public void TotalCountAndStatusOfRequestsClosedTab() throws Exception
	{
		customer_TicketSummaryPage.totalCountAndStatusOfRequestsClosedTab();
	}

	@Test(priority=5, groups = { "Work In Progress Tab", "Smoke Testing" })
	public void TotalCountAndStatusOfRequestsClosedByTechnicianTab() throws Exception
	{
		customer_TicketSummaryPage.totalCountAndStatusOfRequestsClosedByTechnicianTab();
	}
		

	@Test(priority=34, groups = { "Resolved Tab", "Smoke Testing" })
			public void TotalCountOfAllRequestsTab() throws Exception
			{
				customer_TicketSummaryPage.totalCountOfAllRequestsTab();
			}
	
	@Parameters("browserName")
	@AfterMethod
	public void writeResult(ITestResult result, Method method, String browserName) throws Exception {
		stopRecording();
		String path= currentDir + "/Recording/"+method.getName();
		changeFileName(path,method.getName());
		
		try{
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

			FileUtils.copyFile(scrFile, new File(currentDir + "/Screenshots/"
					+ result.getMethod().getMethodName() + ".jpg"));

		} else if (result.getStatus() == ITestResult.SKIP) {
			System.out.println("================");
			System.out.println(result.getMethod().getMethodName());
			System.out.println("======Skip======");
	

		}
}catch(Exception e)
{
	driver.quit();
	initialization(browserName);

	

	sd_LoginPage = new SD_LoginPage();
	customer_HomePage = sd_LoginPage.customerLogin(
			properties.getProperty("loginIdForTechnician"),
			properties.getProperty("password"));
	Thread.sleep(1000);
/*	technician_HomePage = new SD_HomePage();
	driver.findElement(By.cssSelector("a[href='/erprmwise/SDHomeScreen.do']")).click();
	 sd_TicketSummaryPage=technician_HomePage.ticketSummaryTab();*/
	}

	}

	@AfterClass

	public void TearDown() {
		driver.quit();
	}

	


}
