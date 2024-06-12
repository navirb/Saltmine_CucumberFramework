package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	private By cartBag = By.xpath("//img[@alt='Cart']");
	private By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	private By promoBtn = By.cssSelector(".promoBtn");
	private By placeOrder = By.xpath("//button[normalize-space()='Place Order']");

	public void checkOutItems() {
		driver.findElement(cartBag).click();
		driver.findElement(checkOutButton).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofMillis(20000));
		wait.until(ExpectedConditions.visibilityOfElementLocated(placeOrder));
	}

	public boolean verifyPromoBtn() {
		return driver.findElement(promoBtn).isDisplayed();
	}

	public boolean verifyPlaceOrder() {
		return driver.findElement(placeOrder).isDisplayed();
	}

}
