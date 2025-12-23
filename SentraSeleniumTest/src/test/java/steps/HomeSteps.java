package steps;

import io.cucumber.java.en.*;
import org.junit.*;
import pages.Home;

public class HomeSteps {
    Home landingPage = new Home();

    @When("Navego a la sección principal")
    public void iNavToHome() {
        landingPage.navigateToHome();
    }

    @Then("Creo una tarea")
    public void iCreateANewTask() {
        landingPage.createANewTask();
    }
}
