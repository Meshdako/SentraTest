package pages;


public class InicioSesion extends BasePage {
    private String emailString = "//input[@id='email']";
    private String passwoString = "//input[@id='password']";
    private String loginButton = "//button[@type='submit']";
 
    public InicioSesion() {
        super(driver);
    }
 
    public void navigateToSentraTask() {
        navigateTo("http://192.168.80.43:10200");
    }
    
    public void loginToSentraTask() {
        write(emailString, "msobarzo@sentra.cl");
        write(passwoString, "msobarzo02");
        clickElement(loginButton);
    }
}

