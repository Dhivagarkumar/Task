package com.TestNG_Practice;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.baseclass.BassClass;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestNG_Practice extends BassClass {
	public static WebDriver driver;
	
	@BeforeSuite
	public void setproperty() {
		WebDriverManager.chromedriver().setup();
	}
	@BeforeTest
	public void browserlanch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		}
	@BeforeClass
	public void Url() {
		driver.get("https://www.saucedemo.com/");
	}
	@BeforeMethod
	public void login() {
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("standard_user");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}
	@Test
	public void addcart() {
		driver.findElement(By.xpath("//div[text()='29.99']/following-sibling::button")).click();
		driver.findElement(By.xpath("/html/body/div/div/div/div[1]/div[1]/div[3]/a")).click();
	}
	@AfterMethod
	public void openmenu() {
		driver.findElement(By.xpath("//button[text()='Open Menu']")).click();


	}
	@AfterClass
	public void logout() {
		
		driver.findElement(By.xpath("//a[text()='Logout']")).click();
		

	}
	@AfterTest
	public void deletecookies() {
		driver.manage().deleteAllCookies();

	}
	@AfterSuite
	public void Quit() {
		driver.quit();
		
		

	}
	
	

	
	
	
	
	
}
