package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WelComePage {
	    //Variable Declaration
	
	@FindBy(xpath = "//li[@class='l-hmargin--small l-vmargin--medium']//a")
	  private WebElement ForHer ;
	
	
	
	
	WebDriver driver ;
	  
       // Variable Initialization

    public WelComePage(WebDriver driver) {
	    PageFactory.initElements(driver, this);
	    this.driver = driver ;
	  
 }
	
           //Variable Use
	
    public void ClickOnForHerButton() {
    	ForHer.click();
    	
    }
    
    
    
    
    

}
