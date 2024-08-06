package ApplicationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckOutPage extends AbstractComponents {

	WebDriver driver;

	public CheckOutPage(WebDriver driver, WebDriverWait wait) {
		super(driver, wait);
		PageFactory.initElements(driver, this);

	}

	@FindBy(css="input[placeholder='Select Country']")
	WebElement selcountry;

	@FindBy(xpath=("(//button[contains(@class,'ta-item')])[2]"))
	WebElement selectedCountry;
	@FindBy(css="a[class*=action__submit]")	
	WebElement submit;


	By allCountry=By.cssSelector(".ta-results");
	public void selectCountry(String country) {
		selcountry.sendKeys(country);
		//waitElementToAppear(allCountry);
		selectedCountry.click();
		

	}
	
	public ConfirmationPage clickonSubmit() {
		submit.click();
		 ConfirmationPage confirmationMsg= new ConfirmationPage(driver, wait);
		return confirmationMsg;
	}





}
