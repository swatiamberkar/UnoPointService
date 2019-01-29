package com.uno.pages.customer;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;







import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.uno.baseClass.BaseCode;

public class Customer_TicketSummaryPages extends BaseCode {

	// Initializing Page Object
	public Customer_TicketSummaryPages() {
		PageFactory.initElements(driver, this);
	}


	// Total Count of Requests Open Tab
	public void verifyTotalCountAndStatusOfRequestsOpenTab() throws Exception {
		SoftAssert softAssert = new SoftAssert();

		highLight(tabRequestsOpenInTicketSummary);
		Thread.sleep(500);
		highLight(lblCountOfRequestOpenTab);

		String textOfCount = lblCountOfRequestOpenTab.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("Number of Request open " + count);

		Thread.sleep(500);
		tabRequestsOpenInTicketSummary.click();

		scrollDown(lblTicketCountInTicketTableInCustomer);
		Thread.sleep(500);
		highLight(lblTicketCountInTicketTableInCustomer);
		String textOfTotalCount = lblTicketCountInTicketTableInCustomer.getText();
		System.out.println("textOfTotalCount: "+textOfTotalCount);
		String totalCount = textOfTotalCount.split("Total Ticket Count: ")[1];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("Number of Total Ticket: " + actualTotalCount);

		softAssert.assertEquals(count, actualTotalCount, "Count is not match");
		
		List<WebElement> listOfRows = lstRowInTicketTable;
		Integer countOfRows = listOfRows.size();
		for (int i = 0; i < countOfRows; i++) {
			List<WebElement> listOfStatus = lstStatusInTicketTableInCustomer;
			scrollDown(lstStatusInTicketTableInCustomer.get(i));
			highLight(lstStatusInTicketTableInCustomer.get(i));
			String status = listOfStatus.get(i).getText();
			System.out.println("Status of Request Open: " + status);
			softAssert.assertEquals(status, "Open", "Status is not Same");

		}

		softAssert.assertAll();

	}

	
	// Total Count of Requests Paused Tab
	public void totalCountAndStatusOfRequestsPausedTab() throws Exception {
		
	
		SoftAssert softAssert = new SoftAssert();

		highLight(tabRequestsPauseInTicketSummary);
		Thread.sleep(500);
		highLight(lblCountOfRequestPauseTab);
		String textOfCount = lblCountOfRequestPauseTab
				.getText();
		int count = Integer.parseInt(textOfCount);
		System.out.println("number of Request " + count);

		tabRequestsPauseInTicketSummary
				.click();
		
		scrollDown(lblTicketCountInTicketTableInCustomer);
		Thread.sleep(500);
		highLight(lblTicketCountInTicketTableInCustomer);
		String textOfTotalCount =lblTicketCountInTicketTableInCustomer.getText();
		String totalCount = textOfTotalCount.split("Total Ticket Count: ")[1];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		softAssert.assertEquals(count, actualTotalCount, "Count is not match");
		
		Integer countOfRows = lstRowInTable.size();
		// System.out.println("number of Request open "+totalRows);
		for (int i = 0; i < countOfRows; i++) {
			scrollDown(lstStatusInTicketTableInCustomer.get(i));
			highLight(lstStatusInTicketTableInCustomer.get(i));
			String status = lstStatusInTicketTableInCustomer.get(i).getText();
			softAssert.assertEquals("Paused", status);
			System.out.println(status);

		}
		softAssert.assertAll();
	}

	
	// Total Count of Requests Paused Tab
		public void totalCountAndStatusOfRequestsCancelTab() throws Exception {
			
		
			SoftAssert softAssert = new SoftAssert();

			highLight(tabRequestsCancelInTicketSummary);
			Thread.sleep(500);
			highLight(lblCountOfRequestCancelTab);
			String textOfCount = lblCountOfRequestCancelTab
					.getText();
			int count = Integer.parseInt(textOfCount);
			System.out.println("number of Request " + count);

			tabRequestsCancelInTicketSummary
					.click();
			
			scrollDown(lblTicketCountInTicketTableInCustomer);
			Thread.sleep(500);
			highLight(lblTicketCountInTicketTableInCustomer);
			String textOfTotalCount =lblTicketCountInTicketTableInCustomer.getText();
			String totalCount = textOfTotalCount.split("Total Ticket Count: ")[1];
			int actualTotalCount = Integer.parseInt(totalCount);
			System.out.println("number of Total Ticket: " + actualTotalCount);
			softAssert.assertEquals(count, actualTotalCount, "Count is not match");
			
			Integer countOfRows = lstRowInTable.size();
			// System.out.println("number of Request open "+totalRows);
			for (int i = 0; i < countOfRows; i++) {
				scrollDown(lstStatusInTicketTableInCustomer.get(i));
				highLight(lstStatusInTicketTableInCustomer.get(i));
				String status = lstStatusInTicketTableInCustomer.get(i).getText();
				softAssert.assertEquals("Cancelled", status);
				System.out.println(status);

			}
			softAssert.assertAll();
		}
		
