package Amazon.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import Amazon.TestComponents.BaseTest;

public class ErrorValidations extends BaseTest{

	@Test
	public void placeOrder() throws IOException
	{
		
		landingPage.signIn("Kiruthikavelusamy.in@gmail.com", "Test");
		Assert.assertEquals(landingPage.getErrorMessage(), "Your password is incorrect");
	}
}
