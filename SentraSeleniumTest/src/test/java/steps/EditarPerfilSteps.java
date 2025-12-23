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

    @Then("Aparece un mensaje de validación")
    public void iEditedTheProfile() {
        Assert.assertTrue("El mensaje", landingPage.messageToDisplay());
    }
}
