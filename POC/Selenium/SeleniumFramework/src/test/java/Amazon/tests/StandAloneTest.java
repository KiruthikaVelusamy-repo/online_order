package Amazon.tests;

import java.io.IOException;
import java.util.HashMap;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Amazon.TestComponents.BaseTest;
import amazon.pageobjects.AddToCart;
import amazon.pageobjects.OrderSummary;
import amazon.pageobjects.ProductCatalog;
import amazon.pageobjects.ProductCheckOut;
import amazon.pageobjects.ProductView;

public class StandAloneTest extends BaseTest {

	@Test(dataProvider= "getData")
	public void addItemToCart(HashMap<String,String> input) throws IOException {
		
		ProductCatalog productCatalog = landingPage.signIn(input.get("username"), input.get("password"));
		ProductView productView = productCatalog.selectProduct();
		AddToCart addToCart = productView.getProductByName(input.get("bookName"));
		addToCart.addItemToBasket();
		String itemAddedMessage = addToCart.verifyItemAddedMessage();
		Assert.assertEquals(itemAddedMessage, "Added to Basket");

	}

	@Test(dependsOnMethods = { "addItemToCart" })
	public void placeOrder() {
		landingPage.signIn("Kiruthikavelusamy.in@gmail.com", "Test@123");
		ProductCheckOut productCheckOut = landingPage.navCart();
		OrderSummary orderSummary = productCheckOut.checkOut();
		String[] deliveryDate = orderSummary.orderDetails();
		System.out.println("Delivery Date : " + deliveryDate[0] + " " + deliveryDate[1] + " " + deliveryDate[2]);
	}
	
	@DataProvider
	public Object[][] getData()
	{
		HashMap<String,String> map=new HashMap<String, String>();
		map.put("username", "Kiruthikavelusamy.in@gmail.com");
		map.put("password" ,"Test@123");
		map.put("bookName", "Test Automation using Selenium WebDriver with Java");
		return new Object[][] {{map}};
	}
	

}
