package com.crm.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{
	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	ContactsPage contactsPage;
	String sheetName="Contacts";
	
	public ContactsPageTest(){
		super();
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage= new LoginPage();
		homePage=loginPage.login(prop.getProperty("username"),
					prop.getProperty("password"));
		testUtil=new TestUtil();
		contactsPage= new ContactsPage();
		testUtil.switchToFrame("mainpanel");
		//homePage.clickOnContactsLink();
	}
	
	@Test(priority=1)
	public void selectSingleContactTest(){
		homePage.clickOnContactsLink();
		contactsPage.selectContactsByName("Amit1 Pradhan1");
	}
	
	@Test(priority=2)
	public void selectMultipleContactTest(){
		homePage.clickOnContactsLink();
		contactsPage.selectContactsByName("Amit1 Pradhan1");
		contactsPage.selectContactsByName("Amit2 Pradhan2");
	}
	
	@Test(dataProvider="getCRMTestData")
	public void validateCreatenewContact(String title, String fName,
						String lName, String company){
		homePage.clickOnNewContactLink();
		//contactsPage.createNewContact("Mr.", "Amit3", "pradhan3","abcd3");
		contactsPage.createNewContact(title, fName, lName, company);
	}
	
	@DataProvider
	public Object[][] getCRMTestData(){
		Object[][] data = TestUtil.getTestData(sheetName);
		return data;
	}
	
	@AfterMethod
	public void tearDown(){
		driver.quit();
	}

}
