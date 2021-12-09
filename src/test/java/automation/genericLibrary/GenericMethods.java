package automation.genericLibrary;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class GenericMethods {

	WebDriver driver;

	public GenericMethods(WebDriver driver) {
		this.driver = driver;
	}

	public void click(WebElement element) {
		element.click();
	}

	public void enterText(WebElement element, String text) {
		element.click();
		element.clear();
		element.sendKeys(text);
	}

	public boolean isElementPresentInScreen(WebElement element, int waitTime) {
		boolean flag = false;
		try {
			new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOf(element));
			flag = true;
		} catch (Exception e) {
			// TODO: handle exception
			flag = false;
		}
		return flag;
	}

	public void waitForElementToLoad(WebElement element, int waitTime) {
		new WebDriverWait(driver, waitTime).until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForPageToLoadFully() {
		ExpectedCondition<Boolean> javascriptDone = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				try {
					return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
				} catch (Exception e) {
					return Boolean.FALSE;
				}
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 180);
		wait.until(javascriptDone);
	}

	public void waitForAllElement(WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(element));

	}

}
