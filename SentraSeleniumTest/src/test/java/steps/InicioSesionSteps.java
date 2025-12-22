package steps;

import io.cucumber.java.en.*;
import pages.InicioSesion;

public class InicioSesionSteps {
    InicioSesion landingPage = new InicioSesion();

    @Given("I navigate to 192.168.80.43:10200")
    public void iNavigateToST() {
        landingPage.navigateToSentraTask();
    }

    @When("I login in page principal")
    public void iLoginToST() {
        landingPage.loginToSentraTask();
    }
}
