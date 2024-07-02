package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

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
	@FindBy(xpath="//a[@class='btn btn-xs btn-primary']")
	WebElement editbutton;
	@FindBy(id="submit_user_button")
	WebElement update;
	@FindBy(xpath="(//td)[3]")
	WebElement rolefield;
	@FindBy(xpath="(//a)[95]")
	WebElement viewbutton;
	@FindBy(xpath="//h3[@class='profile-username']")
	WebElement profile_username;
	@FindBy(xpath="//button[@class='btn btn-xs btn-danger delete_user_button']")
	WebElement deletebutton;
	@FindBy(xpath="//button[@class='swal-button swal-button--confirm swal-button--danger']")
	WebElement deletepopup_okbutton;
	@FindBy(xpath="//td[@class='dataTables_empty']")
	WebElement afterdelet_searchresult;
	public AddUserPage clickOnAddButton()
	{
		add_button.click();
		return new AddUserPage(driver);
	}
	public void enterDataInSearchField(String searchdata)
	{
		
		search_field.sendKeys(searchdata);
	}
	public String getSearchResultText()
	{
		WaitUtility.waitForElement(driver, searchresult);
		String expectedemail=searchresult.getText();
		System.out.println(expectedemail);
		return expectedemail;
		
	}
	public AddUserPage clickOnEditButton()
	{
		editbutton.click();
		return new AddUserPage(driver);
	}
	public void clickOnUpdateButton()
	{
		update.click();
	}
	public void clickOnViewButton()
	{
		viewbutton.click();
	}
	public void clickOnDeleteButton()
	{
		deletebutton.click();
	}
	public String getRoleAfterSearch()
	{
		WaitUtility.waitForElement(driver, rolefield);
		String role=rolefield.getText();
		System.out.println(role);
		return role;
	}
	public String getProfileUsername()
	{
		String profiletext=profile_username.getText();
		return profiletext;
	}
	public void clickDeletePopupOkButton()
	{
		deletepopup_okbutton.click();
	}
	public String getSearchResultAfterDelete()
	{
		WaitUtility.waitForElement(driver, afterdelet_searchresult);
		String result=afterdelet_searchresult.getText();
		return result;
	}


}
