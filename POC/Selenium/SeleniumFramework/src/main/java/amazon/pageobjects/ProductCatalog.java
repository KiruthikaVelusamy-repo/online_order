package amazon.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.AbstractComponents.AbstractComponents;

public class ProductCatalog extends AbstractComponents {

	WebDriver driver;

	public ProductCatalog(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement mainMenu= driver.findElement(By.id("nav-hamburger-menu"));
	@FindBy(id = "nav-hamburger-menu")
	WebElement mainMenu;

	// WebElement scrollToBook = driver.findElement(By.xpath("//div[text()='shop by
	// department']"));
	@FindBy(xpath = "//div[text()='shop by department']")
	WebElement scrollToBook;

	// WebElement menuItem =
	// driver.findElement(By.xpath("//a[@class='hmenu-item']/div[text()='Books']"))
	@FindBy(xpath = "//a[@class='hmenu-item']/div[text()='Books']")
	WebElement menuItem;

	// WebElement bookMenu =
	// driver.findElement(By.xpath("//div[@id='hmenu-content']/ul/li/a[text()='Books']"));
	@FindBy(xpath = "//div[@id='hmenu-content']/ul/li/a[text()='Books']")
	WebElement bookMenu;

	By bookMenuBy = By.xpath("//div[@id='hmenu-content']/ul/li/a[text()='Books']");
	
	public ProductView selectProduct() {
		// TODO Auto-generated method stub
		mainMenu.click();
		scrollToElement(scrollToBook);
		menuItem.click();
		waitForElementToAppear(bookMenuBy);
		scrollToElementAndClick(bookMenu);
		ProductView productView= new ProductView(driver);
		return productView;
	}

}
