package pages;

public class EditarPerfil extends BasePage {
    private String profileSection = "//span[normalize-space()='Perfil']";
    
    private String editButton = "//button[normalize-space()='Editar Datos Usuario']";
    private String modifyUserButton = "//button[normalize-space()='Modificar Usuario']";
    private String passwordButton = "//button[normalize-space()='Cambiar Contraseña']";
    private String modifyPasswordButton = "//button[@class='MuiButtonBase-root MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium MuiButton-root MuiButton-text MuiButton-textPrimary MuiButton-sizeMedium MuiButton-textSizeMedium css-1y36nkv'][normalize-space()='Cambiar Contraseña']";

    private String nameInput = "//input[@id='firstname']";
    private String lastNameInput = "//input[@id='lastname']";
    private String validPopUp = "//div[@role='alert']";

    private String passInput = "//input[@id='password']";
    private String repeatPassInput = "//input[@id='repeat_password']";

    public EditarPerfil() {
        super();
    }

    public void navigateToProfile() {
        clickElement(profileSection);
    }

    public void editProfile() {
        clickElement(editButton);
    }

    public void editingProfile(String name, String lastName) {
        write(nameInput, name);
        write(lastNameInput, lastName);
    }
    
    public void modifyingTheProfile() {
        clickElement(modifyUserButton);
    }

    public void editPassword() {
        clickElement(passwordButton);
    }

    public void editingPassword(String pass_1, String pass_2) {
        write(passInput, pass_1);
        write(repeatPassInput, pass_2);
    }

    public void modifyingPassword() {
        clickElement(modifyPasswordButton);
    }

    public Boolean messageToDisplay() {
        return message(validPopUp);
    }
}
