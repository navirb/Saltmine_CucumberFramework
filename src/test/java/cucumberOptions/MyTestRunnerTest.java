package cucumberOptions;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/java/features", 
glue = "stepdefinitions", 
stepNotifications = true,
monochrome = true, 
plugin = {"pretty", "html:target/cucumber-reports", "json:target/cucumber.json"}
,tags="@OffersPage"
)
public class MyTestRunnerTest {

}
