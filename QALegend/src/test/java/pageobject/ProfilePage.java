package pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage {
	WebDriver driver;
	public ProfilePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(xpath="//a[text()='Profile']")
	WebElement profiletab;
	@FindBy(id="last_name")
	WebElement lastname;
	@FindBy(xpath="//button[text()='Update']")
	WebElement updatebutton;
	
	public void clickOnProfile()
	{
		profiletab.click();
	}
	public void enterLastname(String lastnamefield)
	{
		lastname.sendKeys(lastnamefield);
	}
	public void clearlastnameField()
	{
		lastname.clear();
	}
	public void clickOnUpdateButton()
	{
		updatebutton.click();
	}

}
