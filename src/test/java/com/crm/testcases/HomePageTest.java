package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class HomePageTest extends TestBase{
	
	//BEST PRACTICES
	//Testcases should be independent
	//before each testcase - launch browser and login
	//after each testcase - close the browser
	//so that it would avoid any caching or cookies issue
	
	
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
//	ContactsPage contactsPage;
	
	
	public HomePageTest(){
		super();
	}
	
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		testUtil=new TestUtil();
	}
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest(){
		String homepageTitle=homePage.homepageTitle();
		Assert.assertEquals(homepageTitle, "CRMPRO","Homepage title not matched.");
		
	}
	
	@Test(priority=2)
	public void verifyUserNameTest(){
		testUtil.switchToFrame("mainpanel");
		Assert.assertTrue(homePage.verifyCorrectUserName());
	}
	
	@Test(priority=3)
	public void verifyContactsLinkTest(){
		testUtil.switchToFrame("mainpanel");
		contactsPage = homePage.clickOnContactsLink();
	}
	
	

}
