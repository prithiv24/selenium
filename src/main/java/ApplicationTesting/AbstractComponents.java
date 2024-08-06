package ApplicationTesting;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {
	
	WebDriver driver;
	WebDriverWait wait;
	
	public AbstractComponents(WebDriver driver,	WebDriverWait wait) {
		
		this.driver=driver;	
		this.wait = wait;
	}
@FindBy(css="[routerlink*='cart']")
WebElement cart;

@FindBy(css="[routerlink*='myorders']")
WebElement orderHeader;

@FindBy(xpath="(//button[@type='button'])[2]")
WebElement cartButton;
	
	public void waitElementToAppear(By findby) {
	wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
	}
	
	public void waitElementToDisaappear(By findby) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(findby));
		}
	public CartPage goToCart() {
		cart.click();
		 CartPage cart= new CartPage(driver, wait);
		 return cart;
	}
	
	public CheckOutPage checkOutPage() {
		
		cartButton.click();
		 CheckOutPage checkOut= new CheckOutPage(driver, wait);
		 return checkOut;
		
		
	}
	
	public OrderHistoryPage goToOderHistory(){
		
		orderHeader.click();
		
		OrderHistoryPage orderHistoryPage = new OrderHistoryPage(driver,wait);
		return orderHistoryPage;
		
		
		
	}

}
