package amazon.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import amazon.AbstractComponents.AbstractComponents;

public class LandingPage extends AbstractComponents {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// initialization
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	// WebElement cookies =
	// driver.findElement(By.xpath("//button[text()='Decline']"));
	@FindBy(xpath = "//button[text()='Decline']")
	WebElement cookies;

	// WebElement signInLink = driver.findElement(By.xpath("//Span[text()='Hello,
	// sign in']"));
	@FindBy(xpath = "//Span[text()='Hello, sign in']")
	WebElement signInLink;

	// WebElement userEmail = driver.findElement(By.id("ap_email"));
	@FindBy(id = "ap_email")
	WebElement userEmail;

	// WebElement continueButton = driver.findElement(By.id("continue"));
	@FindBy(id = "continue")
	WebElement continueButton;

	// WebElement userPassword = driver.findElement(By.id("ap_password"));
	@FindBy(id = "ap_password")
	WebElement userPassword;

	// WebElement signInButton = driver.findElement(By.id("signInSubmit"));
	@FindBy(id = "signInSubmit")
	WebElement signInButton;

	@FindBy(xpath = "//div[@class='a-alert-content']/ul/li/span")
	WebElement alertErrorMessage;

	@FindBy(xpath = "//a[@id='nav-cart'or contains(@href,'nav_cart')]")
	WebElement navCart;

	public void goTo() {
		driver.get("https://www.amazon.co.uk/");
		driver.manage().window().maximize();
	}

	public ProductCatalog signIn(String email, String password) {
		cookies.click();
		signInLink.click();
		userEmail.sendKeys(email);
		continueButton.click();
		userPassword.sendKeys(password);
		signInButton.click();

		ProductCatalog productCatalog = new ProductCatalog(driver);
		return productCatalog;
	}

	public String getErrorMessage() {
		return alertErrorMessage.getText();
	}

	public ProductCheckOut navCart() {

		try {
			navCart.click();
		} catch (Exception e) {
			e.printStackTrace();
		}
		ProductCheckOut productCheckOut = new ProductCheckOut(driver);
		return productCheckOut;
	}

}
