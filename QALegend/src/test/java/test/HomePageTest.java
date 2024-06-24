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
	public void verifyProfileUpdate()
	{
		String username=ExcelUtility.getStringData(0, 0, "HomePage");
		String password=ExcelUtility.getIntegerData(0, 1,"HomePage");
		String lastname=ExcelUtility.getStringData(0, 3, "HomePage");
		String userfirstname=ExcelUtility.getStringData(0, 2, "HomePage");
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnXyzTab();
		home.clickOnProfile();
		home.clearlastnameField();
		home.enterLastname(lastname);
		home.clickOnUpdateButton();
		String actualusername=home.getUserNameText();
		String expectedusername=userfirstname+" "+lastname;
		Assert.assertEquals(actualusername, expectedusername, "Profile Updation failed");
				
	}
	@Test
	public void verifyUserLoginDate()
	{
		
	}
	

}
