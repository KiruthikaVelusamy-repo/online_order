package amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.AbstractComponents.AbstractComponents;

public class OrderSummary extends AbstractComponents {

	WebDriver driver;

	public OrderSummary(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement checkOut= driver.findElement(By.name("proceedToRetailCheckout"));
	@FindBy(name = "proceedToRetailCheckout")
	WebElement checkOut;

	@FindBy(xpath = "//span[@data-field='promiseday']")
	WebElement promiseDay;

	@FindBy(xpath = "//span[@data-field='promisemonth']")
	WebElement promiseMonth;

	@FindBy(xpath = "//span[@data-field='promiseyear']")
	WebElement promiseYear;

	/*
	 * @FindBy(xpath=
	 * "//img[@alt='\" + bookName + \"']/parent::div/following-sibling::div[1]")
	 * WebElement productName;
	 * 
	 * By productNameBy = By.xpath("//img[@alt='" + bookName +
	 * "']/parent::div/following-sibling::div[1]");
	 */

	public String[] orderDetails() {

		String date = promiseDay.getText();
		String month = promiseMonth.getText();
		String year = promiseYear.getText();
		String[] deliveryDate = { date, month, year };
		// waitForElementToAppear(productNameBy);
		// String orderedItem = productName.getText();
		return deliveryDate;

	}

}