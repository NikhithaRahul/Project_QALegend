package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import listner.RetryAnalyzer;
import pageobject.AddUserPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AddUserPageTest extends Base{

	@Test
	public void verifyAddUser()
	{
		//String prefix=RandomDataUtility.getPrefix();
		String firstname=RandomDataUtility.getFirstName();
		String lastname=RandomDataUtility.getLastName();
		String emailid=firstname+lastname+"@gmail.com";
		String actualemail=emailid;
		String username=firstname+"_"+lastname;
		String password=firstname+lastname+"@12";
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(0, 0, "AddUserPage"));
		login.enterPassWord(ExcelUtility.getIntegerData(0, 1, "AddUserPage"));
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		home.clickOnUsers();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span)[8]")));
		UsersPage user=new UsersPage(driver);
		user.clickOnAddButton();
		AddUserPage adduser=new AddUserPage(driver);
		//adduser.enterPrefix(prefix);
		adduser.enterFirstName(firstname);
		adduser.enterLastName(lastname);
		adduser.enterEmail(emailid);
		adduser.getSelectedRole();
		adduser.enterUserName(username);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(password);
		adduser.enterSalesCommissionPercent();
		adduser.clickOnSaveButton();
		user.enterDataInSearchField(emailid);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//td)[4]")));
		String expectedemail=user.getSearchResultText();
		Assert.assertEquals(actualemail, expectedemail,"Adding new user failed");
				
	}
	@Test(retryAnalyzer=RetryAnalyzer.class)
	public void verifyUserLoginWithNewlyaddeduser()
	{
		//String prefix=RandomDataUtility.getPrefix();
		String firstname=RandomDataUtility.getFirstName();
		String lastname=RandomDataUtility.getLastName();
		String emailid=firstname+lastname+"@gmail.com";
		String actualemailid=emailid;
		String username=firstname+"_"+lastname;
		String password=firstname+lastname+"@12";
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(0, 0, "AddUserPage"));
		login.enterPassWord(ExcelUtility.getIntegerData(0, 1, "AddUserPage"));
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		home.clickOnUsers();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span)[8]")));
		UsersPage user=new UsersPage(driver);
		user.clickOnAddButton();
		AddUserPage adduser=new AddUserPage(driver);
		//adduser.enterPrefix(prefix);
		adduser.enterFirstName(firstname);
		adduser.enterLastName(lastname);
		adduser.enterEmail(emailid);
		adduser.getSelectedRole();
		adduser.enterUserName(username);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(password);
		adduser.enterSalesCommissionPercent();
		adduser.clickOnSaveButton();
		home.clickOnHomeTab();
		home.clickOnXyzTab();
		home.clickOnSignOut();
		login.enterUserName(username);
		login.enterPassWord(password);
		login.clickOnLoginButton();
		String actualtext=home.getUserNameText();
		String expectedtext=firstname+" "+lastname;
		Assert.assertEquals(actualtext, expectedtext,"login failed");
				
	}


}
