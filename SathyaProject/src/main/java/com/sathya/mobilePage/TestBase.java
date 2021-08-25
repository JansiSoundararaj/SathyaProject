package com.sathya.mobilePage;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
	WebDriver driver;
	WebDriverWait wait;
	
	@SuppressWarnings("deprecation")
	public void browserOpen() {
		System.setProperty("webdriver.chrome.driver", "D:\\Testing class\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5000);
		driver.get("https://www.sathya.in/");
		driver.findElement(By.xpath("//div[@id='content-center']//a[@title='Show products in category Electronics']")).click();
		driver.findElement(By.xpath("//div[@id='content-center']//a[@title='Show products in category Mobiles']")).click();
		driver.findElement(By.xpath("//div[@class='artlist-actions artlist-actions--top d-flex flex-wrap']//select[@id='artlist-action-pagesize' and @title='24 per Page']")).click();
		driver.findElement(By.xpath("//div[@class='artlist-actions artlist-actions--top d-flex flex-wrap']//select[@id='artlist-action-pagesize' and @title='24 per Page']//option[@value='48']")).click();
	}
	public void maximizeWindow() {
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,5000)");
	}
	

	@SuppressWarnings("deprecation")
	public void pageLoadTimeout() {
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
	
	}
	
	public void implicitWait() {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='artlist-actions artlist-actions--top d-flex flex-wrap']//select[@id='artlist-action-pagesize' and @title='24 per Page']//option[@value='48']")));
	
	}
}
