package pages;

public class EditarPerfil extends BasePage {
    private String profileSection = "//span[normalize-space()='Perfil']";
    private String editButton = "//button[normalize-space()='Editar Datos Usuario']";
    private String modifyUserButton = "//button[normalize-space()='Modificar Usuario']";
    private String nameInput = "//input[@id='firstname']";
    private String lastNameInput = "//input[@id='lastname']";
    private String validPopUp = "//div[@role='alert']";

    public EditarPerfil() {
        super();
    }

    public void navigateToProfile() {
        clickElement(profileSection);
    }

    public void editingProfile(String name, String lastName) {
        clickElement(editButton);
        write(nameInput, name);
        write(lastNameInput, lastName);
        clickElement(modifyUserButton);
    }

    public Boolean messageToDisplay() {
        return message(validPopUp);
    }
}
