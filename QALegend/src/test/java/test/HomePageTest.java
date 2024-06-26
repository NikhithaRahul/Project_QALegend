package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.ExcelUtility;

public class HomePageTest extends Base
{
	
	@Test
	public void verifyUserLoginDate()
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(ExcelUtility.getStringData(0, 0, "AddUserPage"));
		login.enterPassWord(ExcelUtility.getIntegerData(0, 1, "AddUserPage"));
		login.clickOnLoginButton();
		HomePage home=new HomePage(driver);
		home.clickOnEndTourButton();
		String actualdate=home.getLoginDate();
		String expecteddate=home.getCurrentDate();
		Assert.assertEquals(actualdate, expecteddate,"Date Mismatch");
	}
	

}
