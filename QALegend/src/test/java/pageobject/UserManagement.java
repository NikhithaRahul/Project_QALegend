package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;

public class UserManagement {
	WebDriver driver;
	public UserManagement(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='User Management']")
	WebElement user_management;
	@FindBy(xpath="(//span)[8]")
	WebElement users;
	@FindBy(xpath="(//span)[9]")
	WebElement roles;
	@FindBy(xpath="(//span)[10]")
	WebElement sales_commission_agent;
	
	public boolean checkElementEnabled()
	{
		boolean status=PageUtility.verifyUserManagementisEnabled(user_management);
		return status;
	}
	public void checkUserFieldEnabled()
	{
		PageUtility.verifyUsersfieldisEnabled(users);
		
	}
	public void checkRolesFieldEnabled()
	{
		PageUtility.verifyUsersfieldisEnabled(roles);
		
	}

}
