package steps;

import io.cucumber.java.en.*;
import org.junit.*;
import pages.EditarPerfil;

public class EditarPerfilSteps {
    EditarPerfil landingPage = new EditarPerfil();

    @When("Navego a la sección del perfil")
    public void iNavToProfile() {
        landingPage.navigateToProfile();
    }

    @And("Edito el nombre por {string} y el apellido por {string}")
    public void iEditTheProfile(String name, String lastName) {
            landingPage.editingProfile(name, lastName);
    }

    @Then("Se valida la edición")
    public void iEditedTheProfile() {
        Assert.assertTrue("¡ALERTA!", landingPage.messageToDisplay());
    }
}
