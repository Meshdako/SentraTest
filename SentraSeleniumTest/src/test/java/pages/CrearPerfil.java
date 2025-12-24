package pages;

public class CrearPerfil extends BasePage {
    private String newProfileButton = "//button[normalize-space()='Crear Nuevo Usuario']";
    private String registerButton = "//button[normalize-space()='Registrar Usuario']";
    private String nameInput = "//input[@id='firstname']";
    private String lastNameInput = "//input[@id='lastname']";
    private String emailInput = "(//input[@id='email'])[2]";
    private String firstPassInput = "(//input[@id='password'])[2]";
    private String secondPassInput = "(//input[@id='repeat_password'])[1]";
    private String alert = "//div[@class='MuiAlert-message css-1xsto0d']";

    public CrearPerfil() {
        super();
    }

    public void creatingANewUser() {
        clickElement(newProfileButton);
    }

    public void addName(String name, String lastName) {
        write(nameInput, name);
        write(lastNameInput, lastName);
    }

    public void addUserInformation(String email, String password) {
        write(emailInput, email);
        write(firstPassInput, password);
        write(secondPassInput, password);
    }

    public void addANewUser() {
        clickElement(registerButton);
    }

    public Boolean messageToDisplay() {
        return message(alert);
    }
}
