package LandingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import ApplicationTesting.AbstractComponents;
import ApplicationTesting.ProductCatalogPage;

public class LandingPage extends AbstractComponents {
	
	WebDriver driver;
	WebDriverWait wait;
	public LandingPage(WebDriver driver, WebDriverWait wait) {
		
		super(driver,wait);
	this.driver=driver;
	
	PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="userEmail")
	WebElement userName;
	
	@FindBy(id="userPassword")
	WebElement userPassword;
	
	@FindBy(id="login")
	WebElement logInButton;
	
	@FindBy(css="[class*='flyInOut']")
	WebElement errorMessage;
	
	//div[aria-label='Incorrect email or password.']
	////div[@class='ng-tns-c4-2 ng-star-inserted ng-trigger ng-trigger-flyInOut ngx-toastr toast-error']
	
	public void goTO() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	public ProductCatalogPage applicationLogIn(String email, String password) {
		userName.sendKeys(email);
		userPassword.sendKeys(password);
		logInButton.click();
		ProductCatalogPage cataloguePage= new ProductCatalogPage(driver, wait);
		return cataloguePage;
		
	}
	//driver.findElement(By.id("userEmail")).sendKeys("prithiv@gmail.com");
	//driver.findElement(By.id("userPassword")).sendKeys("Prithiv@24");
	//driver.findElement(By.id("login")).click();
	

}
