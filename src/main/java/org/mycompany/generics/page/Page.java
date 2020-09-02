package org.mycompany.generics.page;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.ss.formula.ptg.Ptg;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class Page {

	public static WebDriver driver;
	public static WebDriverWait wait;
	
	public Page(WebDriver driver, WebDriverWait wait)
	{
		this.driver = driver;
		this.wait = wait;
	}
	
	
	// abstract methods:
	public abstract String getPageTitle();
	public abstract String getPageHeader(By locator);
	public abstract WebElement getElement(By locator);
	public abstract void waitForElementPresent(By locator);
	
	// Java Generics
	public  <pType extends PageBase>  pType getInstance(Class <pType> pageclass) // getInstance() will return object of class
	{
		// At runtime passing the class into getInstance() for which object to be created and calling declared or its own constructor by passing webdriver instance
		// this is similar to code -> LoginPage page = new LoginPage(); if LoginPage is passed inside getInstance() 
		try {
			return pageclass.getDeclaredConstructor(WebDriver.class, WebDriverWait.class).newInstance(this.driver,this.wait);
		} catch (Exception e) {
		e.printStackTrace();
		}
		return null;
	}
}
