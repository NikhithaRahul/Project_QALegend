package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import utilities.ExcelUtility;

public class ProfilePageTest extends Base
{
	@Test
	public void verifyProfileUpdate()
	{
		String username=ExcelUtility.getStringData(0, 1, "LoginPage");
		String password=ExcelUtility.getIntegerData(0, 2,"LoginPage");
		String lastname=ExcelUtility.getStringData(0, 1, "ProfilePage");
		String userfirstname=ExcelUtility.getStringData(0, 0, "ProfilePage");
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		home.clickOnXyzTab();
		
		ProfilePage profile=new ProfilePage(driver);
		profile.clickOnProfile();
		profile.clearlastnameField();
		profile.enterLastname(lastname);
		profile.clickOnUpdateButton();
		
		String actualusername=home.getUserNameText();
		String expectedusername=userfirstname+" "+lastname;
		Assert.assertEquals(actualusername, expectedusername, "Profile Updation failed");
				
	}

}
