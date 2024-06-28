package utilities;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtility {
	public static final long IMPLICITWAIT=10;
	public static final long EXPLICITWAIT=15;
	public static final long PAGELOADWAIT=10;
	
	public static void waitUsingImplicitWait(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(IMPLICITWAIT));
		
	}
	public static void waitForElement(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public static void waitForElementTobeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	public static void waitForElementtobeInvisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(EXPLICITWAIT));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	public static  void waitForElementUsingFluentWait(WebDriver driver,WebElement element)
	{
		FluentWait wait=new FluentWait(driver).withTimeout(Duration.ofSeconds(PAGELOADWAIT)).pollingEvery(Duration.ofSeconds(PAGELOADWAIT)).ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	

}
