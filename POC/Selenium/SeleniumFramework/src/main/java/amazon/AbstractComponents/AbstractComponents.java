package amazon.AbstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AbstractComponents {

	WebDriver driver;
	

	public AbstractComponents(WebDriver driver) {
		this.driver = driver;
	}

	public void scrollBy(int x, int y) {
		// TODO Auto-generated method stub
		// js.executeScript("window.scrollBy({x},{y})");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(arguments[0],arguments[1]);", x, y);

	}

	public void scrollToElementAndClick(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	public void moveToElementAndClick(WebElement element) {
	Actions action = new Actions(driver);
    action.moveToElement(element).click().perform();
	}
	
	public void scrollToElement(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", element);
	}
	
	public void scrollToBottomOfPage() {
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	public void waitForElementToAppear(By findBy) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@data-cy='title-recipe']/h2/a/span"));
		// wait.until(ExpectedConditions.visibilityOfElementLocated(element));

	}

}
