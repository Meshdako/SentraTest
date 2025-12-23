package pages;

public class Home extends BasePage {
    private String homeSection = "//span[normalize-space()='Home']";
    private String newTaskButton = "//button[normalize-space()='Nueva Tarea']";
    private String titleInput = "//input[@id='title']";
    private String descriptionInput = "//textarea[@id='title']";
    private String dateInput = "//div[4]//div[1]//input[1]";
    private String priorityInput = "(//input[@id='dueDate'])[2]";
    private String createTaskButton = "//button[normalize-space()='Crear Tarea']";

    public Home() {
        super();
    }

    public void navigateToHome() {
        clickElement(homeSection);
    }

    public void createANewTask() {
        clickElement(newTaskButton);
        write(titleInput, "Test Automatizado");
        write(descriptionInput, "Probando");
        // Dejaré la fecha sin tocar, porque me genera problemas.
        //rite(dateInput, "23-12-2025");
        write(priorityInput, "1");
        clickElement(createTaskButton);
    }
}
