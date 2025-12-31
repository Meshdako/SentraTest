package steps;

import io.cucumber.java.en.*;
import org.junit.*;
import pages.EditarPerfil;
import pages.TestData;

public class EditarPerfilSteps {
    EditarPerfil landingPage = new EditarPerfil();

    @Given("Navego a la sección del perfil")
    public void iNavToProfile() {
        landingPage.navigateToProfile();
    }

    @And("Quiero editar el perfil")
    public void iWantToEditTheProfile() {
        landingPage.editProfile();
    }

    @When("Edito el perfil")
    public void iEditTheProfile() {
            landingPage.editingProfile(
                TestData.EDIT_NAME,
                TestData.EDIT_LASTNAME
            );
    }

    @When("Edito el perfil incorrectamente")
    public void iEditWrongTheProfile() {
            landingPage.editingProfile(
                " ",
                " "
            );
    }

    
    @And("Se valida la modificación")
    public void iEditedTheProfile() {
        Assert.assertTrue("Datos de usuario modificados correctamente", landingPage.messageToDisplay());
    }
    
    @When("Quiero cambiar la contraseña")
    public void iWantToChangeThePassword() {
        landingPage.editPassword();
    }
    
    @And("Ingreso las contraseñas mal")
    public void iAddThePasswordWrong() {
        landingPage.editingPassword(
            TestData.WRONG_PASSWORD_1,
            TestData.WRONG_PASSWORD_2
        );
    }

    @Then("La modifico la contraseña")
    public void iModifyThePassword() {
        landingPage.modifyingPassword();
    }
    
    @Then("El perfil se modifica")
    public void iModifyTheProfile() {
        landingPage.modifyingTheProfile();
    }

     @And("Valido el error")
    public void iEditThePassword() {
        Assert.assertTrue("Contraseña cambiada correctamente", landingPage.messageToDisplay());
    }
}
