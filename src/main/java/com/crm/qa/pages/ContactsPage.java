package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {
	//Initializing page object
		public ContactsPage() {
			//super();
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath="//a[contains(text(),'Contacts')]")
		WebElement contactsLabel;
		
		public void selectContactsByName(String name){
				driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']//preceding-sibling::td[@class='datalistrow']/input[@name='contact_id']")).click();
		}
		
		@FindBy(name="title")
		WebElement title;
		
		@FindBy(id="first_name")
		WebElement firstName;
		
		@FindBy(id="surname")
		WebElement lastName;
		
		@FindBy(name="client_lookup")
		WebElement companyName;
		
		@FindBy(xpath="//input[@value='Save']")
		WebElement saveBtn;
		
		public void createNewContact(String titleText, String fName, String lName, String company){
			Select titleDropDown = new Select(title);
			titleDropDown.selectByVisibleText(titleText);
			
			firstName.sendKeys(fName);
			lastName.sendKeys(lName);
			companyName.sendKeys(company);
			saveBtn.click();		
			
		}

}
