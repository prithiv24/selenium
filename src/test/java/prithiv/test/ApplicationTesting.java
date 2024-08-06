package prithiv.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ApplicationTesting.CartPage;
import ApplicationTesting.CheckOutPage;
import ApplicationTesting.ConfirmationPage;
import ApplicationTesting.OrderHistoryPage;
import ApplicationTesting.ProductCatalogPage;
import io.github.bonigarcia.wdm.WebDriverManager;
import prithiv.testcomponents.BaseTest;

public class ApplicationTesting extends BaseTest {

	@Test(dataProvider = "getData")
	public  void ApplicationTesting(HashMap<String,String> input) throws InterruptedException, IOException {
		String prodctNAME="ADIDAS ORIGINAL";
		WebDriverManager.chromedriver().setup();



		ProductCatalogPage cataloguePage= landingPage.applicationLogIn(input.get("email"), input.get("password"));

		cataloguePage.getProductName(input.get("product"));
		cataloguePage.addProductToCart(input.get("product"));
		Thread.sleep(2000);
		CartPage cart=  cataloguePage.goToCart();

		Boolean match =cart.verifyItem(input.get("product"));

		CheckOutPage checkOut=cart.checkOutPage();
		//	Assert.assertTrue(match);


		checkOut.selectCountry("india");
		ConfirmationPage confirmationMsg= checkOut.clickonSubmit();
		Thread.sleep(2000);

		String confirmationMessage=confirmationMsg.getConfirmationMessage();

		//Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));


	}
	@Test(dependsOnMethods= {"ApplicationTesting"})
	public void getOrderItem() {
		OrderHistoryPage orderHistoryPage=	landingPage.goToOderHistory();
		Boolean verifyItemAdded = orderHistoryPage.verifyItemAdded("ADIDAS ORIGINAL");
		Assert.assertTrue(verifyItemAdded);

	}
	/*	@DataProvider
	public Object [] [] getData() {

 return new Object [] [] {{"prithiv@gmail.com","Prithiv@24"}, {"prithiv@gmail.com", "Prithiv@24"} };



	}*/

	

	@DataProvider
	public Object [] [] getData() throws IOException {

		/*HashMap<String, String> map = new HashMap<String, String>();
		map.put("email", "prithiv@gmail.com");
		map.put("password", "Prithiv@2");
		map.put("product", "ADIDAS ORIGINAL");

		HashMap<String, String> map1 = new HashMap<String, String>();
		map1.put("email", "prithiv@gmail.com");
		map1.put("password", "Prithiv@2");
		map1.put("product", "ZARA COAT 3");*/

		List<HashMap<String, String>> jsonDataToMap = getJsonDataToMap(System.getProperty("user.dir")+"\\src\\main\\java\\ApplicationTesting\\purchaseorder.json");

		return new Object [] [] {{jsonDataToMap.get(0)}, {jsonDataToMap.get(1)} };



	}
}
