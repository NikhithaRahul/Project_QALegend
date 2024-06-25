package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation_core.Base;
import utilities.WaitUtility;

public class HomePage {
	WebDriver driver;
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//button[@class='btn btn-default btn-sm']")
	WebElement endtourbutton;
	@FindBy(xpath="(//h1)")
	WebElement usernamedisplay;
	@FindBy(xpath="(//span)[4]")
	WebElement xyztab;
	@FindBy(xpath="//span[text()='User Management']")
	WebElement user_management;
	@FindBy(xpath="(//span)[8]")
	WebElement users;
	@FindBy(xpath="(//span)[5]")
	WebElement home_tab;
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement sign_out;
	
	
	public String getUserNameTextDisplay()
	{
		String usernametext=usernamedisplay.getText();
		return usernametext;
	}
	public void clickOnEndTourButton()
	{
		endtourbutton.click();
	}
	public void clickOnXyzTab()
	{
		xyztab.click();
	}
	
	public String getUserNameText()
	{
		String username_text=xyztab.getText();
		System.out.println(username_text);
		return username_text;
	}
	public void clickOnUserManagement()
	{
		user_management.click();
	}
	public UsersPage clickOnUsers()
	{
		users.click();
		WaitUtility.waitForElement(driver, users);
		return new UsersPage(driver);
	}
	public void clickOnHomeTab()
	{
		home_tab.click();
	}
	public void clickOnSignOut()
	{
		sign_out.click();
	}

}
