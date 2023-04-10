package page;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCartPage {
	
	   //Variable Declaration
	
	  @FindBy(xpath = "//span[@id='option-label-size-138']")
	  private WebElement DisplaySize ;
		
	  @FindBy(xpath = "(//div[contains(@id,'tion-label-si')])[1]")
	  private WebElement SizeGuide;
	  
	  @FindBy(xpath = "//button[@id='product-addtocart-button']//span")
	  private WebElement AddToCartButton ;
	  
	  @FindBy(xpath = "(//img[@data-webpconverted='1'])[57]")
	  private WebElement MyShoppingBag;

	  @FindBy(xpath = "//h1[@class='page-title']//span")
	  private WebElement TittleOfAddToCartPage;

	  
	  WebDriver driver ;
	  
      // Variable Initialization
 
 public AddToCartPage(WebDriver driver) {
	  PageFactory.initElements(driver, this);
	  this.driver = driver ;
	  
   }
	  
      // Variable Use 
	  
public void  ClickOnDisplaySize() {
	DisplaySize.click();
}
	  
public void  ClickOnSizeGuide() {
	SizeGuide.click();
}
	  
public void  ClickOnAddToCartButton() {
	 JavascriptExecutor js=(JavascriptExecutor)driver;
	 js.executeScript("window.scrollBy(0,300)");
	 AddToCartButton.click();
}    
	  
public void  ClickOnMyShoppingBag() {
	MyShoppingBag.click();
	driver.navigate().back();
}  

public String GetTittleOfAddToCartPage() {
	String Text = TittleOfAddToCartPage.getText();
	return Text;
}
 
}
