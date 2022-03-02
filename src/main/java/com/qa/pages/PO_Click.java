package com.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_Click {
	
	WebDriver driver;
	
	public PO_Click(WebDriver driver) {
		this.driver=driver;
	}


	private By allbutton = By.id("nav-hamburger-menu");
	private By bestsellersbutton = By.linkText("Best Sellers");
	
	public WebElement allButtonMethod()	{
		return driver.findElement(allbutton);
	}
	
	public WebElement besesellermethod() 	{
		return driver.findElement(bestsellersbutton);
	}
}
