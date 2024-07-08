package utilities;


import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class PageUtility {
	public static void selectByValue(WebElement element, String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	
	public static void selectByIndex(WebElement element, int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	
	public static void selectByVisibleText(WebElement element, String visibletext)
	{
		Select select=new Select(element);
		select.selectByVisibleText(visibletext);
	}
	
	public static void clickOnAlertAcceptButton(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.accept();
	}
	public static void clickOnAlertDeleteButton(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		alert.dismiss();
	}
	public static void enterDatainAlertBox(WebDriver driver,String text)
	{
		Alert alert=driver.switchTo().alert();
		alert.sendKeys(text);
	}
	public static String getTextInAlert(WebDriver driver)
	{
		Alert alert=driver.switchTo().alert();
		return alert.getText();
	}
	public static void verifyDoubleClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.doubleClick(element).build().perform();
	}
	public static void verifyRightClick(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.contextClick(element).build().perform();
	}
	public static void verifyClickAndHold(WebDriver driver, WebElement element)
	{
		Actions action=new Actions(driver);
		action.clickAndHold(element).build().perform();
	}
	public static void verifyMouseRelease(WebDriver driver)
	{
		Actions action=new Actions(driver);
		action.release().perform();
	}
	public static void verifyDragAndDrop(WebDriver driver,WebElement drag,WebElement drop)
	{
		Actions action=new Actions(driver);
		action.dragAndDrop(drag, drop).build().perform();
	}
	public static void verifyDragAndDropOffset(WebDriver driver,WebElement drag,int xoffset,int yoffset)
	{
		Actions action=new Actions(driver);
		action.dragAndDropBy(drag, xoffset, yoffset).build().perform();
	}
	public static void verifyMouseHover(WebDriver driver,WebElement element)
	{
		Actions action=new Actions(driver);
		action.moveToElement(element).build().perform();
	}
	public static void verifyMoveByOffset(WebDriver driver,int xoffset,int yoffset)
	{
		Actions action=new Actions(driver);
		action.moveByOffset(xoffset, yoffset);
	}
	public static void switchtoFrameUsingWebElement(WebDriver driver,WebElement element)
	{
		driver.switchTo().frame(element);
	}
	public static void switchtoFrameUsingIndex(WebDriver driver,int index)
	{
		driver.switchTo().frame(index);
	}
	public static void switchtoFrameUsingId(WebDriver driver,String id)
	{
		driver.switchTo().frame(id);
	
	}
	
	

}
