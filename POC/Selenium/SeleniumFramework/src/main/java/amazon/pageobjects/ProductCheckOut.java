package amazon.pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.AbstractComponents.AbstractComponents;

public class ProductCheckOut extends AbstractComponents {

	WebDriver driver;

	public ProductCheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement checkOut= driver.findElement(By.name("proceedToRetailCheckout"));
	@FindBy(name = "proceedToRetailCheckout")
	WebElement checkOut;

	// WebElement shippingAddress=
	// driver.findElement(By.xpath("//input[@data-testid='Address_selectShipToThisAddress']"));
	@FindBy(xpath = "//input[@data-testid='Address_selectShipToThisAddress']")
	WebElement shippingAddress;

	// WebElement setPaymentPlan=
	// driver.findElement(By.cssSelector("input[name*='SetPaymentPlanSelectContinueEvent']"));
	@FindBy(css = "input[name*='SetPaymentPlanSelectContinueEvent']")
	WebElement setPaymentPlan;

	// WebElement itemsAndDelivery=
	// driver.findElement(By.xpath("//*[contains(.,'Items and delivery')]"));
	@FindBy(xpath = "//*[contains(.,'Items and delivery')]")
	WebElement itemsAndDelivery;

	// @FindBy(xpath = "//a[@id='nav-cart'and
	// @href='/gp/cart/view.html?ref_=nav_cart']/div[@id='nav-cart-count-container']")
	// WebElement navCart;

	// @FindBy(xpath = "//*[contains(@class,'nav-cart-icon')]")
	// WebElement navCart;

	public OrderSummary checkOut() {
		// scrollToElementAndClick(navCart);
		// JavascriptExecutor executor = (JavascriptExecutor)driver;
		//executor.executeScript("arguments[0].click();", navCart);
		checkOut.click();
		shippingAddress.click();
		setPaymentPlan.click();
		// scrollToElement(itemsAndDelivery);
		// scrollBy(0, 500);
		scrollToBottomOfPage();
		OrderSummary orderSummary = new OrderSummary(driver);
		return orderSummary;

	}

}