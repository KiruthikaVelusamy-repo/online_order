package amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.AbstractComponents.AbstractComponents;

public class AddToCart extends AbstractComponents {
	WebDriver driver;

	public AddToCart(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement quantityDropdown = driver.findElement(By.id("quantity"));
	@FindBy(id = "quantity")
	WebElement quantityDropdown;

	// WebElement noOfQuantity =
	// driver.findElement(By.xpath(".//*[@id='quantity_1']"));
	@FindBy(xpath = ".//*[@id='quantity_1']")
	WebElement noOfQuantity;

	// WebElement addToCart=driver.findElement(By.id("add-to-cart-button"));
	@FindBy(id = "add-to-cart-button")
	WebElement addToCart;

	// WebElement msgSuccess =
	// driver.findElement(By.cssSelector("div[id*='MSG_SUCCESS'] h1"));
	@FindBy(css = "div[id*='MSG_SUCCESS'] h1")
	WebElement msgSuccess;

	public void addItemToBasket() {
		scrollBy(0, 500);
		scrollToElementAndClick(quantityDropdown);
		scrollToElementAndClick(noOfQuantity);
		addToCart.click();

	}

	public String verifyItemAddedMessage() {
		String itemAddedMessage = msgSuccess.getText();
		return itemAddedMessage;
	}

}
