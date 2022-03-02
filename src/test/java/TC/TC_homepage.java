package TC;

import com.qa.resources.Baseclass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import org.testng.annotations.Parameters;

import com.qa.pages.PO_Click;

import java.util.logging.LogManager;
import java.util.logging.Logger;

public class TC_homepage {
	public static Logger log= LogManager.getLogManager().getLogger(Baseclass.class.getName());
	
	WebDriver driver;
	
	@Test
	@Parameters({"browser","url"})

	public void findTheElement(String browser,String url)
	
	{
		System.setProperty("webdriver.chrome.driver", "D://work-spaces/java/CJ/Java/src/main/java/Drivers/chromedriver.exe");

		//log.info("system property is done");
		driver=Baseclass.Utils(browser,url);
		
		PO_Click p=new PO_Click(driver);
		p.allButtonMethod().click();

		//log.info("all button is clicked");
		// p.besesellermethod().click();

	}
}
