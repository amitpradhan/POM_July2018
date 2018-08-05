package com.crm.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ForgotPasswordPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
	
	LoginPage loginPage;
	HomePage  homePage;
	ForgotPasswordPage forgotPassword;
	String expectedTitle="#1 Free CRM for Any Business: Online Customer Relationship Software";
	
	//create constructor of this class
		public LoginPageTest() {
			super();
		}

		@BeforeMethod
		public void setUp(){
			initialization();
			loginPage= new LoginPage();	
		}
		
		@Test(priority=3)
		public void loginTest(){
			homePage=loginPage.login(prop.getProperty("username"),
										prop.getProperty("password"));
			
			//validate successful login by checking the title
			Assert.assertEquals(driver.getTitle(), "CRMPRO",
					"Login unsuccessful");
		}
		
		
		@Test(priority=2)
		public void crmLogoImageTest(){
			boolean flag =loginPage.validateCRMImage();
			Assert.assertTrue(flag);
		}
		@Test(priority=1)
		public void loginPageTitle(){
			String actualTitle = loginPage.validateTitle();
			//String actualTitle = driver.getTitle();
			Assert.assertEquals(actualTitle,expectedTitle+" failing intentinally." );
		}
		

		@AfterMethod
		public void tearDown(){
			driver.quit();
		}
	
}
