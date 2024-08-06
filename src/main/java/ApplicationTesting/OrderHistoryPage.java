package ApplicationTesting;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderHistoryPage extends AbstractComponents {
	
	WebDriver driver;
	WebDriverWait wait;
	
	 public OrderHistoryPage(WebDriver driver,WebDriverWait wait ) {
	
		super(driver, wait);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(xpath="//tbody/tr/td[3]")
	List<WebElement> itemsAdded;

public Boolean verifyItemAdded(String productName) {
	
	Boolean match =itemsAdded.stream().anyMatch(cartProduct->cartProduct.getText().equalsIgnoreCase(productName));
	return match;
	
	}

}
