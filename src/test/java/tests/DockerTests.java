package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class DockerTests {
	
	public WebDriver driver;
	public DesiredCapabilities dc;
	
	@Parameters("browser")
	@BeforeTest
	public void launchBrowser(String browsertype) throws MalformedURLException {
		
		dc = new DesiredCapabilities();
		if(browsertype.equals("chrome")) {
			 
			dc.setBrowserName(BrowserType.CHROME);
			System.out.println("TEST execution started on "+browsertype);
		}
		
		else if(browsertype.equals("firefox")) {
			 
			dc.setBrowserName(BrowserType.FIREFOX);
			System.out.println("TEST execution started on "+browsertype);
		}
		
		else if(browsertype.equals("edge")) {
			
			dc.setBrowserName(BrowserType.EDGE);
			System.out.println("TEST execution started on "+browsertype);
		}
		
		URL url = new URL("http://localhost:4445/wd/hub");
		// give public ipv4 and port number of ec2 hub instance
		//URL url = new URL("http://65.2.169.174:4445");
		
	    driver = new RemoteWebDriver(url,dc);
		
	}
	
	@Test
	public void launchgoogleTest() {
		driver.get("https://www.google.com/");
		
		Assert.assertEquals(driver.getTitle(), "Google");
		
		System.out.println("the title for google is "+driver.getTitle());
	}
	
	@Test
	public void launchfacebookTest() {
		driver.get("https://www.facebook.com/");
		
		Assert.assertEquals(driver.getTitle(), "Facebook – log in or sign up");
		
		System.out.println("the title for Facebook is "+driver.getTitle());
	}
	
	@Test
	public void launchamazonTest() {
		driver.get("https://www.amazon.com/");
		
		Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
		
		System.out.println("the title for Amazon is "+driver.getTitle());
	}
	
//	@Test
//	public void launchflipkart() {
//		driver.get("https://www.flipkart.com/");
//		
//		Assert.assertEquals(driver.getTitle(), "Amazon.com. Spend less. Smile more.");
//		
//		System.out.println("the title for Amazon is "+driver.getTitle());
//	}
	
	@AfterTest
	public void teardown() throws InterruptedException {
		System.out.println("Test case execution ended");
		Thread.sleep(10000);
		driver.quit();
	}

}
