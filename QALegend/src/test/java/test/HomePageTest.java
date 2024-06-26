package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constant.Constants;
import constant.Messages;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base
{
	
	@Test
	public void verifyUserLoginDate()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE));
		login.enterPassWord(ExcelUtility.getIntegerData(0, 2, Constants.LOGIN_PAGE));
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.clickOnEndTourButton();
		String actualdate=home.getLoginDate();
		String expecteddate=home.getCurrentDate();
		Assert.assertEquals(actualdate, expecteddate,Messages.LOGINDATE_FAILED);
	}
	

}
