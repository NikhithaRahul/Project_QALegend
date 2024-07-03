package utilities;

import org.openqa.selenium.WebElement;

public class WebElementUtility {

	public static boolean isElementEnabled(WebElement element)
	{
		boolean isenabled=element.isEnabled();
		return isenabled;
	}
	
	public static boolean isElementDisplayed(WebElement element)
	{
		boolean isdisplayed=element.isDisplayed();
		return isdisplayed;
	}
	
	public static boolean isElementSelected(WebElement element)
	{
		boolean isselected=element.isSelected();
		return isselected;
	}

}
