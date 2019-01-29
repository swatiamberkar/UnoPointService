package com.uno.Page.customer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;


public class Customer_ViewIncidentPage extends BaseCode{
	
	// Initializing Page Object
	public Customer_ViewIncidentPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void clickOnSerachTicketTab() throws Exception
	{
		
		Thread.sleep(500);
		highLight(tabSearchTicketOpen);
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(tabSearchTicketOpen).build();
		seriesOfActions.perform();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		tabSearchTicketOpen.click();
		Thread.sleep(500);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		
	}
	
	public void verifyIdTextBox(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabSearchInCustomer.click();
		System.out.println("Input : "+data);
		txtSearchId.sendKeys(data);
		btnGoOfIdInCustomer.click();
		
		
			try {
				if(data.isEmpty())
				{
					Alert alert = driver.switchTo().alert();
					String alertMessage = alert.getText();
					Thread.sleep(500);
					System.out.println("Alert Text:" + alertMessage);
					alert.accept();
					driver.switchTo().defaultContent();


					softAssert.assertEquals(alertMessage,
							"Please Enter Incident ID");
					System.out.println("Both the message is equal");
				}
				else
				{
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				Thread.sleep(500);
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				driver.switchTo().defaultContent();


				softAssert.assertEquals(alertMessage,
						"Please Enter The Numeric Value for Incident ID");
				System.out.println("Both the message is equal");
				}
			} 
			catch (Exception e) {
				
		    int rowSize=lstRow.size();
		    if(rowSize==1)
		    {
		    	highLight(lblcountInCustomer);
		    	String textOfTotalCount= lblcountInCustomer.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"Total Ticket Count: 1","Count is not match");
		    }
		    else
		    {
		    	highLight(lblcountInCustomer);
		    	String textOfTotalCount= lblcountInCustomer.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"Total Ticket Count: 0","Count is not match");	
		    }
		    
		}
			
	
			softAssert.assertAll();
	}
	
	public void verifyAssetIdTextBox(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabSearchInCustomer.click();
		System.out.println("Input : "+data);
		txtSearchAssetID.sendKeys(data);
		btnGoOfAssetIdINCustomer.click();
		
		
			try {
				if(data.isEmpty())
				{
					Alert alert = driver.switchTo().alert();
					String alertMessage = alert.getText();
					Thread.sleep(500);
					System.out.println("Alert Text:" + alertMessage);
					alert.accept();
					driver.switchTo().defaultContent();


					softAssert.assertEquals(alertMessage,
							"Please Enter Asset Id");
					System.out.println("Both the message is equal");
				}
				else
				{
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				Thread.sleep(500);
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				driver.switchTo().defaultContent();


				softAssert.assertEquals(alertMessage,
						"Please Enter The Numeric Value for Incident ID");
				System.out.println("Both the message is equal");
				}
			} 
			catch (Exception e) {
				
		    int rowSize=lstRow.size();
		    if(rowSize>=1)
		    {
		    	highLight(lblcountInCustomer);
		    	String textOfTotalCount= lblcountInCustomer.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"Total Ticket Count: "+rowSize,"Count is not match");
		    }
		    else
		    {
		    	String textOfTotalCount= lblcountInCustomer.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"Total Ticket Count: 0","Count is not match");	
		    }
		    
		}
			
	
			softAssert.assertAll();
	}
	
	public void verifyTicketIdTextBox(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		tabSearchInCustomer.click();
		System.out.println("Input : "+data);
		txtSearchTicketID.sendKeys(data);
		btnGoOfTicketIdInCustomer.click();
		
		
			try {
				if(data.isEmpty())
				{
					Alert alert = driver.switchTo().alert();
					String alertMessage = alert.getText();
					Thread.sleep(500);
					System.out.println("Alert Text:" + alertMessage);
					alert.accept();
					driver.switchTo().defaultContent();


					softAssert.assertEquals(alertMessage,
							"Please Enter Customer Ticket ID");
					System.out.println("Both the message is equal");
				}
				else
				{
				Alert alert = driver.switchTo().alert();
				String alertMessage = alert.getText();
				Thread.sleep(500);
				System.out.println("Alert Text:" + alertMessage);
				alert.accept();
				driver.switchTo().defaultContent();


				softAssert.assertEquals(alertMessage,
						"Please Enter The Numeric Value for Incident ID");
				System.out.println("Both the message is equal");
				}
			} 
			catch (Exception e) {
				
		    int rowSize=lstRow.size();
		    if(rowSize>=1)
		    {
		    	highLight(lblcountInCustomer);
		    	String textOfTotalCount= lblcountInCustomer.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"Total Ticket Count: "+rowSize,"Count is not match");
		    }
		    else
		    {
		    	highLight(lblcountInCustomer);
		    	String textOfTotalCount= lblcountInCustomer.getText();
				System.out.println("textOfTotalCount : "+textOfTotalCount);
				softAssert.assertEquals(textOfTotalCount,"Total Ticket Count: 0","Count is not match");	
		    }
		    
		}
			
	
			softAssert.assertAll();
	}
	
	
	public void clickFilterTab() throws Exception
	{
		Thread.sleep(500);
		//highLight(tabFilter);
		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(tabFilter).build();
		seriesOfActions.perform();
		tabFilter.click();
	}
	

	
	public void verifyStatusDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(2000);
		clickFilterTab();
		Select status= new Select(ddlStatusFilterName);
		Thread.sleep(1000);
		String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(dataWithoutSpaces);
		Thread.sleep(5000);
		System.out.println("Input : "+dataWithoutSpaces);
		int size =lstStatusInTableInCustomer.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstStatusInTableInCustomer.get(i));
			highLight(lstStatusInTableInCustomer.get(i));
			String statusValue=lstStatusInTableInCustomer.get(i).getText();
			System.out.println("StatusValue: "+statusValue);
			softAssert.assertEquals(statusValue, dataWithoutSpaces,"Status value is not Same.");
		}
			softAssert.assertAll();
	}
	
	public void verifyTicketTypeDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		clickFilterTab();
		Select status= new Select(ddlTicketType);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(data);
		Thread.sleep(1000);
		System.out.println("Input : "+data);
		int size =lstTicketTypeInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstTicketTypeInTable.get(i));
			highLight(lstTicketTypeInTable.get(i));
			String ticketType=lstTicketTypeInTable.get(i).getText();
			System.out.println("ticketType: "+ticketType);
			softAssert.assertEquals(ticketType, data,"Ticket Type value is not Same.");
		}
			softAssert.assertAll();
	}
	
	public void verifyStateDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		clickFilterTab();
		Select status= new Select(ddlState);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(data);
		System.out.println("Input : "+data);
		Thread.sleep(1000);
		int size =lstStateInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstStateInTable.get(i));
			highLight(lstStateInTable.get(i));
			String cts=lstStateInTable.get(i).getText();
			System.out.println("cts: "+cts);
			softAssert.assertEquals(cts, data,"CTS value is not Same.");
		}
			softAssert.assertAll();
	}
	
	public void verifyCustomerDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		clickFilterTab();
		Select status= new Select(ddlCustomer);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(data);
		System.out.println("Input : "+data);
		
		Thread.sleep(1000);
		int size =lstCustomerInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstCustomerInTable.get(i));
			highLight(lstCustomerInTable.get(i));
			String customer=lstCustomerInTable.get(i).getText();
			System.out.println("customer: "+customer);
			softAssert.assertEquals(customer, data,"Customer value is not Same.");
		}
			softAssert.assertAll();
	}

	public void verifyEngineerDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		clickFilterTab();
		Select status= new Select(ddlEngineer);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(data);
		Thread.sleep(1000);
		System.out.println("Input : "+data);
		int size =lstEngineerInTableInCustomer.size();
		System.out.println("size: "+size);
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstEngineerInTableInCustomer.get(i));
			highLight(lstEngineerInTableInCustomer.get(i));
			String engineer=lstEngineerInTableInCustomer.get(i).getText();
			String engineerSplit =engineer.split(" ")[0];
			System.out.println("engineer: "+engineerSplit);
			String dot=".";
			softAssert.assertEquals(engineerSplit+" "+dot, data,"Engineer value is not Same.");
		}
			softAssert.assertAll();
	}

	public void verifyCreatedByRoleDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		clickFilterTab();
		Select status= new Select(ddlCreateByRole);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		status.selectByVisibleText(data);
		Thread.sleep(1000);
		System.out.println("Input : "+data);
		setMyView();
		int size =lstCreatedByRoleInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstCreatedByRoleInTable.get(i));
			highLight(lstCreatedByRoleInTable.get(i));
			String createdByRole=lstCreatedByRoleInTable.get(i).getText();
			
			System.out.println("createdByRole: "+createdByRole);
			softAssert.assertEquals(createdByRole, data,"Created By Role value is not Same.");
		}
			softAssert.assertAll();
	}
	
	public void verifyCreatedByDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		clickFilterTab();
		Select createBy= new Select(ddlCreateBy);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		createBy.selectByVisibleText(data);
		Thread.sleep(1000);
		System.out.println("Input : "+data);
		setMyView();
		int size =lstCreatedByInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstCreatedByInTable.get(i));
			highLight(lstCreatedByInTable.get(i));
			String createdBy=lstCreatedByInTable.get(i).getText();
			System.out.println("createdBy: "+createdBy);
			
			String dataSplit =data.split(" ")[0];
			System.out.println("createdBy: "+dataSplit);
			softAssert.assertEquals(createdBy, dataSplit,"Created By value is not Same.");
			
		}
			softAssert.assertAll();
	}
	
	public void verifyCategoryDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		clickFilterTab();
		Select category= new Select(ddlCategory);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		category.selectByVisibleText(data);
		Thread.sleep(1000);
		System.out.println("Input : "+data);
		setMyView();
		int size =lstCategoryInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstCategoryInTable.get(i));
			highLight(lstCategoryInTable.get(i));
			String categoryValue=lstCategoryInTable.get(i).getText();
			System.out.println("categoryValue: "+categoryValue);
			
			softAssert.assertEquals(categoryValue, data,"Category value is not Same.");
			
		}
			softAssert.assertAll();
	}


	public void verifySubCategoryDropDown(String data) throws Exception
	{
		SoftAssert softAssert = new SoftAssert();
		Thread.sleep(1000);
		clickFilterTab();
		Select subCategory= new Select(ddlSubCategory);
		Thread.sleep(1000);
		//String dataWithoutSpaces = data.replaceAll("\\s+","");
		subCategory.selectByVisibleText(data);
		Thread.sleep(1000);
		System.out.println("Input : "+data);
		setMyView();
		int size =lstSubCategoryInTable.size();
		for (int i = 0; i < size; i++) {
			
			scrollDown(lstSubCategoryInTable.get(i));
			highLight(lstSubCategoryInTable.get(i));
			String subCategoryValue=lstSubCategoryInTable.get(i).getText();
			System.out.println("subCategoryValue: "+subCategoryValue);
			
			softAssert.assertEquals(subCategoryValue, data,"Sub Category value is not Same.");
			
		}
			softAssert.assertAll();
	}


	// In view ticket page, if user click on Filter button then pop up
	// should display to filter view incident page. By default All option should
	// display in all filters
	public void checkDefaultOptionOfFilterTab() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Thread.sleep(500);
		// click on filter tab
		clickFilterTab();

		// get the text from state filter which is already selected
		String stateFilter = ddlStateFilter.getText();
		System.out.println("selected state:-" + stateFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(stateFilter, "All");

		// Thread.sleep(1000);
		// get the text from status filter which is already selected
		String statusFilter = ddlStatusFilter.getText();
		System.out.println("selected Status:-" + statusFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(statusFilter, "All");

		// Thread.sleep(1000);
		// get the text from Ticket Type filter which is already selected
		String ticketTypeFilter = ddlTicketTypeFilter.getText();
		System.out.println("selected Ticket Type:-" + ticketTypeFilter);

		
		// if value is equal All the test case is pass
		softAssert.assertEquals(ticketTypeFilter, "All");

		// Thread.sleep(1000);
		String ctsFilter = ddlCTSFilter.getText();
		System.out.println("selected CTS:-" + ctsFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(ctsFilter, "All");

		// Thread.sleep(1000);
		String customerNameFilter = ddlCustomerNameFilter.getText();
		System.out.println("selected customer:-" + customerNameFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(customerNameFilter, "All");

		// Thread.sleep(1000);
		String enginnerFilter = ddlEnginnerFilter.getText();
		System.out.println("selected Engineer:-" + enginnerFilter);

		// Thread.sleep(1000);
		String createByRoleFilter = ddlCreateByRoleFilter.getText();
		System.out.println("selected Create By Role:-" + createByRoleFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(createByRoleFilter, "All");

		// Thread.sleep(1000);
		String createByFilter = ddlCreateByFilter.getText();
		System.out.println("selected Create By:-" + createByFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(createByFilter, "All");

		// Thread.sleep(1000);
		String categoryFilter = ddlCategoryFilter.getText();
		System.out.println("selected Category:-" + categoryFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(categoryFilter, "All");

		// Thread.sleep(1000);
		String subCategoryFilter = ddlSubCategoryFilter.getText();
		System.out.println("selected Sub Category:-" + subCategoryFilter);

		// if value is equal All the test case is pass
		softAssert.assertEquals(subCategoryFilter, "All");
		// tab_Filter.click();
		softAssert.assertAll();
		Thread.sleep(3000);

	}
	
	// Display As Per Arrows Of Pagination
	public void displayAsPerArrowsOfPagination() throws Exception {
		SoftAssert softAssert = new SoftAssert();
		// Click on leftmost arrow
		int size = dropdown_PaginationInCustomer.size();
		System.out.println("size" + size);
		highLight(arrow_LeftmostArrowOfPaginationInCustomer);
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		arrow_LeftmostArrowOfPaginationInCustomer.click();
		Thread.sleep(8000);
		String leftMostPage = page_SelectedInPaginationInCustomer.getAttribute("value");
		System.out.println("leftMostPage " + leftMostPage);
		softAssert.assertEquals("1", leftMostPage, "Left most Arrow Of Pagination Page Size not Same");

		// Click on Rightmost arrow
		// Thread.sleep(500);
		highLight(arrow_RightmostArrowOfPaginationInCustomer);
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		arrow_RightmostArrowOfPaginationInCustomer.click();
		Thread.sleep(8000);
		String page = page_SelectedInPaginationInCustomer.getAttribute("value");
		System.out.println("rightMostPage " + page);
		int rightMostPage = Integer.parseInt(page);
		softAssert.assertEquals(size, rightMostPage, "Right most Arrow Of Pagination Page size not Same");

		// Click on RightArrow
		// Thread.sleep(500);
		highLight(arrow_LeftmostArrowOfPaginationInCustomer);
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		arrow_LeftmostArrowOfPaginationInCustomer.click();
		Thread.sleep(8000);
		String firstPageValue = page_SelectedInPaginationInCustomer.getAttribute("value");
		int firstPage = Integer.parseInt(firstPageValue);
		System.out.println("firstPage" + firstPage);

		highLight(arrow_RightArrowOfPaginationInCustomer);
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		arrow_RightArrowOfPaginationInCustomer.click();
		Thread.sleep(8000);
		String nextPageValue = page_SelectedInPaginationInCustomer.getAttribute("value");
		int nextPage = Integer.parseInt(nextPageValue);
		System.out.println("nextPage" + nextPage);

		int rightArrowPage = firstPage + 1;
		softAssert.assertEquals(nextPage, rightArrowPage, "Right Arrow Of Pagination page size is not same.");

		// Click on LeftArrow
		// Thread.sleep(500);
		String lastPageValue = page_SelectedInPaginationInCustomer.getAttribute("value");
		int lastPage = Integer.parseInt(lastPageValue);
		System.out.println("lastPage" + lastPage);

		highLight(arrow_LeftArrowOfPaginationInCustomer);
		driver.manage().timeouts().pageLoadTimeout(150, TimeUnit.SECONDS);
		arrow_LeftArrowOfPaginationInCustomer.click();
		Thread.sleep(8000);
		String previousPageValue = page_SelectedInPaginationInCustomer
				.getAttribute("value");
		int previousPage = Integer.parseInt(previousPageValue);
		System.out.println("previousPage" + previousPage);

		int leftArrowPage = lastPage - 1;
		softAssert.assertEquals(previousPage, leftArrowPage, "Left Arrow Of Pagination page size is not Same.");
		softAssert.assertAll();

	}
	
	// column headers should display as per selected in My View pop-up of View
		// ticket
		public void displayColumnHeader() throws Exception 
		{
			/*tab_Ticket.click();
			Thread.sleep(1000);
			tab_ViewTicket.click();
			Thread.sleep(1000);
			*/
			SoftAssert softAssert = new SoftAssert();
			// Click on My View Tab
			driver.findElement(
					By.cssSelector("a[class='topLnk'][onclick='fireMyPopup()']"))
					.click();
			// Get list Of Pop up Column
			List<WebElement> listOfPopupColumn = driver.findElements(By
					.cssSelector("#view_property>ul>li"));
			// Get size of Pop up Column
			int sizeOfPopupColumn = listOfPopupColumn.size();
			// Print size of Pop up Column
			System.out.println("Size Of Popup Column: " + sizeOfPopupColumn);
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			// Click on Save Button
			driver.findElement(By.cssSelector("input[onclick='Save()']")).click();
			
			Thread.sleep(2000);
			// Get list Of Table Column
			List<WebElement> listOfTableColumn = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>thead>tr>th"));
			// Get size Of Table Column
			int sizeOfTableColumn = listOfTableColumn.size();
			// Print size Of Table Column
			System.out.println("Total Table Column: " + sizeOfTableColumn);

			for (int i = 1; i < sizeOfPopupColumn; i++) {
				// Click on My View Tab
				driver.findElement(
						By.cssSelector("a[class='topLnk'][onclick='fireMyPopup()']"))
						.click();
				// Get list Of Pop up Column Check box
				List<WebElement> listOfPopupColumnCheckbox = driver.findElements(By
						.cssSelector("#view_property>ul>li>input"));
				// Check Pop up Column Check box is selected or not
				if (!listOfPopupColumnCheckbox.get(0).isSelected()) {
					// Click Pop up Column Check box
					listOfPopupColumnCheckbox.get(0).click();
					Thread.sleep(500);
					// Click Pop up Column Check box
					listOfPopupColumnCheckbox.get(0).click();
				} else {
					// Click Pop up Column Check box
					listOfPopupColumnCheckbox.get(0).click();
				}
				
				
				// Get list Of Pop up Column Check box Name
				List<WebElement> listOfPopupColumnCheckboxName = driver
						.findElements(By.cssSelector("#view_property>ul>li"));
				// Get check box Name
				String checkboxName = listOfPopupColumnCheckboxName.get(i)
						.getText();
				// Print check box Name
				System.out.println("Selected Checkbox:" + checkboxName);

				// Cursor transfer to Check box
		
				highLight(listOfPopupColumnCheckbox.get(i));
				// Click on Check box
				listOfPopupColumnCheckbox.get(i).click();
				driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				// Clickc on Save Button
				driver.findElement(By.cssSelector("input[onclick='Save()']"))
						.click();
				Thread.sleep(2000);
				// Get list Of Table Column Name
				List<WebElement> listOfTableColumnName = driver
						.findElements(By
								.cssSelector("table[class='fht-table fht-table-init']>thead>tr>th"));
				// Get Table Column Name
				String tableColumnName = listOfTableColumnName.get(1).getText();
				// Print Table Column Name
				System.out.println("Display Table Column Name: " + tableColumnName);
				// Check check box Name
				if (checkboxName.equalsIgnoreCase(tableColumnName)) {
					// Print Message
					System.out.println("Column is Match\n");
					// Verify check box Name
					softAssert.assertTrue(
							checkboxName.equalsIgnoreCase(tableColumnName),
							"Column is not Match");
				} else {
					// Print Message
					System.out.println("Column is not Match\n");
					// Verify check box Name
					softAssert.assertEquals(checkboxName, tableColumnName,
							"Column is not Match");

				}

				Thread.sleep(2000);
			}
			
			softAssert.assertAll();

		}
		
		// Pagination //
		// Count Of Pagination
		public void countOfPagination() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			int size = dropdown_PaginationInCustomer.size();
			System.out.println("Pagination Pages: "+size);
			/*int count = 0;
			for (int i = 0; i < size; i++) {
				System.out.println("Page No.: "+ i);
				dropdown_Pagination.get(i).click();
				Thread.sleep(1000);
				int rowSize = list_RowInTable.size();
				System.out.println("Row Count: "+rowSize);
				count = count + rowSize;
				System.out.println("Total Count: "+count);
				
			}*/
			
			int count=20*(size-1);
			dropdown_PaginationInCustomer.get(size-1).click();
			Thread.sleep(1000);
			int lastPageCount = list_RowInTable.size();
			System.out.println("last Page Count: "+lastPageCount);
			int totalCountTicket = count + lastPageCount;
			System.out.println("Total Count: "+totalCountTicket);
			
			String textOfTotalCount= lblcountInCustomer.getText();
			String totalCount  = textOfTotalCount.split("Total Ticket Count: ")[1];
			int actualTotalCount = Integer.parseInt(totalCount);
			System.out.println("number of Total Ticket: "+actualTotalCount);
			softAssert.assertEquals(totalCountTicket,actualTotalCount,"Count is not match");
			Thread.sleep(2000);
			softAssert.assertAll();
		}


		// Display Title Of View Ticket Page
		public void displayTitleOfViewTicketPage() {
			SoftAssert softAssert = new SoftAssert();
			String viewTicketPageTitle = driver.getTitle();
			System.out.println(viewTicketPageTitle);
			softAssert.assertEquals(viewTicketPageTitle, "Welcome To Uno Point");
			softAssert.assertAll();

		}
		
		// Descending order of Incident ID's
		public void displayDescendingOrderOfIncidentID() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Get the size of Row
			Integer countOfRow = lstRowInTable.size();
			System.out.println("countOfRow: "+countOfRow);

			for (int i = 0; i < countOfRow - 1; i++) {
				// Get the list Of ID
				scrollDown(lstIDInTableInCustomer.get(i));
				highLight(lstIDInTableInCustomer.get(i));
				// Get the First ID
				String textOfFirstID = lstIDInTableInCustomer.get(i).getText();
				// Convert into integer
				int firstID = Integer.parseInt(textOfFirstID);
				System.out.println("firstID: "+firstID);
				// Get the Second ID
				highLight(lstIDInTableInCustomer.get(i+1));
				String textOfSecondID = lstIDInTableInCustomer.get(i + 1).getText();
				// Convert into integer
				int secondID = Integer.parseInt(textOfSecondID);
				System.out.println("secondID: "+secondID);

				boolean idIsPresent = true;
				
					// Compare firstID and secondID
					if (firstID > secondID) {
						// Print the Result
						System.out.println("Pass");
						idIsPresent = true;
					}
					else
					{
						System.out.println("Fail");
						idIsPresent = false;
					}

				
				softAssert.assertTrue(idIsPresent, "ID is not Descending Order");
			}
			softAssert.assertAll();

		}
		
		// Hyper link of ID should have present
		public void checkHyperlinkOfID() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Get the size of Row
			Integer countOfRow = lstRowInTable.size();
			for (int i = 0; i < countOfRow; i++) {
				// Get list Of ID
				scrollDown(lstIDInTable.get(i));
				highLight(lstIDInTable.get(i));
				// Get ID
				String ID = lstIDInTable.get(i).getText();
				// print ID
				System.out.println("ID: " + ID);
				// Check id is Present or not
				boolean idIsPresent = driver.findElement(By.linkText(ID))
						.isDisplayed();
				// Print Result
				System.out.println("Hyperlink of ID	present: " + idIsPresent);
				// Verify ID is Present or not
				softAssert
						.assertTrue(idIsPresent, "Hyperlink of ID is not present");

			}
			softAssert.assertAll();
		}

		// Hyper link of Customer should have present
		public void checkHyperlinkOfCustomer() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			// Get Size of Row
			Integer countOfRow = lstRowInTable.size();
			for (int i = 0; i < countOfRow; i++) {
				// Get list Of Customer
				scrollDown(lstCustomerInTable.get(i));
				highLight(lstCustomerInTable.get(i));
				// Get Customer
				String customer = lstCustomerInTable.get(i).getText();
				// Print Customer
				System.out.println("Customer: " + customer);
				// Check customer is Present or not
				boolean customerIsPresent = driver.findElement(
						By.linkText(customer)).isDisplayed();
				// Print result
				System.out.println("Hyperlink of Customer present: "
						+ customerIsPresent);
				// Verify customer is Present or not
				softAssert.assertTrue(customerIsPresent,
						"Hyperlink of Customer is not present");

			}
			softAssert.assertAll();
		}
		
		// Hyper link of Asset Id should have present
		public void checkHyperlinkOfAssetId() throws Throwable {
			SoftAssert softAssert = new SoftAssert();
			
			// Get list of
			Integer countOfRow = lstRowInTable.size();
			for (int i = 0; i < countOfRow; i++) {
				// Get list Of Asset Id
				scrollDown(lstAssetIdInTable.get(i));
				
				highLight(lstAssetIdInTable.get(i));
				// Get Assert Id
				String assertId = lstAssetIdInTable.get(i).getText();
				// Print Assert Id
				System.out.println("Assert Id: " + assertId);
				// Check Assert Id is Present or not
				boolean assetIdIsPresent = driver
						.findElement(By.linkText(assertId)).isDisplayed();
				// Print result
				System.out.println("Hyperlink of Asset Id present: "
						+ assetIdIsPresent);
				// Verify Assert Id is Present or not
				softAssert.assertTrue(assetIdIsPresent,
						"Hyperlink of Asset Id is not present");

			}
			softAssert.assertAll();
		}

		// Blinking Notification
		public void checkBlinkingNotification() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			List<WebElement> listOfRow = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span"));
			Integer countOfRow = listOfRow.size();
			int j = 0;
			for (int i = 0; i < countOfRow; i++) {
				scrollDown(lstIDInTable.get(i));
				highLight(lstIDInTable.get(i));
				String id = listOfRow.get(i).getText();
				System.out.println(id);
				Integer count = id.length();
				System.out.println("count: "+count);
				if (count != 4) {
					j = j + 1;

					String notification = driver
							.findElements(
									By.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(1)>span>i"))
							.get(j - 1).getText();
					System.out.println("Blinking Notification: " + notification);

					switch (notification) {
					case "ETA":
						scrollDown(lstEngineerInTable.get(i));
						highLight(lstEngineerInTable.get(i));
						String engineer = lstEngineerInTable.get(i).getText();
						System.out.println("Engineer: " + engineer);
						softAssert.assertNotNull(engineer, "Technicion not Assign");
						System.out.println("Engineer Assign\n");

						break;

					case "ATA":
						scrollDown(lstETADateInTable.get(i));
						highLight(lstETADateInTable.get(i));
						String eta = lstETADateInTable.get(i).getText();
						System.out.println("ETA: " + eta);
						softAssert.assertNotNull(eta, "ETA is not Present");
						System.out.println("Punch the ETA\n");

						break;

					case "Feedback":
						scrollDown(lstATADateInTable.get(i));
						highLight(lstATADateInTable.get(i));
						String ata = lstATADateInTable.get(i).getText();
						System.out.println("ATA: " + ata);
						softAssert.assertNotNull(ata, "ATA is not Present");
						System.out.println("Punch the ATA\n");

						break;

					case "Spare Requested":

						System.out.println("Spare Requested\n");

						break;

					default:
						System.out.println("wrong");
						break;
					}

				}

				else {
					System.out.println("There is not Blinking Notification\n");
				}
			}
			softAssert.assertAll();
		}
		

		// Match Customer in Incident History Page
		public void checkCustomer() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			boolean customerIsMatch = true;
			List<WebElement> listOfRowInParentWindow = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
			Integer countOfRowInParentWindow = listOfRowInParentWindow.size();

			for (int i = 0; i < countOfRowInParentWindow; ) {
				List<WebElement> listOfCustomerInParentWindow = driver
						.findElements(By
								.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(5)>a"));
				String customerInParentWindow = listOfCustomerInParentWindow.get(i)
						.getText();
				System.out.println("customerInParentWindow: "
						+ customerInParentWindow);
				WebElement element = driver.findElement(By
						.linkText(customerInParentWindow));
				
				highLight(element);
				// Thread.sleep(1000);
				driver.findElement(By.linkText(customerInParentWindow)).click();
				String parentWindow = driver.getWindowHandle();

				for (String childWindow : driver.getWindowHandles()) {
					driver.switchTo().window(childWindow);
				}

				String customer = driver
						.findElement(
								By.cssSelector("div[id='headingText']>table>tbody>tr>td>span>b"))
						.getText();
				String customerInChildWindow = customer.split(":-  ")[1];
				System.out.println("customerInChildWindow: "
						+ customerInChildWindow);

				if (customerInParentWindow.equalsIgnoreCase(customerInChildWindow)) {
					System.out.println("Customer name are same.\n");
					customerIsMatch = true;

				} else {
					System.out.println("Customer name are not same.\n");
					customerIsMatch = false;
				}

				softAssert.assertTrue(customerIsMatch,
						"Customer name are not same.");

				List<WebElement> listOfRowInChildWindow = driver
						.findElements(By
								.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
				Integer countOfRowInChildWindow = listOfRowInChildWindow.size();

				for (int j = 0; j < countOfRowInChildWindow; j++) {
					List<WebElement> listOfCustomerInChildWindowTable = driver
							.findElements(By
									.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(3)>a"));
					String customerInChildWindowTable = listOfCustomerInChildWindowTable
							.get(j).getText();
					System.out.println("Customer: " + customerInChildWindowTable);

					if (customerInParentWindow
							.equalsIgnoreCase(customerInChildWindowTable)) {
						System.out.println("Customer name are same.\n");
						customerIsMatch = true;
						break;

					} else {
						System.out.println("Customer name are not same.\n");
						customerIsMatch = false;

					}

					softAssert.assertTrue(customerIsMatch,
							"Customer name are not same.");

				}

				// Closing Pop Up window
				driver.close();
				driver.switchTo().window(parentWindow);
				break;
			}
			softAssert.assertAll();

		}
		

		// Match Asset ID in Incident History
		public void checkAssetID() throws Exception {
			SoftAssert softAssert = new SoftAssert();
			boolean assetIdIsMatch = true;
			List<WebElement> listOfRowInParentWindow = driver
					.findElements(By
							.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
			Integer countOfRowInParentWindow = listOfRowInParentWindow.size();

			for (int i = 0; i < countOfRowInParentWindow; ) {
				List<WebElement> listOfAssetIdInParentWindow = driver
						.findElements(By
								.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(7)>a"));
				String assetIdInParentWindow = listOfAssetIdInParentWindow.get(i)
						.getText();
				System.out.println("Asset ID: " + assetIdInParentWindow);

				WebElement element = driver.findElement(By
						.linkText(assetIdInParentWindow));
				scrollDown(element);
				highLight(element);
				// Thread.sleep(1000);
				driver.findElement(By.linkText(assetIdInParentWindow)).click();

				String parentWindow = driver.getWindowHandle();

				for (String childWindow : driver.getWindowHandles()) {
					driver.switchTo().window(childWindow);
				}

				String assetId = driver
						.findElement(
								By.cssSelector("div[id='headingText']>table>tbody>tr>td>span>b"))
						.getText();
				String assetIDInChildWindow = assetId.split(":-  ")[1];
				System.out.println("Asset ID In Child Window: "
						+ assetIDInChildWindow);

				if (assetIdInParentWindow.equalsIgnoreCase(assetIDInChildWindow)) {
					System.out.println("Asset ID are same.\n");
					assetIdIsMatch = true;
				} else {
					System.out.println("Asset ID are not same.\n");
					assetIdIsMatch = false;
				}

				softAssert.assertTrue(assetIdIsMatch, "Asset ID  are not same.");

				List<WebElement> listOfRowInChildWindow = driver
						.findElements(By
								.cssSelector("table[class='fht-table fht-table-init']>tbody>tr"));
				Integer countOfRowInChildWindow = listOfRowInChildWindow.size();

				for (int j = 0; j < countOfRowInChildWindow; j++) {
					List<WebElement> listOfAssetIdInChildWindowTable = driver
							.findElements(By
									.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(4)>a"));
					String assetIdInChildWindowTable = listOfAssetIdInChildWindowTable
							.get(j).getText();
					System.out.println("AssetID In Child Window Table: "
							+ assetIdInChildWindowTable);

					if (assetIdInParentWindow
							.equalsIgnoreCase(assetIdInChildWindowTable)) {
						System.out.println("Asset ID are same.\n");
						assetIdIsMatch = true;
						break;

					} else {
						System.out.println("Asset ID are not same.\n");
						assetIdIsMatch = false;
					}

					softAssert
							.assertTrue(assetIdIsMatch, "Asset ID  are not same.");

				}

				// Closing Pop Up window
				driver.close();
				driver.switchTo().window(parentWindow);
				break;
			}
			softAssert.assertAll();

		}
		
		// Display Hidden Message of Flag For Address
		public void checkHiddenMessageOfAddress() throws Exception {
			SoftAssert softAssert = new SoftAssert();

			
			Integer countOfRow = lstRowInTable.size();

			for (int i = 0; i < countOfRow; i++) {
				List<WebElement> listOfFlag = driver
						.findElements(By
								.cssSelector("table[class='fht-table fht-table-init']>tbody>tr>td:nth-of-type(12)>img"));
				String flag = listOfFlag.get(i).getAttribute("alt");
				System.out.println("Flag:" + flag);

				if (flag.equalsIgnoreCase("green")) {
					String flagMassage = listOfFlag.get(i).getAttribute("title");
					System.out.println("Flag Massage:" + flagMassage);

					softAssert.assertEquals(flagMassage, "Correct Address",
							"Hidden massage is not Correct");

					System.out.println("Correct Address");
				} else if (flag.equalsIgnoreCase("Violated")) {
					String flagMassage = listOfFlag.get(i).getAttribute("title");
					System.out.println("Flag Massage:" + flagMassage);

					softAssert.assertEquals(flagMassage, "Incorrect Address",
							"Hidden massage is not Correct");

					System.out.println("Incorrect Address");
				}

			}
			softAssert.assertAll();
		}


}