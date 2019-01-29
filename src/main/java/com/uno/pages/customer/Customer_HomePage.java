package com.uno.pages.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.uno.baseClass.BaseCode;
import com.uno.pages.sd.SD_AttendancePage;
import com.uno.pages.sd.SD_TicketPage;
import com.uno.pages.sd.SD_TicketSummaryPage;

public class Customer_HomePage extends BaseCode
{
	
	//Select Create New
		//	@FindBy(css="a[href='/erprmwise/IncidentAction.do']")
			@FindBy(xpath ="//a[@title='Create New']")
		    WebElement tabCreateNew;
			
			
   //select View Incident 
		//	@FindBy(css="/erprmwise/SearchIncidentPage.do?MenuClick=ViewIncident']")
			@FindBy(xpath ="//a[@title='View Incident']")
			WebElement tabViewIncident;
			
	//select Report Tab
			@FindBy(css="/erprmwise/ViewJasperCustomerReportAddAction.do?subAction=CustomerWise']")
			WebElement tabReport;
			
			
	//Initializing Page Object
			public Customer_HomePage()
			{
				PageFactory.initElements(driver, this);
			}
			
	//Validate Home Page Title
			public String homePageTitle()
			{
				return driver.getTitle();
			}
			
	 //Click on View Incident
			public Customer_ViewIncidentPage ViewIncidentTab()
			{
				tabViewIncident.click();
				return new Customer_ViewIncidentPage();
			}
			
	
			
	

}
