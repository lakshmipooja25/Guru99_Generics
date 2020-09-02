package org.mycompany.generics.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase extends Page{

	public PageBase(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		
	}

	// child class has to implement all the abstract methods in Page Class. 
	
	@Override  //Method Overriding -> same method name, same method signature, same no of parameter of parent class
	public String getPageTitle() {
		return driver.getTitle();
		
	}

	@Override
	public String getPageHeader(By locator) {
		return getElement(locator).getText();
		
	}

	@Override
	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
			return element;
		}
		catch(Exception e)
		{
			System.out.println("Issue in Element. Please check" + element.getText());
			e.printStackTrace();
		}
		return element;
	}
	
	@Override
	public void waitForElementPresent(By locator) {
		try {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		}
		catch(Exception e)
		{
			System.out.println("some exception has occured when waiting for element" +locator.toString());
		}
	}

	public void doSendKeys(By locator, String text)
	{
		driver.findElement(locator).sendKeys(text);
	}
	
	public void doClick(By locator)
	{
		driver.findElement(locator).click();
	}
	public String dogetLogoName(By locator)
	{
		return driver.findElement(locator).getText();
	}

	
	
}
