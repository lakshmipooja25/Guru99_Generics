package org.mycompany.generics.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends PageBase{

	public HomePage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		// TODO Auto-generated constructor stub
	}
	// Page locators
	private By guru99text= By.xpath("//*[@class='barone' and contains(text(),'Guru99')]");
	private By DemoSiteText=By.xpath("//*[@title='Home' and contains(text(),'Demo Site')]");
	
	private By NewCustomer = By.linkText("New Customer");

	//Page Encapsulation
	public WebElement getNewCustomer() {
		return getElement(NewCustomer);
	}
	
	public WebElement getGuru99text() {
		return getElement(guru99text);
	}

	public WebElement getDemoSiteText() {
		return getElement(DemoSiteText);
	}
	//Page Actions
	public void clickNewCustomer()
	{
		
	}
	
	public String getHomePageGuru99Header()
	{
		return getGuru99text().toString();	// calling getters and converting to string 
	}
	public String gethomePageDemoSiteHeader()
	{
		return getPageHeader(DemoSiteText); // implementing abstract class
	}
	public void getHomePageTitle()
	{
		getNewCustomer().click();
	}
	
}
