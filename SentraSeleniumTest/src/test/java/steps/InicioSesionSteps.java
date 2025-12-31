package steps;

import io.cucumber.java.en.*;
import org.junit.*;
import pages.InicioSesion;
import pages.TestData;

public class InicioSesionSteps {
    InicioSesion landingPage = new InicioSesion();

    @Given("Navego a 192.168.80.43:10200")
    public void iNavigateToSentraTask() {
        landingPage.navigateToURL();
    }

    @When("Inicio sesión con las credenciales válidas")
    public void iLogin() {
        landingPage.signIn(
            TestData.VALID_EMAIL,
            TestData.VALID_PASSWORD
        );
    }

    @When("Inicio sesión con las credenciales inválidas")
    public void iFaildToLogin() {
        landingPage.signIn(
            TestData.INEXISTING_EMAIL,
            TestData.INEXISTING_PASSWORD
        );
    }

    @Then("Accedo al sistema")
    public void iClickToLogin() {
        landingPage.logIn();
    }
}
