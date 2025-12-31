package pages;

public class CrearPerfil extends BasePage {
    private String newProfileButton = "//button[normalize-space()='Crear Nuevo Usuario']";
    private String registerButton = "//button[normalize-space()='Registrar Usuario']";
    private String nameInput = "//input[@id='firstname']";
    private String lastNameInput = "//input[@id='lastname']";
    private String emailInput = "(//input[@id='email'])[2]";
    private String firstPassInput = "(//input[@id='password'])[2]";
    private String secondPassInput = "(//input[@id='repeat_password'])[1]";
    private String alert = "//div[@role='alert']";

    public CrearPerfil() {
        super();
    }

    public void creatingANewUser() {
        clickElement(newProfileButton);
    }

    public void addingTheUserInformation(String name, String lastName, String email, String password_1, String password_2) {
        write(nameInput, name);
        write(lastNameInput, lastName);
        write(emailInput, email);
        write(firstPassInput, password_1);
        write(secondPassInput, password_2);
    }

    public void registeringANewUser() {
        clickElement(registerButton);
    }
}
