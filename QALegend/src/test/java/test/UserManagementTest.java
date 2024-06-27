package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constant.Constants;
import constant.Messages;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.UserManagement;
import utilities.ExcelUtility;

public class UserManagementTest extends Base{
	@Test
	public void verifyUsersFieldisEnabled()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(0, 2,Constants.LOGIN_PAGE);
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		UserManagement user_mngmt=home.clickOnUserManagement();
		boolean status=user_mngmt.isUserFieldEnabled();
		Assert.assertTrue(status, Messages.ELEMENT_DISABLED);
	}
	@Test
	public void verifyRolesFieldisEnabled()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(0, 2,Constants.LOGIN_PAGE);
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();			
		UserManagement user_mngmt=home.clickOnUserManagement();
		boolean status=user_mngmt.isRolesFieldEnabled();
		Assert.assertTrue(status, Messages.ELEMENT_DISABLED);
	}
	@Test
	public void verifySalesCommissionAgentFieldisEnabled()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(0, 2,Constants.LOGIN_PAGE);
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();			
		UserManagement user_mngmt=home.clickOnUserManagement();
		boolean status=user_mngmt.issalesCommisionAgentFieldEnabled();
		Assert.assertTrue(status, Messages.ELEMENT_DISABLED);
	}

}
