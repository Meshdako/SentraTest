package pages;

public class InicioSesion extends BasePage {
    private String emailString = "//input[@id='email']";
    private String passwoString = "//input[@id='password']";
    private String loginButton = "//button[@type='submit']";
    private String messageLabel = "//div[@class='MuiAlert-message css-1xsto0d']";
    private String logoutSection = "//span[@class='MuiTypography-root MuiTypography-body1 MuiListItemText-primary css-yb0lig']";

    public InicioSesion() {
        super(driver);
    }

    public void navigateToSentraTask() {
        navigateTo("http://192.168.80.43:10200");
    }

    public void loginToSentraTask(String user, String pass) {
        write(emailString, user);
        write(passwoString, pass);
        clickElement(loginButton);
    }

    public Boolean messageToDisplay() {
        return message(messageLabel);
    }

    public void logoutFromSentraTask() {
        clickElement(logoutSection);
    }
}
