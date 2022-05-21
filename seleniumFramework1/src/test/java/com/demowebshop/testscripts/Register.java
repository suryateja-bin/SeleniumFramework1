package com.demowebshop.testscripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.*;

import com.demowebshop.pages.RegisterPage;
import com.demowebshop.testBase.TestBase;
import com.relevantcodes.extentreports.LogStatus;


public class Register extends TestBase {
	RegisterPage registerPage; 
	@BeforeClass
	public void setup() throws IOException {
		//Invoke the browser from the test base class
		invoke();
		registerPage=new RegisterPage(driver);
		System.out.println("test");
	}
	@Test
	public void VerifyDemoWebShopRegisterWithValidData() {
		test=extent.startTest("TC01_VerifyDemoWebShopRegisterWithValidData");
		
		registerPage.clickRegisterLink();
		String title=registerPage.getTitle();
		
		Assert.assertEquals(title, "Demo Web Shop. Register");
		
		registerPage.clickGenderMale();
		
		registerPage.enterFirstName("Surya");
		
		registerPage.enterLastName("Teja");
		
		registerPage.enterEmail();
		
		registerPage.enterPassword("xyz123");
		
		registerPage.enterConfirmPassword("xyz123");
		
		registerPage.clickRegisterbtn();
	}
	
	
	@AfterClass
	public void closeBrowser() {
		extent.flush();
		extent.endTest(test);
		driver.close();
	}
	
}
