package TestPack;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import PopupPack.SignUpPopup;
import page.AddToCartPage;
import page.MainPage;
import page.WelComePage;

public class TestClass {
	public static void main(String[] args) throws InterruptedException {
		
System.setProperty("webdriver.chrome.driver","C:\\Users\\Shilpa Khedkar\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");

   WebDriver driver = new ChromeDriver();
			
   driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
   driver.get("https://www.lacoste.in");		
		
	Thread.sleep(4000);
	page.WelComePage welcompage = new WelComePage(driver);
	welcompage.ClickOnForHerButton();
	
	Thread.sleep(7000);
	MainPage mainpage = new MainPage(driver);
	mainpage.GetTittleOnMainPage();
	mainpage.SearchItem();
	Thread.sleep(7000);
	mainpage.ClickOnItem();	
	
	Thread.sleep(4000);
	AddToCartPage addtocartpage = new AddToCartPage(driver);
	addtocartpage.ClickOnDisplaySize();
	addtocartpage.ClickOnSizeGuide();
	Thread.sleep(4000);
	addtocartpage.ClickOnAddToCartButton();
	Thread.sleep(4000);
	addtocartpage.ClickOnMyShoppingBag();
	addtocartpage.GetTittleOfAddToCartPage();
	
	Thread.sleep(4000);
	SignUpPopup signuppopup = new SignUpPopup(driver);
	signuppopup.MoveOnSignUpTab();
	signuppopup.ClickOnCreatAccount();
		
	}

}
