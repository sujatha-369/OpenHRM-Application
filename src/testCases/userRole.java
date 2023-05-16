package testCases;

import org.apache.log4j.Logger;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import commonPackage.commonFunctions; 
import pageObjects.userRolePageObjects;

public class userRole extends commonFunctions
{
	static Logger logger = Logger.getLogger(userRole.class);

	public void moveToUsers() throws InterruptedException 
	{
		Actions actions = new Actions(driver);
		actions.moveToElement(userRolePageObjects.adminLink);
		Thread.sleep(2000);
	
		//actions.moveToElement(userRolePageObjects.userManagementLink);
		//actions.moveToElement(userRolePageObjects.usersLink);
		actions.click().build().perform();			
	}
	
	public void selectUserRole()
	{
		Select selectRole = new Select(userRolePageObjects.userRole);
		selectRole.selectByIndex(1);
	}
	
	public void selectUserStatus()
	{
		Select selectStatus = new Select(userRolePageObjects.userStatus);
		selectStatus.selectByIndex(1);
	}
	
	@Test
	public void checkUserRole() throws InterruptedException 
	{
		PageFactory.initElements(driver, userRolePageObjects.class);
		logger.info("Navigating the User Page");
		moveToUsers();
		logger.info("Selecting the User Role");
		selectUserRole();
		Thread.sleep(2000);
		logger.info("Selecting the User Status");
		selectUserStatus();	
		
		Thread.sleep(2000);
		
		userRolePageObjects.searchButton.click();
		
		
		String actualUserRole = userRolePageObjects.userRoleValue.getText();
		String actualUserStatus = userRolePageObjects.userStatusValue.getText();
	
		logger.info("Verifying the results");
		 Assert.assertEquals(actualUserRole, "Admin");
		 Assert.assertEquals(actualUserStatus, "Enabled");
		 
		
	}
}
