package test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import automation_core.Base;
import utilities.ExcelUtility;

public class UsersPageTest extends Base
{
	@Test
	public void verifyEditUser()
	{
		WebElement usernamefield=driver.findElement(By.id("username"));
		usernamefield.sendKeys(ExcelUtility.getStringData(0, 0, "UsersPage"));
		WebElement passwordfield=driver.findElement(By.xpath("//input[@name='password']"));
		passwordfield.sendKeys(ExcelUtility.getIntegerData(0, 1,"UsersPage"));
		WebElement loginbutton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
		loginbutton.click();
		WebElement endtourbutton=driver.findElement(By.xpath("//button[@class='btn btn-default btn-sm']"));
		endtourbutton.click();
	
		WebElement usermanagement=driver.findElement(By.xpath("//span[text()='User Management']"));
		usermanagement.click();
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement users=driver.findElement(By.xpath("(//span)[8]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//span)[8]")));
		users.click();
		WebElement searchfield=driver.findElement(By.xpath("//input[@class='form-control input-sm']"));
		searchfield.sendKeys(ExcelUtility.getStringData(0, 2, "UsersPage"));
				
		WebElement editbutton=driver.findElement(By.xpath("(//i)[103]"));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//i)[103]")));
		editbutton.click();
	}

}
