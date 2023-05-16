package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class userRolePageObjects
{

	@FindBy(linkText = "Admin")
	public static WebElement adminLink;
	
	//@FindBy(linkText = "User Management")
	//public static WebElement userManagementLink;
	
	@FindBy(linkText = "Users")
	public static WebElement usersLink;

	@FindBy(id = "searchSystemUser_userType")
	public static WebElement userRole;
	
	@FindBy(id ="searchSystemUser_status" )
	public static WebElement userStatus;
	
	
	@FindBy(id = "searchBtn")
	public static WebElement searchButton;
	
	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[1]/td[2]")
	public static WebElement userName;
	
	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[1]/td[3]")
	public static WebElement userRoleValue;
	
	@FindBy(xpath = "//*[@id=\"resultTable\"]/tbody/tr[1]/td[5]")
	public static WebElement userStatusValue;
	
	
			
}
