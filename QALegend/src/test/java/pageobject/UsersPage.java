package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UsersPage {
	WebDriver driver;
	public UsersPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="//a[@class='btn btn-block btn-primary']")
	WebElement add_button;
	@FindBy(xpath="//input[@class='form-control input-sm']")
	WebElement search_field;
	@FindBy(xpath="(//td)[4]")
	WebElement searchresult;
	public AddUserPage clickOnAddButton()
	{
		add_button.click();
		return new AddUserPage(driver);
	}
	public void enterDataInSearchField(String email)
	{
		search_field.sendKeys(email);
	}
	public String getSearchResultText()
	{
		String expectedemail=searchresult.getText();
		return expectedemail;
		
	}

}
