package steps;

import io.cucumber.java.en.*;
import org.junit.*;
import pages.InicioSesion;

public class InicioSesionSteps {
    InicioSesion landingPage = new InicioSesion();

    @Given("Navego a 192.168.80.43:10200")
    public void iNavigateToST() {
        landingPage.navigateToSentraTask();
    }

    @When("Ingreso el usuario {string} y la contraseña {string}")
    public void iLoginToST(String user, String pass) {
        landingPage.loginToSentraTask(user, pass);
    }

    @Then("Aparece un mensaje de error")
    public void iLoginSuccesful() {
        Assert.assertTrue("¡ADVERTENCIA!", landingPage.messageToDisplay());
    }

    @Then("Cerramos sesión")
    public void iLogout() {
        landingPage.logoutFromSentraTask();
    }
}
