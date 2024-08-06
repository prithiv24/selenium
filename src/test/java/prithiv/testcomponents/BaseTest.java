package prithiv.testcomponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import LandingPage.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {

	public  WebDriver driver;
	public WebDriverWait wait;
	public LandingPage landingPage;

	public  WebDriver initializeDriver() throws IOException {

		Properties prop= new Properties();

		FileInputStream fis= new FileInputStream(
				System.getProperty("user.dir")+"\\src\\main\\java\\Resouces\\GlobalData.properties");

		prop.load(fis);
		String browserName=prop.getProperty("browser");

		if(browserName.equalsIgnoreCase("chrome")){

			WebDriverManager.chromedriver().setup();

			driver= new ChromeDriver();
		}

		else if (browserName.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver= new FirefoxDriver();


		}
		else if (browserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver= new EdgeDriver();


		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		return driver;
	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException {

		driver = initializeDriver();
		landingPage= new LandingPage(driver,wait);
		landingPage.goTO();
		return landingPage;

	}
	
	
		public List<HashMap<String, String>> getJsonDataToMap(String filename) throws IOException {
			 //read json to string
					String jsconContent=FileUtils.readFileToString(new File(filename));
					
					//string to map(hashmap) install jackson data build to convert from string to map
					
					ObjectMapper mapper = new ObjectMapper();
					
					List<HashMap<String, String>> data = mapper.readValue(jsconContent, new TypeReference<List<HashMap<String, String>>>() {
					});
					return data;
	}
		public String getScreenshot(String filename, WebDriver driver) throws IOException {

			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			File destination = new File(System.getProperty("user.dir")+"//reports//"+filename+".png");
			FileUtils.copyFile(source, destination);
			return System.getProperty("user.dir")+"//reports//"+filename+".png";
		}
	@AfterMethod
	public void tearDown() {
		driver.close();
	}
}
