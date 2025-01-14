package amazon.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.AbstractComponents.AbstractComponents;

public class ProductView extends AbstractComponents{

	WebDriver driver;


	public ProductView(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

		// WebElement searchText = driver.findElement(By.id("twotabsearchtextbox"));
		@FindBy(id = "twotabsearchtextbox")
		WebElement searchText;

		// WebElement searchSubmit =
		// driver.findElement(By.id("nav-search-submit-button"));
		@FindBy(id = "nav-search-submit-button")
		WebElement searchSubmit;

		// List<WebElement> listOfBooks =
		// driver.findElements(By.xpath("//div[@data-cy='title-recipe']/h2/a/span"));
		@FindBy(xpath = "//div[@data-cy='title-recipe']/h2/a/span")
		List<WebElement> listOfBooks;

		By listOfBooksBy = By.xpath("//div[@data-cy='title-recipe']/h2/a/span");

		

		public List<WebElement> getProductList(String bookName) {
			searchText.sendKeys(bookName);
			searchSubmit.click();
			//waitForElementToAppear(listOfBooksBy);
			return listOfBooks;
		}

		public AddToCart getProductByName(String bookName) {
			/*
			 * for (WebElement b : listOfBooks) { if
			 * (b.getText().equalsIgnoreCase(bookName)) { b.click(); break; } }
			 */
			WebElement Srchbook = getProductList(bookName).stream().filter(b -> b.getText().equals(bookName)).findFirst().orElse(null);
			Srchbook.click();
			AddToCart addToCart = new AddToCart(driver);
			return addToCart;

		}

		
}
