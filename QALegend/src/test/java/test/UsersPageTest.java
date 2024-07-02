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
import constant.Constants;
import constant.Messages;
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
		login.enterUserName(ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE));
		login.enterPassWord(ExcelUtility.getIntegerData(0, 2, Constants.LOGIN_PAGE));
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		UsersPage user=home.clickOnUsers();
		user.enterDataInSearchField(ExcelUtility.getStringData(0, 2, Constants.USERS_PAGE));
		AddUserPage adduser=user.clickOnEditButton();
		adduser.getSelectRole();
		user.clickOnUpdateButton();
		user.enterDataInSearchField(ExcelUtility.getStringData(0, 3,Constants.USERS_PAGE ));
		String actualrole=user.getRoleAfterSearch();
		String expectedrole=ExcelUtility.getStringData(0, 4, Constants.USERS_PAGE );
		Assert.assertEquals(actualrole, expectedrole,Messages.EDIT_STATUS);
		
	}
	/*@Test
	public void verifyViewFunctionality()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE));
		login.enterPassWord(ExcelUtility.getIntegerData(0, 2, Constants.LOGIN_PAGE));
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		UsersPage user=home.clickOnUsers();
		user.enterDataInSearchField(ExcelUtility.getStringData(1, 0, Constants.USERS_PAGE));
		user.clickOnViewButton();
		String actualprofilename=user.getProfileUsername();
		String expectedprofilename=ExcelUtility.getStringData(1, 1, Constants.USERS_PAGE);
		Assert.assertEquals(actualprofilename, expectedprofilename,Messages.VIEW_FAILED);
	}*/
	@Test
	public void verifyDeleteFunctionality()
	{
		String prefix=RandomDataUtility.getPrefix();
		String firstname=RandomDataUtility.getFirstName();
		String lastname=RandomDataUtility.getLastName();
		String emailid=firstname+lastname+Constants.EMAIL;
		String actualemailid=emailid;
		String username=firstname+Constants.UNDERSCORE+lastname;
		String password=firstname+lastname+Constants.PWD_DATA;
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE));
		login.enterPassWord(ExcelUtility.getIntegerData(0, 2, Constants.LOGIN_PAGE));
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.clickOnEndTourButton();
		home.clickOnUserManagement();
		UsersPage user=home.clickOnUsers();
		
		AddUserPage adduser=user.clickOnAddButton();
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
		String expectedtext=ExcelUtility.getStringData(1, 2, Constants.USERS_PAGE);
		Assert.assertEquals(actualtext, expectedtext,Messages.DELETE_FAILED );
	}
		
	
}
