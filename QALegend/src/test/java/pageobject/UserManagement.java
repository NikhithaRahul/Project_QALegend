package pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.PageUtility;
import utilities.WaitUtility;
import utilities.WebElementUtility;

public class UserManagement {
	WebDriver driver;
	public UserManagement(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//span[text()='User Management']")
	WebElement usermngmnt;
	@FindBy(xpath="(//span)[8]")
	WebElement users;
	@FindBy(xpath="(//span)[9]")
	WebElement roles;
	@FindBy(xpath="(//span)[10]")
	WebElement sales_commission_agent;
	
	public boolean isUserFieldEnabled()
	{
		WaitUtility.waitForElementToBeVisible(driver, users);
		return WebElementUtility.isElementEnabled(users);
		
	}
	public boolean isRolesFieldEnabled()
	{
		WaitUtility.waitForElement(driver, roles);
		return WebElementUtility.isElementEnabled(roles);
		
	}
	public boolean isSalesCommisionAgentFieldEnabled()
	{
		WaitUtility.waitForElementToBeVisible(driver, sales_commission_agent);
		return WebElementUtility.isElementEnabled(sales_commission_agent);
		
	}
	

}
