package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{
	
	/**Q- What is @CacheLookup annotation ?
	 * A - 
	 * @CacheLookup annotation is used to improve the performance of the script.
	 * When we use @CacheLookup against any webelement with FindBy annotation, 
	 * the webelement will be stored in the cache memory so that if the webelement is 
	 * accessed multiple times, selenium would look for it in the cache rather than 
	 * the HTML page DOM which saves execution time.
	 * SO it is good practice is to add @CacheLookup.
	 * However, if the page got refreshed or page got changed , then this cache memory may
	 * get corrupted and throw StaleElementException.
	 *  
	 * @author Admin
	 *
	 */


	//1- Initializing page object in the const 
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	//find all the web elements
	
	@FindBy(xpath="//td[contains(text(),'User: Amit Pradhan ')]")
	@CacheLookup
	WebElement userNameLabel;
	
	//@FindBys(xp)
	
	//above code is same as below
	//WebElement userNameLabel=driver.findElement(By.xpath("//td[contains(text(),'User: Amit Pradhan ')]"));
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	@CacheLookup
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	@CacheLookup
	WebElement tasksLink;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	//@CacheLookup
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	//@CacheLookup
	WebElement newContactLink;
	
	
	//implement methods
	//homepage title 
	public String homepageTitle(){
		return driver.getTitle();
	}
	public ContactsPage clickOnContactsLink(){
		contactsLink.click();
		return new ContactsPage();
	}
	
	
	
	public TasksPage clickOnTaskLink(){
		tasksLink.click();
		return new TasksPage();
	}
	
	public boolean verifyCorrectUserName(){
		return userNameLabel.isDisplayed();
	}
	
	
	public void clickOnNewContactLink() {
		Actions action= new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
	}
	
	
	
	
	
	
	
	
	
	
	
}
