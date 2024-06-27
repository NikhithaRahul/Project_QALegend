package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constant.Messages;
import constant.Constants;
import dataprovider.DataProviders;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base
{
		
	@Test(groups="Regression")
	public  void verifyLoginWithValidCredentials()
	{
		String username=ExcelUtility.getStringData(0, 1,Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(0, 2,Constants.LOGIN_PAGE);
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		String actualtext=home.getUserNameTextDisplay();
		String expectedtext=ExcelUtility.getStringData(0, 3, Constants.LOGIN_PAGE);
		Assert.assertEquals(actualtext, expectedtext,Messages.LOGIN_FAILED);
		
	}
	
	@Test(groups="Sanity",dataProvider="InvalidLogincredentials",dataProviderClass=DataProviders.class)
	public void verifyErrorMsgWhileLoginWithInvalidCredentials(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		String actualerrormsg=login.invalidLoginErrorMessage();
		String expectederrormsg=ExcelUtility.getStringData(0, 4, Constants.LOGIN_PAGE);
		Assert.assertEquals(actualerrormsg, expectederrormsg,Messages.INVALIDLOGIN_SUCCESSFUL);
	}	
	

}
