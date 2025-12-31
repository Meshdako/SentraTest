package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CrearPerfil;
import pages.InicioSesion;
import pages.TestData;

public class CrearPerfilSteps {
    CrearPerfil landingPage = new CrearPerfil();
    InicioSesion oldLandingPage = new InicioSesion();

    @Given("Quiero crear un perfil nuevo")
    public void iWantToCreateANewUser() {
        landingPage.creatingANewUser();
    }

    @When("Ingreso los datos válidos de usuario")
    public void iWriteTheUserInformation() {
        landingPage.addingTheUserInformation(
            TestData.NEW_NAME,
            TestData.NEW_LASTNAME,
            TestData.NEW_EMAIL,
            TestData.NEW_PASSWORD,
            TestData.NEW_PASSWORD
        );
    }

    @When("Ingreso los datos inválidos de usuario")
    public void iWriteTheFalseUserInformation() {
        landingPage.addingTheUserInformation(
            TestData.INVALID_NAME,
            TestData.INVALID_LASTNAME,
            TestData.INVALID_EMAIL,
            TestData.INVALID_PASSWORD,
            TestData.INVALID_PASSWORD
        );
    }

    @When("Ingreso los datos incorrectos de usuario")
    public void iWriteTheWrongUserInformation() {
        landingPage.addingTheUserInformation(
            TestData.NEW_WRONG_NAME,
            TestData.NEW_WRONG_LASTNAME,
            TestData.NEW_WRONG_EMAIL,
            TestData.NEW_WRONG_PASSWORD_1,
            TestData.NEW_WRONG_PASSWORD_2
        );
    }

    @And("Creo el perfil nuevo")
    public void iRegisterANewUser() {
        landingPage.registeringANewUser();
    }

    @Then("Valido el perfil nuevo válido")
    public void iLogin() {
        oldLandingPage.signIn(
            TestData.NEW_EMAIL,
            TestData.NEW_PASSWORD
        );
        oldLandingPage.logIn();
    }

    @Then("Valido el perfil nuevo inválido")
    public void iFailedToCreate() {
        oldLandingPage.signIn(
            TestData.INVALID_EMAIL,
            TestData.INVALID_PASSWORD
        );
        oldLandingPage.logIn();
    }
}
