package com.demowebshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.demowebshop.testBase.TestBase;

public class RegisterPage {
	
	WebDriver driver;
	By registerh1=By.xpath("//*[@class='page-title']/h1");
	By registerlink=By.xpath("//*[@class='ico-register']");
	By gendermalerbtn=By.id("gender-male");
	By firstNametxt=By.id("FirstName");
	By lastNametxt=By.id("LastName");
	By emailtxt=By.id("Email");
	By passtxt=By.id("Password");
	By confirmpasstxt=By.id("ConfirmPassword");
	By registerbtn=By.id("register-button");
	//Name of each element
	String registerLinknm="Register Link";
	String gendermalerbtnnm="Gender Male:";
	String firstnamenm="First Name";
	String lastnamenm="Last Name";
	String emailnm="Email";
	String passnm="Password";
	String confpassnm="Confirm Password";
	String registerbtnnm="Registration Button";
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
	}
	public String getTitle() {
		return driver.getTitle();
	}
	public String getCurrentUrlPage() {
		return driver.getCurrentUrl();
	}
	
	public void clickRegisterLink() {
		TestBase.click(driver,registerlink,registerLinknm);
	
	}
	public void clickGenderMale() {
		TestBase.click(driver,gendermalerbtn,gendermalerbtnnm);
		
	}
	public void enterFirstName(String fname) {
		TestBase.enterText(driver,firstNametxt,fname,firstnamenm);
		
	}
	public void enterLastName(String lname) {
		TestBase.enterText(driver,lastNametxt,lname,lastnamenm);
		
	}
	public void enterEmail() {
		String email=TestBase.randomEmail();
		TestBase.enterText(driver,emailtxt,email,emailnm);
		
	}
	public void enterPassword(String pwd) {
		driver.findElement(passtxt).sendKeys(pwd);
		TestBase.enterText(driver,passtxt,pwd,passnm);
	}
	public void enterConfirmPassword(String conpwd) {
		TestBase.enterText(driver,confirmpasstxt,conpwd,confpassnm);
	}
	public void clickRegisterbtn() {
		TestBase.click(driver,registerbtn,registerbtnnm);
	}
}


