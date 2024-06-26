package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import pageobject.LoginPage;
import pageobject.ResetPage;
import utilities.ExcelUtility;

public class ResetPageTest extends Base {
	@Test
	public void verifyResetPageTitle()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=new ResetPage(driver);
		login.clickOnforgotPassword();
		String actualtitle=reset.resetPageTitle();
		String expectedtitle=ExcelUtility.getStringData(0, 2, "ResetPage");
		Assert.assertEquals(actualtitle, expectedtitle,"TITLE MISMATCH");
		
	}
	@Test
	
	public void verifyErrorMsgWithInvalidEmailId()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=login.clickOnforgotPassword();
		
		String emailid=ExcelUtility.getStringData(0, 0, "ResetPage");
		reset.enterEmailAddress(emailid);
		reset.clickOnPasswordResetLink();
		String actualerrormsg=reset.invalidEmailErrorMessage();
		String expectederrormsg=ExcelUtility.getStringData(0, 1, "ResetPage");
		Assert.assertEquals(actualerrormsg, expectederrormsg, "Reset password link emailed successfully");
		
	}
	@Test
	public void verifyPasswordResetwithValidEmailId()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=login.clickOnforgotPassword();
		String emailid=ExcelUtility.getStringData(1, 0, "ResetPage");
		reset.enterEmailAddress(emailid);
		reset.clickOnPasswordResetLink();
		String actualalertmsg=reset.validEmailAlertMessage();
		String expectedalertmsg=ExcelUtility.getStringData(1, 1, "ResetPage");
		Assert.assertEquals(actualalertmsg, expectedalertmsg, "Sending reset password link failed");
		
	}

}
