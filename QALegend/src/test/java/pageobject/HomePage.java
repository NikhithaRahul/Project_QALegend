package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import automation_core.Base;
import constant.Constants;
import utilities.DateUtility;
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
	WebElement profile;
	@FindBy(xpath="//span[text()='User Management']")
	WebElement user_management;
	@FindBy(xpath="(//span)[8]")
	WebElement users;
	@FindBy(xpath="(//span)[5]")
	WebElement home_tab;
	@FindBy(xpath="//a[text()='Sign Out']")
	WebElement sign_out;
	@FindBy(xpath="//div[@class='m-8 pull-left mt-15 hidden-xs']")
	WebElement logindate;
	
	public String getUserNameTextDisplay()
	{
		String usernametext=usernamedisplay.getText();
		return usernametext;
	}
	public void clickOnEndTourButton()
	{
		endtourbutton.click();
	}
	public ProfilePage clickOnProfileTab()
	{
		profile.click();
		return new ProfilePage(driver);
	}
	
	public String getUserNameText()
	{
		String username_text=profile.getText();
		return username_text;
	}
	public UserManagement clickOnUserManagement()
	{
		user_management.click();
		return new UserManagement(driver);
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
	public String getLoginDate()
	{
		String login_date=logindate.getText();
		return login_date;
	}
	public String getCurrentDate()
	{
		return DateUtility.getUserLoginDate(Constants.DATE_FORMAT);
	}

}
