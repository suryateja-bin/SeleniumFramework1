package com.demowebshop.testBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.BeforeSuite;
//import com.demowebshop.config.*;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestBase {
	/**Configuration o Browsers
	 * All Reusable methods
	 * Reporting utilities
	 * Property readers
	 * xml readers
	 */
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fis;
	public static DesiredCapabilities cap;
	public static ExtentTest test;
	public static ExtentReports extent; 
	
	static {
		Calendar cal=Calendar.getInstance();
		SimpleDateFormat formatter=new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		
		extent=new ExtentReports(System.getProperty("user.dir")+"/testreport/"+formatter.format(cal.getTime())+".html",false);
	}
	
	public void properties() throws IOException {
		prop=new Properties();
		
		try {
			fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\java\\com\\demowebshop\\config\\config.properties");
			prop.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Property file data :"+prop);
	}
	public static void click(WebDriver driver,By ElementLocator,String name) {
		try {
			WebElement ele=driver.findElement(ElementLocator);
			if(ele.isDisplayed()) {
				ele.click();
				test.log(LogStatus.PASS, "To verify user able to click on "+name,name+"clicked successfully");
			}
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "To verify "+name+"is visible or clickable in provided time"+"An exception occured wait for element"+name+"to click");
		}
		
	}
	public static void enterText(WebDriver driver,By ElementLocator,String value,String name) {
		try {
			WebElement ele=driver.findElement(ElementLocator);
			if(ele.isDisplayed()) {
				ele.clear();
				ele.sendKeys(value);
				test.log(LogStatus.PASS, "To verify user able to enter value in "+name,value+"Entered successfully");
			}
			
		}catch(Exception e) {
			test.log(LogStatus.FAIL, "To verify "+name+"is visible or enter in provided time"+"An exception occured wait for element"+name+"to enter");
		}
	}
	public static String randomEmail() {
		Random rand=new Random();
		int num=rand.nextInt(1000);
		String email="test"+num+"@"+"gmail.com";
		return email;
	}
	public void invoke() throws IOException {
		properties();
		System.out.println("Running browser name");
		invokeBrowser(prop.getProperty("browserName"));
		//invokeBrowser("Chrome");
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
	}
	public void invokeBrowser(String browser) {
		
		System.out.println("browser name");
		
			if(browser.contains("Chrome")) {
				System.out.println("browser chrome");
				WebDriverManager.chromedriver().setup();
				ChromeOptions options=new ChromeOptions();
				options.addArguments("--incognito");
				new DesiredCapabilities();
				cap=DesiredCapabilities.chrome();
				cap.setCapability(ChromeOptions.CAPABILITY,options);
				driver=new ChromeDriver(cap);
			
				
			}else if(browser.contains("Firefox")) {
				
			}else {
				
			}
		}
		
		}
		

