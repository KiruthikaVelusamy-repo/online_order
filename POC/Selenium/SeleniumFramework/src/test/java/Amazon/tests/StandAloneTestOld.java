package Amazon.tests;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import amazon.pageobjects.LandingPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StandAloneTestOld {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String bookName = "Test Automation using Selenium WebDriver with Java";
		driver.get("https://www.amazon.co.uk/");
		driver.manage().window().maximize();
		// ChromeOptions options = new ChromeOptions();
		// options.setExperimentalOption("excludeSwitches",Arrays.asList("disable-popup-blocking"));
		LandingPage landingPage= new LandingPage(driver);
		driver.findElement(By.xpath("//button[text()='Decline']")).click();
		driver.findElement(By.xpath("//Span[text()='Hello, sign in']")).click();
		driver.findElement(By.id("ap_email")).sendKeys("Kiruthikavelusamy.in@gmail.com");
		driver.findElement(By.id("continue")).click();
		driver.findElement(By.id("ap_password")).sendKeys("Test@123");
		driver.findElement(By.id("signInSubmit")).click();
		driver.findElement(By.id("nav-hamburger-menu")).click();
		// System.out.println(driver.findElement(By.className("hmenu-item")).getText());
		WebElement scrollToBook = driver.findElement(By.xpath("//div[text()='shop by department']"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", scrollToBook);
		driver.findElement(By.xpath("//a[@class='hmenu-item']/div[text()='Books']")).click();
		WebElement b1 = driver.findElement(By.xpath("//div[@id='hmenu-content']/ul/li/a[text()='Books']"));
		js.executeScript("arguments[0].click();", b1);
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys(bookName);
		driver.findElement(By.id("nav-search-submit-button")).click();
		List<WebElement> searchBooks = driver.findElements(By.xpath("//div[@data-cy='title-recipe']/h2/a/span"));
		/*for (WebElement s : searchBooks) {
			if (s.getText().equalsIgnoreCase(bookName)) {
				s.click();
				break;
			}
		}*/
		WebElement Srchbook = searchBooks.stream().filter(b -> b.getText().equals(bookName)).findFirst().orElse(null);
		Srchbook.click();
		js.executeScript("window.scrollBy(0,500)");
		// WebElement quantity=driver.findElement(By.id("quantity"));
		// Select dropdown= new Select(quantity);
		// dropdown.selectByVisibleText("2 ");
		js.executeScript("arguments[0].click();", driver.findElement(By.id("quantity")));
		js.executeScript("arguments[0].click();", driver.findElement(By.xpath(".//*[@id='quantity_1']")));
		driver.findElement(By.id("add-to-cart-button")).click();
		String itemAddedMessage = driver.findElement(By.cssSelector("div[id*='MSG_SUCCESS'] h1")).getText();
		Assert.assertEquals(itemAddedMessage, "Added to Basket");
		driver.findElement(By.name("proceedToRetailCheckout")).click();
		driver.findElement(By.xpath("//input[@data-testid='Address_selectShipToThisAddress']")).click();
		// driver.findElement(By.xpath("//input[@data-testid='Address_selectBillToThisAddress']")).click();
		driver.findElement(By.cssSelector("input[name*='SetPaymentPlanSelectContinueEvent']")).click();
		WebElement itemsDelivery = driver.findElement(By.xpath("//*[contains(.,'Items and delivery')]"));
		js.executeScript("arguments[0].scrollIntoView(true);", itemsDelivery);
		String date = driver.findElement(By.xpath("//span[@data-field='promiseday']")).getText();
		String month = driver.findElement(By.xpath("//span[@data-field='promisemonth']")).getText();
		String year = driver.findElement(By.xpath("//span[@data-field='promiseyear']")).getText();
		WebElement orderedItem = driver
				.findElement(By.xpath("//img[@alt='" + bookName + "']/parent::div/following-sibling::div[1]"));
		System.out.println("Product : " + orderedItem.getText());
		System.out.println("Delivery Date : " + date + " " + month + " " + year);

	}
}
