package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonPackage.commonFunctions;
import pageObjects.dashBoardPageObjects;
import pageObjects.loginPageObjects;


public class pendingLeaveRequest extends commonFunctions
{
	
	String dashboardText;
	static Logger logger = Logger.getLogger(pendingLeaveRequest.class);
	public void login()
	{
		logger.info("Logging in to the Application");
		PageFactory.initElements(driver, loginPageObjects.class);
		loginPageObjects.userName.sendKeys(properties.getProperty("username"));
		loginPageObjects.password.sendKeys(properties.getProperty("password"));
		
		loginPageObjects.submitButton.click();
				
	}
	
	public void getPendingLeaveRequest()
	{
		
		PageFactory.initElements(driver,dashBoardPageObjects.class);		 
		dashboardText = dashBoardPageObjects.dashBoard.getText();		
		//PageFactory.initElements(null, dashboardText);
	}
	
	@Test
	public void verifyPendingLeaveRequests()
	{		
		login();
		logger.info("Getting the Pending Leave Request");
		getPendingLeaveRequest();
		logger.info("Verification");
		Assert.assertEquals(dashboardText,"No Records are Available");		
		logger.info("End of Verify Pending Leave Request test case");
		//System.out.println(dashboardText);
	}
}
