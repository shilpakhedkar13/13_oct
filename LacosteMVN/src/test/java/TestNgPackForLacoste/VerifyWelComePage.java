package TestNgPackForLacoste;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BrowserSetup.Base;
import Utils.Utility;
import page.MainPage;
import page.WelComePage;


public class VerifyWelComePage {
	WebDriver driver;
	WelComePage welcompage;
	MainPage mainpage;
	String testID;
		
	
	@Parameters("browser")
	@BeforeTest
	public void openBrowser(String BrowserName) {
		System.out.println("Before Test");
		if(BrowserName.equals("Chrome")) {
			//System.setProperty("webdriver.chrome.driver","C:\\Users\\Shilpa Khedkar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = Base.openChromeBrowser();
			}
		
		if(BrowserName.equals("Edge")) {
			//System.setProperty("webdriver.edge.driver", "C:\\Users\\Shilpa Khedkar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
		   driver = Base.openEdgeBrowser();
		}
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
}
	
	@BeforeClass
	public void OpenBrowser() {
	System.out.println("Before Class");
//    WelComePage welcompage = new WelComePage(driver);
//	MainPage mainpage = new MainPage(driver);
	 
    }
	
	@BeforeMethod
	public void GoTOWelComePage() throws InterruptedException {
		System.out.println("Before Method");
		driver.get("https://www.lacoste.in");
		Thread.sleep(4000);
		WelComePage welcompage = new WelComePage(driver);
		welcompage.ClickOnForHerButton();
	}	
	
	@Test
	public void VerifyForHerButtonOnWelComePage() throws InterruptedException {
	 testID = "T001";
	System.out.println("Test 1");
	Thread.sleep(2000); 
	MainPage mainpage = new MainPage(driver);
	String ExpectedURL = mainpage.GetURLofMainPage();
	String ActualURL = "https://www.lacoste.in/shop-by-category/clothing/sweatshirt/women-sweatshirt.html";
	Assert.assertEquals(ActualURL, ExpectedURL);
//	if(ExpectedURL.equals(ActualURL))
//	{
//		System.out.println("PASSED");
//	}
//	else
//	{
//		System.out.println("FAILED");
//	}
 }
	
	
	@AfterMethod
	public void GoToMainPage(ITestResult result) throws IOException {
		System.out.println("After Method");
		if (ITestResult.FAILURE==result.getStatus())
		{
			Utility.TakeScreenShot(driver, testID);
		}
	}
	
	
	@AfterClass()
	public void OpenMainPage() {
		System.out.println("After Class");
	}
	
	@AfterTest
	public void ClosedBrowser() {
		System.out.println("After Test");
		driver.quit();
		driver=null;
		System.gc();
	}
}

