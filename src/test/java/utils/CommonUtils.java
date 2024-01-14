package utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import enums.Months;
import utils.DriversUtils.*;

import static utils.DriversUtils.getDriver;

import java.time.Month;

public class CommonUtils {

	Months month;

	public void scrollDown() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollBy(0,250)");
	}

	public static void scrollToElement(WebElement element){
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].scrollIntoView();", element);
	}
	
	public static void clickElement(WebElement element)
	{
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("arguments[0].click();", element);
	}

	public static String getCurrentYear(String date){
		return date.replaceAll("[^0-9]", "");
	}

	public static String getCurrentMonth(String date){
		Months month = Months.valueOf(date.replaceAll("[^a-zA-Z]+", "").trim());
		return month.getValue();
	}


}
