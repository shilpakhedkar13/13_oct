package PopupPack;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignUpPopup {
	
	   //Variable Declaration
	
  @FindBy(xpath = "(//img[@data-webpconverted='1'])[54]")
	private WebElement SignUp ;
  
  @FindBy(xpath = "//span[text()='Create an account']")
 	private WebElement  CreatAccount ;
		
		
		WebDriver driver ;
		  
	       // Variable Initialization

 public SignUpPopup(WebDriver driver) {
   PageFactory.initElements(driver, this);
   this.driver = driver ;
		  
	 }
		
	           //Variable Use
		
	   // Actions action;
 public void MoveOnSignUpTab() {
	 Actions action = new Actions (driver);
	 action.moveToElement(SignUp).perform();
	 JavascriptExecutor bs=(JavascriptExecutor)driver;
	 bs.executeScript("window.scrollBy(0,500)");
   }
	
 public void  ClickOnCreatAccount () {
	 CreatAccount.click();
	}

}
