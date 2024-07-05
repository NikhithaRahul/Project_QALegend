package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="username")
	WebElement usernamefield;
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordfield;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement loginbutton;
	@FindBy(xpath="//strong[text()='These credentials do not match our records.']")
	WebElement errormessage;
	@FindBy(xpath="//a[@class='btn btn-link']")
	WebElement forgotyourpassword;
	
	public void enterUserName(String username)
	{
		usernamefield.sendKeys(username);
	}
	public void enterPassWord(String password)
	{
		passwordfield.sendKeys(password);
	}
	public HomePage clickOnLoginButton()
	 {
		 loginbutton.click();
		 return new HomePage(driver);
		 
	 }
	public String invalidLoginErrorMessage()
	{
		String errormsg=errormessage.getText();
		return errormsg;
	}
	public String homePageTitle()
	{
		String homepagetitle=driver.getTitle();
		
		return homepagetitle;
	}
	public ResetPage clickOnforgotPassword()
	{
		forgotyourpassword.click();
		return new ResetPage(driver);
	}
	

}
