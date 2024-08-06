package ApplicationTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends AbstractComponents {
	WebDriver driver;
	WebDriverWait wait;
	
	public CartPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(css=".cartSection h")
	List<WebElement> cartProducts;

public Boolean verifyItem(String productName) {
	
	Boolean match =cartProducts.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	return match;
	
	}
	
}


