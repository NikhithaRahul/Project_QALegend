package test;

import org.testng.Assert;
import org.testng.annotations.Test;

import automation_core.Base;
import constant.Constants;
import constant.Messages;
import pageobject.LoginPage;
import pageobject.ResetPage;
import utilities.ExcelUtility;

public class ResetPageTest extends Base {
	@Test(groups="Sanity")
	public void verifyResetPageTitle()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=new ResetPage(driver);
		login.clickOnforgotPassword();
		String actualtitle=reset.resetPageTitle();
		String expectedtitle=ExcelUtility.getStringData(0, 2, Constants.RESET_PAGE);
		Assert.assertEquals(actualtitle, expectedtitle,Messages.RESETTITLE_MISMATCH);
		
	}
	@Test(groups="Smoke")
	
	public void verifyErrorMsgWithInvalidEmailId()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=login.clickOnforgotPassword();
		String emailid=ExcelUtility.getStringData(0, 0, Constants.RESET_PAGE);
		reset.enterEmailAddress(emailid);
		reset.clickOnPasswordResetLink();
		String actualerrormsg=reset.invalidEmailErrorMessage();
		String expectederrormsg=ExcelUtility.getStringData(0, 1, Constants.RESET_PAGE);
		Assert.assertEquals(actualerrormsg, expectederrormsg,Messages.RESET_SUCCESSFUL );
		
	}
	@Test(groups="Smoke")
	public void verifyPasswordResetwithValidEmailId()
	{
		LoginPage login=new LoginPage(driver);
		ResetPage reset=login.clickOnforgotPassword();
		String emailid=ExcelUtility.getStringData(1, 0, Constants.RESET_PAGE);
		reset.enterEmailAddress(emailid);
		reset.clickOnPasswordResetLink();
		String actualalertmsg=reset.validEmailAlertMessage();
		String expectedalertmsg=ExcelUtility.getStringData(1, 1,Constants.RESET_PAGE);
		Assert.assertEquals(actualalertmsg, expectedalertmsg, Messages.RESET_FAILED);
		
	}

}
