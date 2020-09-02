package org.mycompany.TestClasses;

import org.mycompany.generics.page.HomePage;
import org.mycompany.generics.page.LoginPage;
import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class LoginPageTest extends TestBase {

	Assertion assert1= new Assertion();
	HomePage homepage;
	@Test(priority =1)
	public void verifyGetLoginPageTitle()
	{
		//same as LoginPage lp = new LoginPage();
		String pagetitle =page.getInstance(LoginPage.class).getLoginPageTitle();
		
		assert1.assertEquals(pagetitle, "Guru99 Bank Home Page" , "Assertion is successful");
		
	}
	@Test(priority =2)
	public void verifyGetDemoPageGuru99Header()
	{
		String guru99text=page.getInstance(LoginPage.class).getLoginPageGuru99Header();
		assert1.assertEquals(guru99text, "Guru99 Bank" , "Guru99 Text is displayed successful");
	}
	
	@Test(priority =3)
	public void VerifyGetLoginPageDemoSiteHeader()
	{
		
		String DemoSitetext=page.getInstance(LoginPage.class).getLoginPageDemoSiteHeader();
		assert1.assertEquals(DemoSitetext, "Demo Site" , "Guru99 Text is displayed successful");
		
	}
	@Test(priority =4)
	public void testLogin()
	{
		homepage=page.getInstance(LoginPage.class).dologin("mngr281603", "mAbegym");
		
	}
	
	
}
