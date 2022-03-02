package com.qa.resources;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Baseclass {
	
	public static WebDriver Utils(String type,String url){
		// TODO Auto-generated method stub
		WebDriver driver=null;
		if(type.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(type.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}else if(type.equalsIgnoreCase("safari"))
		{
			driver=new SafariDriver();
		}
		
		driver.get(url);
		
		return driver;
	}

	
	}


