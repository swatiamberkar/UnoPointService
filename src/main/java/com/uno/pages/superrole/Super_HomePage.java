package com.uno.pages.superrole;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Super_HomePage extends Super_LoginPage 
{

	public Super_HomePage() {
		PageFactory.initElements(driver, this);

	}

	public String homePageTitle() {
		return driver.getTitle();

	}

	public Super_EmployeeMasterPage clickEmpolyeeMasterlink() {
		tabEmployeeMaster.click();
		return new Super_EmployeeMasterPage();
	}

	public Super_SDMasterPage clickSdMasterlink() throws Exception {
		highLight(tabSDMaster);
		tabSDMaster.click();
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(tabSDMaster).build();
		seriesOfActions.perform();
		//tabSDMaster.click();
		return new Super_SDMasterPage();
	}

	public Super_AdminPage clickAdminLink() {
		tabAdmin.click();
		return new Super_AdminPage();
	}

	public Super_InventoryMastersPage clickInventoryMastersLink() {
		tabInventoryMasters.click();
		return new Super_InventoryMastersPage();
	}

}