		// Total Count of Requests Paused Tab
				public void totalCountAndStatusOfRequestsClosedTab() throws Exception {
					
				
					SoftAssert softAssert = new SoftAssert();

					highLight(tabRequestsCloseInTicketSummary);
					Thread.sleep(500);
					highLight(lblCountOfRequestCloseTab);
					String textOfCount = lblCountOfRequestCloseTab
							.getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request " + count);

					tabRequestsCloseInTicketSummary
							.click();
					
					scrollDown(lblTicketCountInTicketTableInCustomer);
					Thread.sleep(500);
					highLight(lblTicketCountInTicketTableInCustomer);
					String textOfTotalCount =lblTicketCountInTicketTableInCustomer.getText();
					String totalCount = textOfTotalCount.split("Total Ticket Count: ")[1];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: " + actualTotalCount);
					softAssert.assertEquals(count, actualTotalCount, "Count is not match");
					
					Integer countOfRows = lstRowInTable.size();
					// System.out.println("number of Request open "+totalRows);
					for (int i = 0; i < countOfRows; i++) {
						scrollDown(lstStatusInTicketTableInCustomer.get(i));
						highLight(lstStatusInTicketTableInCustomer.get(i));
						String status = lstStatusInTicketTableInCustomer.get(i).getText();
						softAssert.assertEquals("Closed", status);
						System.out.println(status);

					}
					softAssert.assertAll();
				}
				
				// Total Count of Requests Paused Tab
				public void totalCountAndStatusOfRequestsClosedByTechnicianTab() throws Exception {
					
				
					SoftAssert softAssert = new SoftAssert();

					highLight(tabRequestsClosedByTechnicianInTicketSummary);
					Thread.sleep(500);
					highLight(lblCountOfRequestClosedByTechnicianTab);
					String textOfCount = lblCountOfRequestClosedByTechnicianTab
							.getText();
					int count = Integer.parseInt(textOfCount);
					System.out.println("number of Request " + count);

					tabRequestsClosedByTechnicianInTicketSummary
							.click();
					
					scrollDown(lblTicketCountInTicketTableInCustomer);
					Thread.sleep(500);
					highLight(lblTicketCountInTicketTableInCustomer);
					String textOfTotalCount =lblTicketCountInTicketTableInCustomer.getText();
					String totalCount = textOfTotalCount.split("Total Ticket Count: ")[1];
					int actualTotalCount = Integer.parseInt(totalCount);
					System.out.println("number of Total Ticket: " + actualTotalCount);
					softAssert.assertEquals(count, actualTotalCount, "Count is not match");
					
					Integer countOfRows = lstRowInTable.size();
					// System.out.println("number of Request open "+totalRows);
					for (int i = 0; i < countOfRows; i++) {
						scrollDown(lstStatusInTicketTableInCustomer.get(i));
						highLight(lstStatusInTicketTableInCustomer.get(i));
						String status = lstStatusInTicketTableInCustomer.get(i).getText();
						softAssert.assertEquals("TechClosed", status);
						System.out.println(status);

					}
					softAssert.assertAll();
				}
	
	
	// Total Count of All Requests Tab
	public void totalCountOfAllRequestsTab() throws Exception // textOfCount count
												// textOfTotalCount totalCount
												// actualTotalCount
	{
		SoftAssert softAssert = new SoftAssert();

		highLight(lblCountOfRequestOpenTab);

		String textOfCountOfRequestOpen = lblCountOfRequestOpenTab.getText();
		int requestOpen = Integer.parseInt(textOfCountOfRequestOpen);
		System.out.println("Number of Request open " + requestOpen);
		
		highLight(lblCountOfRequestPauseTab);
		String textOfCountOfRequestPause = lblCountOfRequestPauseTab
				.getText();
		int requestPause = Integer.parseInt(textOfCountOfRequestPause);
		System.out.println("number of Request " + requestPause);
		
		highLight(lblCountOfRequestCancelTab);
		String textOfCountOfRequestCancel = lblCountOfRequestCancelTab
				.getText();
		int requestCancel = Integer.parseInt(textOfCountOfRequestCancel);
		System.out.println("number of Request " + requestCancel);
		
		highLight(lblCountOfRequestCloseTab);
		String textOfCountOfRequestClose = lblCountOfRequestCloseTab
				.getText();
		int requestClose = Integer.parseInt(textOfCountOfRequestClose);
		System.out.println("number of Request " + requestClose);
		
		highLight(lblCountOfRequestClosedByTechnicianTab);
		String textOfCountOfRequestClosedByTechnician = lblCountOfRequestClosedByTechnicianTab
				.getText();
		int requestClosedByTechnician = Integer.parseInt(textOfCountOfRequestClosedByTechnician);
		System.out.println("number of Request " + requestClosedByTechnician);
		
		
		int allCount = requestOpen+requestPause+requestCancel+requestClose+requestClosedByTechnician;
		System.out.println("allCount: "+allCount);
		
	
		highLight(lblCountOfAllRequestTab);
		String textOfCount = lblCountOfAllRequestTab
				.getText();
		int allRequest = Integer.parseInt(textOfCount);
		System.out.println("number of Request " + allRequest);
		
		softAssert.assertEquals(allRequest, allCount, "Count is not match");
		
		highLight(tabAllRequestsInTicketSummary);
		Thread.sleep(500);
		
		tabAllRequestsInTicketSummary
				.click();
		
		scrollDown(lblTicketCountInTicketTableInCustomer);
		Thread.sleep(500);
		highLight(lblTicketCountInTicketTableInCustomer);
		String textOfTotalCount =lblTicketCountInTicketTableInCustomer.getText();
		String totalCount = textOfTotalCount.split("Total Ticket Count: ")[1];
		int actualTotalCount = Integer.parseInt(totalCount);
		System.out.println("number of Total Ticket: " + actualTotalCount);
		softAssert.assertEquals(allRequest, actualTotalCount, "Count is not match");
		softAssert.assertAll();
		
		
		
		
		

	}

	

}

