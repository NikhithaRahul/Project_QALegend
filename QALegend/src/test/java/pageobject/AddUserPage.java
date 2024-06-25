package pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.ExcelUtility;
import utilities.PageUtility;

public class AddUserPage {
	WebDriver driver;
	public AddUserPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="surname")
	WebElement prefix;
	@FindBy(xpath="//input[@id='first_name']")
	WebElement firstnamefield;
	@FindBy(id="last_name")
	WebElement lastnamefield;
	@FindBy(id="email")
	WebElement emailfield;
	//@FindBy(xpath="//span[@class='select2-selection select2-selection--single']")
	//WebElement roleselection;
	//@FindBy(id="role")
	//WebElement roledrpdwn;
	@FindBy(id="username")
	WebElement username_field;
	@FindBy(id="password")
	WebElement password_field;
	@FindBy(xpath="//input[@name='confirm_password']")
	WebElement confirm_password;
	@FindBy(id="cmmsn_percent")
	WebElement sales_commision;
	@FindBy(id="submit_user_button")
	WebElement save_button;
	@FindBy(xpath="//select[@class='form-control select2 select2-hidden-accessible' and @id='role']")
	WebElement roleselection;
	
/*	public void enterPrefix(String user_prefix)
	{
		prefix.sendKeys(user_prefix);
	}*/
	public void enterFirstName(String first_name)
	{
		firstnamefield.sendKeys(first_name);
		
	}
	public void enterLastName(String last_name)
	{
		lastnamefield.sendKeys(last_name);
		
	}
	public void enterEmail(String emailid)
	{
		emailfield.sendKeys(emailid);
	}
	public Select getSelectedRole()
	{
		//roleselection.click();
		//Select select=new Select(roledrpdwn);
		//select.selectByVisibleText("Supervisor");
		//return select;
		PageUtility page=new PageUtility();
		Select select =new Select(roleselection);
		List<WebElement> roleslist=select.getOptions();
		int size=roleslist.size();
		//System.out.println(roleslist.size());
		for(int i=0;i<size;i++)
		{
			String roles=roleslist.get(i).getText();
			if(roles.equals("Supervisor"))
			{
				
				page.selectByVisibleText(roleselection, roles);
				
			}
		}
	}
	public void enterUserName(String username)
	{
		username_field.sendKeys(username);
	}
	public void enterPassword(String password)
	{
		password_field.sendKeys(password);
	}
	public void enterConfirmPassword(String password)
	{
		confirm_password.sendKeys(password);
	}
	public void enterSalesCommissionPercent()
	{
		sales_commision.sendKeys(ExcelUtility.getIntegerData(0, 2, "AddUserPage"));
	}
	public void clickOnSaveButton()
	{
		save_button.click();
	}
	

}
