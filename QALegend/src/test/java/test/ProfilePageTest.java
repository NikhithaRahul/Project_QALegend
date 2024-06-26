package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constant.Constants;
import constant.Messages;
import pageobject.HomePage;
import pageobject.LoginPage;
import pageobject.ProfilePage;
import utilities.ExcelUtility;

public class ProfilePageTest extends Base
{
	@Test
	public void verifyProfileUpdate()
	{
		String username=ExcelUtility.getStringData(0, 1, Constants.LOGIN_PAGE);
		String password=ExcelUtility.getIntegerData(0, 2,Constants.LOGIN_PAGE);
		String lastname=ExcelUtility.getStringData(0, 1, Constants.PROFILE_PAGE);
		String userfirstname=ExcelUtility.getStringData(0, 0, Constants.PROFILE_PAGE);
		
		LoginPage login=new LoginPage(driver);
		login.enterUserName(username);
		login.enterPassWord(password);
		
		HomePage home=login.clickOnLoginButton();
		home.clickOnEndTourButton();
		ProfilePage profile=home.clickOnProfileTab();
		profile.clickOnProfile();
		profile.clearlastnameField();
		profile.enterLastname(lastname);
		profile.clickOnUpdateButton();
		
		String actualusername=home.getUserNameText();
		String expectedusername=userfirstname+" "+lastname;
		Assert.assertEquals(actualusername, expectedusername, Messages.PROFILEUPDATE_FAILED);
				
	}

}
