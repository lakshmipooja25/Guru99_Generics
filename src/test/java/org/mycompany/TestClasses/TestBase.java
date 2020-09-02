package org.mycompany.TestClasses;
import java.util.concurrent.TimeUnit;

import org.mycompany.generics.page.Page;
import org.mycompany.generics.page.PageBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

public class TestBase {

	public WebDriver driver;
	public WebDriverWait wait;
	public Page page;
	@BeforeMethod
	@Parameters({"browser"})
	public void setUp(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
		System.setProperty("webdriver.chrome.driver", "D:\\Automation_Resources\\Selenium\\Chrome Driver\\chromedriver.exe");
		driver = new ChromeDriver();
		}
		else if(browser.equalsIgnoreCase("firefox"))
		{
			System.out.println("browser under construction");
		}
		driver.manage().window().maximize();
		driver.get("http://demo.guru99.com/V4/");
		driver.manage().deleteAllCookies();
		page = new PageBase(driver, wait); // cannot create object for abstract class (Page class). SO create object for PageBase class and refer to abstract class
	}
	//@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}

