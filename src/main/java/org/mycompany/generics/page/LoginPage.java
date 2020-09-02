package org.mycompany.generics.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends PageBase{

	public LoginPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
	
	}
	//Page Locators
	private By username= By.name("uid");
	private By pasword= By.name("password");
	private By loginbutton= By.name("btnLogin");
	
	private By guru99text= By.xpath("//*[@class='barone' and contains(text(),'Guru99')]");
	private By DemoSiteText=By.xpath("//*[@title='Home' and contains(text(),'Demo Site')]");
	
	//Getters and Setters for performing Encapsualtion
	public WebElement getUsername() {
		return  getElement(username);
		
	}
	
	public WebElement getPasword() {
		return getElement(pasword);
	}
	
	public WebElement getLoginbutton() {
		return getElement(loginbutton);
	}
	
	public WebElement getGuru99text() {
		return getElement(guru99text);
	}
	
	public WebElement getDemoSiteText() {
		return getElement(DemoSiteText);
	}
	
	
	//Page Actions
	public String getLoginPageDemoSiteHeader()
	{
		return getPageHeader(DemoSiteText); // implementing abstract class
	}
	public String getLoginPageGuru99Header()
	{
		return getPageHeader(guru99text);  // implementing abstract class
	}
	
	public String getLoginPageTitle()
	{
		return getPageTitle();
	}
	
	public HomePage dologin(String uname,String pswd)
	{
		getUsername().sendKeys(uname);
		getPasword().sendKeys(pswd);
		getLoginbutton().click();
		return getInstance(HomePage.class);
	}
	
	// Method Overloading -> Wantedly using the below method to perform method Overloading
	public void dologin()
	{
		getUsername().sendKeys("");
		getPasword().sendKeys("");
		getLoginbutton().click();
		
	}
}
