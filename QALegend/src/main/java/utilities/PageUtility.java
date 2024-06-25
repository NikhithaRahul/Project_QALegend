package utilities;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
	
	public static boolean verifyUserManagementisEnabled(WebElement element)
	{
		boolean isenabled=element.isEnabled();
		System.out.println(isenabled);
		return isenabled;
	}
	public static boolean verifyUsersfieldisEnabled(WebElement element)
	{
		boolean isenabled=element.isEnabled();
		System.out.println(isenabled);
		return isenabled;
	}
	public static boolean verifyRolesfieldisEnabled(WebElement element)
	{
		boolean isenabled=element.isEnabled();
		System.out.println(isenabled);
		return isenabled;
	}

}
