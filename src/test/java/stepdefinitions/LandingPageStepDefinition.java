package stepdefinitions;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public TestContextSetup testContextSetup;
	public LandingPage landingPage;

	public LandingPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingpage();
	}

	@Given("User is on GreenCart Landing Page")
	public void user_is_on_green_cart_landing_page() {
		Assert.assertTrue(landingPage.getTitleLandingOage().contains("GreenKart"));
	}

	@When("^user seached with shortname (.+) and extracted actual name of product$")
	public void user_seached_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		LandingPage landingpage = testContextSetup.pageObjectManager.getLandingpage();
		landingpage.searchItem(shortName);
		Thread.sleep(2000);
		testContextSetup.landingPageProductName = landingpage.getProductName().split("-")[0].trim();
		System.out.println(landingPageProductName + "is extratced from Home Page");
	}

	@When("Added {string} items of the selected product to cart")
	public void added_items_of_the_selected_product_to_cart(String quantity) {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
	}

}
