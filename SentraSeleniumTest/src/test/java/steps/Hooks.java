package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.BasePage;

public class Hooks {

    @Before
    public void setUp() {
        new BasePage();
    }

    @After
    public void tearDown() {
        BasePage.closeBrowser();
    }
}
