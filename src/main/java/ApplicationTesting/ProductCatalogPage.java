package ApplicationTesting;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProductCatalogPage extends AbstractComponents{

	WebDriver driver;

	public ProductCatalogPage(WebDriver driver, WebDriverWait wait) {

		super(driver,wait);

		this.driver=driver;
		PageFactory.initElements(driver, this);


	}

	//driver.findElements(By.cssSelector(".mb-3"));
	@FindBy(css=".mb-3")
	List<WebElement> products;
	By productsBy = By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");

	By toasterContainer=By.cssSelector("#toast-container");
	By loadIcon=By.cssSelector(".ng-animating");
	public List<WebElement> getProducts(){
		waitElementToAppear(productsBy);
		return products;

	}

	public WebElement getProductName(String productName) {

		WebElement	prod=products.stream().filter(product->product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		
		return prod;
	}

	public CartPage addProductToCart(String productName){

		WebElement prod=getProductName(productName);
		prod.findElement(addToCart).click();

		//waitElementToAppear(toasterContainer);
	//	waitElementToDisaappear(loadIcon);
		 CartPage cart= new CartPage(driver, wait);
		 return cart;
	}
}
