package test;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import pageobject.AddUserPage;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.UsersPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class UsersPageTest extends Base
{
	@Test
	public void verifyEditFunctionality()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(0, 1, "LoginPage"));
		login.enterPassWord(ExcelUtility.getIntegerData(0, 2, "LoginPage"));
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		home.clickOnUsers();
		UsersPage user=new UsersPage(driver);
		user.enterDataInSearchField(ExcelUtility.getStringData(0, 2, "UsersPage"));
		user.clickOnEditButton();
		AddUserPage adduser=new AddUserPage(driver);
		adduser.getSelectRole();
		user.clickOnUpdateButton();
		user.enterDataInSearchField(ExcelUtility.getStringData(0, 3, "UsersPage"));
		String actualrole=user.getRoleAfterSearch();
		String expectedrole=ExcelUtility.getStringData(0, 4, "UsersPage");
		Assert.assertEquals(actualrole, expectedrole,"Edit Functionality failed");
		
	}
	@Test
	public void verifyViewFunctionality()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(0, 1, "LoginPage"));
		login.enterPassWord(ExcelUtility.getIntegerData(0, 2, "LoginPage"));
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		home.clickOnUsers();
		UsersPage user=new UsersPage(driver);
		user.enterDataInSearchField(ExcelUtility.getStringData(1, 0, "UsersPage"));
		user.clickOnViewButton();
		String actualprofilename=user.getProfileUsername();
		String expectedprofilename=ExcelUtility.getStringData(1, 1, "UsersPage");
		Assert.assertEquals(actualprofilename, expectedprofilename, "VIEW FUNCTIONALITY FAILED");
	}
	@Test
	public void verifyDeleteFunctionality()
	{
		String prefix=RandomDataUtility.getPrefix();
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
		home.clickOnUsers();
		
		UsersPage user=new UsersPage(driver);
		user.clickOnAddButton();
		
		AddUserPage adduser=new AddUserPage(driver);
		adduser.enterPrefix(prefix);
		adduser.enterFirstName(firstname);
		adduser.enterLastName(lastname);
		adduser.enterEmail(emailid);
		adduser.getSelectRole();
		adduser.enterUserName(username);
		adduser.enterPassword(password);
		adduser.enterConfirmPassword(password);
		adduser.enterSalesCommissionPercent();
		adduser.clickOnSaveButton();
		user.enterDataInSearchField(emailid);
		user.clickOnDeleteButton();
		user.clickDeletePopupOkButton();
		user.enterDataInSearchField(emailid);
		String actualtext=user.getSearchResultAfterDelete();
		String expectedtext=ExcelUtility.getStringData(1, 2, "UsersPage");
		Assert.assertEquals(actualtext, expectedtext, "Delete functionality failed");
	}
		
	
}
