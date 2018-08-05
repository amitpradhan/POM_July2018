package com.crm.qa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase {
	
	//initlize driver using Pagefactory.
	//driver is coming from TestBase class
		public LoginPage(){
			super();
			PageFactory.initElements(driver, this);
			
		}
 
		//username 
		@FindBy(name="username")
		WebElement username;
		/**
		 * Same as writing - 
		 * WebElement username=driver.findElement(By.name='username');
		 */
		
		//password
		@FindBy(name="password")
		WebElement password;
		
		//login button
		@FindBy(xpath="//input[@type='submit' and @value='Login']")
		WebElement loginBtn;
		//@FindBy(xpath="//img[contains(@class,'img-responsive')]")
		@FindBy(xpath="//a[@class='navbar-brand']/child::img")
		WebElement crmLogo;
		
		@FindBy(xpath="//a[text()='Forgot Password?']")
		WebElement forgotPasswordLink;
		
		
		//HomePage is the landing page of Login method
		public HomePage login(String uname, String pwd){
			username.sendKeys(uname);
			password.sendKeys(pwd);
			loginBtn.click();
			//password.sendKeys(Keys.ENTER);
			
			return new HomePage();
			
		}
		public ForgotPasswordPage clickForgotPassWord(){
			forgotPasswordLink.click();
			return new ForgotPasswordPage();
			
		}
		
		public String validateTitle(){
			return driver.getTitle();
		}
		
		public boolean validateCRMImage(){
			return crmLogo.isDisplayed();
		}
		
		
}
