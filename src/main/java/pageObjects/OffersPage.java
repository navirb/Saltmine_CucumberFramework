package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	public WebDriver driver;

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("tbody tr td:nth-child(1)");
	private By firstButton = By.xpath("//a[@aria-label='First']");
	

	public By getFirstButton() {
		return firstButton;
	}

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}

	public void getSearchText() {
		driver.findElement(search).getText();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}


}
