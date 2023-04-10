package TestNgPackForLacoste;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import BrowserSetup.Base;
import page.MainPage;
import page.WelComePage;

public class VerifyMainPage {
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
			System.setProperty("webdriver.edge.driver", "C:\\Users\\Shilpa Khedkar\\Downloads\\edgedriver_win64\\msedgedriver.exe");
			driver = Base.openEdgeBrowser();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@BeforeClass
	public void OpenBrowser() {
		 System.out.println("Before Class");
//		 WelComePage welcompage = new WelComePage(driver);
//		MainPage mainpage = new MainPage(driver);
		
	}
	
	@BeforeMethod
	public void GoToMainPage() throws InterruptedException {
		System.out.println("Before Method");
		driver.get("https://www.lacoste.in");
		Thread.sleep(4000);
		WelComePage welcompage = new WelComePage(driver);
		welcompage.ClickOnForHerButton();
		
	}
	
	@Test
	public void VerifyTittlePresentOnTheMainPage() throws InterruptedException {
	testID = "T002";
	System.out.println("Test 1");	
	Thread.sleep(3000);
	MainPage mainpage = new MainPage(driver);
	String ExpectedTittle =	mainpage.GetTittleOnMainPage();
	String ActualTittle = "All Sweatshirts";
	
	if(ExpectedTittle.equals(ActualTittle))
	{
		System.out.println("Passed");
	}
	else
	{
		System.out.println("Failed");
	}
  }
	
	@AfterMethod
	public void GoToAddToCartPage() {
		System.out.println("After Method");
	}
	
	@AfterClass
	public void OpenAddToCartPage() {
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

