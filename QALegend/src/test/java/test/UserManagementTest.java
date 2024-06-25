package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.UserManagement;
import utilities.ExcelUtility;

public class UserManagementTest extends Base{
	@Test
	public void verifyUserManagementOption()
	{
		String username=ExcelUtility.getStringData(0, 1, "LoginPage");
		String password=ExcelUtility.getIntegerData(0, 2,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
				
		home.clickOnEndTourButton();
		home.clickOnXyzTab();
		
		UserManagement user_management=new UserManagement(driver);
		boolean status=user_management.checkElementEnabled();
		
		Assert.assertTrue(status, "UserManagement Element Disabled");
	}

}
