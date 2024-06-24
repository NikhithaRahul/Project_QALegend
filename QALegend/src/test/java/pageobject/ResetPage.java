package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPage {
	WebDriver driver;
	public ResetPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(id="email")
	WebElement emailaddress;
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement passwordresetlink;
	@FindBy(xpath="//strong[text()='The email must be a valid email address.']")
	WebElement errormsg;
	@FindBy(xpath="//div[@class='alert alert-success']")
	WebElement alertmessage;
			
	public String resetPageTitle() 
	{
		String resetpagetitle=driver.getTitle();
		System.out.println(resetpagetitle);
		return resetpagetitle;
	}
	public void enterEmailAddress(String email)
	{
		emailaddress.sendKeys(email);
	}
	public void clickOnPasswordResetLink()
	{
		passwordresetlink.click();
	}

	public String invalidEmailErrorMessage()
	{
		String errormessage=errormsg.getText();
		System.out.println(errormessage);
		return errormessage;
	}
	public String validEmailAlertMessage()
	{
		String alertmsg=alertmessage.getText();
		System.out.println(alertmsg);
		return alertmsg;
	}

}
