package ApplicationTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConfirmationPage extends AbstractComponents{

	WebDriver driver;

	public  ConfirmationPage(WebDriver driver, WebDriverWait wait) {

		super(driver, wait);
		PageFactory.initElements(driver, this);

	}

	@FindBy(css=".hero-primary")
	WebElement confirmMessage;


	public String getConfirmationMessage() {
		return confirmMessage.getText();
		
		

	}
}
