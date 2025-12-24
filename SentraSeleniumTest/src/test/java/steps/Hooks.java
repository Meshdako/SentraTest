package steps;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import pages.BasePage;

public class Hooks {

    @Before
    public void setUp() {
        new BasePage();
        
    }

    @After
    public void tearDown(Scenario scenario) {
        BasePage.takeANewScreenshot(scenario);
        BasePage.closeBrowser();
    }
}
