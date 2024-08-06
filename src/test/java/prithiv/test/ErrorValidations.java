package prithiv.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import prithiv.testcomponents.BaseTest;
import prithiv.testcomponents.Retry;

public class ErrorValidations extends BaseTest {
	
	@Test(retryAnalyzer = Retry.class)
	public void errorValidations() {
		landingPage.applicationLogIn("prithiv@gmail.com", "Pithiv@@24");
		Assert.assertEquals(landingPage.getErrorMessage(), "Incorrect email or password");
		
	}

}
