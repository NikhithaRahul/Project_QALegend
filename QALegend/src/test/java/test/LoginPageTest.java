package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import dataprovider.DataProviders;
import pageobject.HomePage;
import pageobject.LoginPage;
import utilities.ExcelUtility;

public class LoginPageTest extends Base
{
		
	@Test
	public  void verifyLoginWithValidCredentials()
	{
		String username=ExcelUtility.getStringData(0, 1, "LoginPage");
		String password=ExcelUtility.getIntegerData(0, 2,"LoginPage");
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		String actualtext=home.getUserNameTextDisplay();
		String expectedtext=ExcelUtility.getStringData(0, 3, "LoginPage");
		Assert.assertEquals(actualtext, expectedtext,"User Login with valid credentials failed");
		
	}
	
	@Test(dataProvider="InvalidLogincredentials",dataProviderClass=DataProviders.class)
	public void verifyErrorMsgWhileLoginWithInvalidCredentials(String username,String password)
	{
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		String actualerrormsg=login.invalidLoginErrorMessage();
		String expectederrormsg=ExcelUtility.getStringData(0, 4, "LoginPage");
		Assert.assertEquals(actualerrormsg, expectederrormsg,"Successfully logined with Invalid credentials");
	}	
	

}
