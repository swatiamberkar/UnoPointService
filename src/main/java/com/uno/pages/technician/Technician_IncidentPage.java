package com.uno.pages.technician;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.uno.baseClass.BaseCode;

public class Technician_IncidentPage extends BaseCode
{
	
		@FindBy(xpath = "//ul[@class='nav-ul']//li[2]//div[1]//div[1]//ul[1]//li[1]//a[1]//span[1]")
		WebElement tab_ViewIncident;
	
	/*@FindBy(linkText = "View Incident")
	WebElement tab_ViewIncident;*/
		
		// select view sub ticket
		@FindBy(css = "a[href='/erprmwise/ViewSubRequests.do?MainAction=ViewSubTicket']")
		WebElement tabViewSubTicket;

		// select My Availability
		@FindBy(css = "a[href='/erprmwise/EngineerAvailability.do']")
		WebElement tabMyAvailability;

		
		
	//Initializing Page Object
		public Technician_IncidentPage()
		{
			PageFactory.initElements(driver, this);
		}
		
	//Click on Incident Tab
		public Technician_ViewIncidentPage ViewIncidentTab() throws Exception
		{
			//scrollDown(tab_ViewIncident);
			highLight(tab_ViewIncident);
		
			driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
			tab_ViewIncident.click();
			Actions builder = new Actions(driver);
			Action seriesOfActions = builder
				.moveToElement(tab_ViewIncident).build();
			//seriesOfActions.perform();
			Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
			//tab_ViewIncident.click();
			return new Technician_ViewIncidentPage();
		}
		
		public Technician_EditIncidentPage EditIncidentTab() throws Exception
		{
			/*scrollDown(tab_ViewIncident);
			//WebDriverWait wait = new WebDriverWait(driver, 120);
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='main']/div[2]/div[2]/div/ul/li[2]/div/div/ul/li/a/span")));
			tab_ViewIncident.click();
			//driver.findElement(By.xpath("//div[@id='main']/div[2]/div[2]/div/ul/li[2]/div/div/ul/li/a/span")).click();
*/	
			//scrollDown(tab_ViewIncident);
			highLight(tab_ViewIncident);
		
			driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
			tab_ViewIncident.click();
			Actions builder = new Actions(driver);
			Action seriesOfActions = builder
				.moveToElement(tab_ViewIncident).build();
			//seriesOfActions.perform();
			Thread.sleep(2000);
			driver.manage().timeouts().pageLoadTimeout(500, TimeUnit.SECONDS);
			//tab_ViewIncident.click();
			
			return new Technician_EditIncidentPage();
		}

		// Click on Incident Tab
		public Technician_MyAvailabilityPage MyAvailabilityTab() {
			tabMyAvailability.click();
			return new Technician_MyAvailabilityPage();
		}
		
		
				

}
