package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
	
	
	 @FindBy(xpath = "//input[@id='search-input']")
	  private WebElement SearchBox ;
		
	  @FindBy(xpath = "(//img[@class='product-image-photo'])[2]")
	  private WebElement SelectItem ;
	  
	  @FindBy(xpath = "//h1[@class='title--xlarge l-vmargin--medium']")
	  private WebElement TittleOnMainPage ;
	  
	  WebDriver driver ;
	  
      // Variable Initialization
 
 public MainPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	  this.driver = driver ;
	  
   }
   
         // Variable Use
 
 public void SearchItem() {
	 SearchBox.sendKeys("Women polo");
	 
 }
 
 public void ClickOnItem() {
	 SelectItem.click();
 }
 
 public String GetTittleOnMainPage() {
	String s = TittleOnMainPage.getText();
	return s;
 }
 
 public String GetURLofMainPage() {
	String url = driver.getCurrentUrl();
	return url;
		
	 }
 

}
