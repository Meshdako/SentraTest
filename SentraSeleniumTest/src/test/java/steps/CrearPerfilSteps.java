package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.CrearPerfil;

public class CrearPerfilSteps {
    CrearPerfil landingPage = new CrearPerfil();

    @Given("Quiero crear un perfil nuevo")
    public void iCreateANewUser() {
        landingPage.creatingANewUser();
    }
    
    @When("Ingreso el usuario {string} y apellido {string}")
    public void iAddName(String name, String lastName) {
        landingPage.addName(name, lastName);
    }

    @And("El correo {string} y la a contraseña {string}")
    public void iAddUserInfor(String email, String password) {
        landingPage.addUserInformation(email, password);
    }

    @And("Creamos el usuario")
    public void iAddANewUser() {
        landingPage.addANewUser();
    }

    @Then("Validamos su creación")
    public void iCreatedANewUser() {
        landingPage.messageToDisplay();
    }
}
