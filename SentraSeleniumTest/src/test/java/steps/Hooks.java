package steps;

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
        try {
            Thread.sleep(2000);
            BasePage.takeANewScreenshot(scenario);
            BasePage.closeBrowser();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
