package pages;

public class InicioSesion extends BasePage {
    private String emailString = "//input[@id='email']";
    private String passwoString = "//input[@id='password']";
    private String loginButton = "//button[@type='submit']";
    private String messageLabel = "//div[@role='alert']";
    private String logoutSection = "//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-yb0lig']";

    public InicioSesion() {
        super();
    }

    public void navigateToURL() {
        navigateTo("http://192.168.80.43:10200");
    }

    public void signIn(String user, String pass) {
        write(emailString, user);
        write(passwoString, pass);
    }

    public void logIn() {
        clickElement(loginButton);
    }

    public Boolean warningToDisplay() {
        return message(messageLabel);
    }

    public void logOut() {
        clickElement(logoutSection);
    }
}
