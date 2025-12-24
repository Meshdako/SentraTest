package pages;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Home extends BasePage {
    private String homeSection = "//span[normalize-space()='Home']";
    private String newTaskButton = "//button[normalize-space()='Nueva Tarea']";
    private String titleInput = "//input[@id='title']";
    private String descriptionInput = "//textarea[@id='title']";
    private String dateInput = "//div[4]//div[1]//input[1]";
    private String priorityInput = "(//input[@id='dueDate'])[2]";
    private String createTaskButton = "//button[normalize-space()='Crear Tarea']";

    private String titleColumn = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[1]";
    private String titleButton = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[1]/span";
    private String priorityColumn = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[4]";
    private String priorityButton = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[4]/span";
    private String endDateColumn = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[3]";
    private String endDateButton = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[3]/span";

    private String nextPageButton = "//button[@title='Go to next page']";
    private String previousPageButton = "//button[@title='Go to previous page']";
    private String closeMenuButton = "//*[@id=\"root\"]/div/div/div/div/div/div[2]/div/button";
    private String openMenuButton = "//button[@aria-label='open drawer']";
    private String compactTableButton = "//*[@id=\"root\"]/div/main/div[2]/div/label/span[1]/span[1]";

    public Home() {
        super();
    }

    public void navigateToHome() {
        clickElement(homeSection);
    }

    public void createANewTask() {
        clickElement(newTaskButton);
        write(titleInput, "Nuevo Test Automatizado");
        write(descriptionInput, "Probando");
        // Dejaré la fecha sin tocar, porque me genera problemas.
        // rite(dateInput, "23-12-2025");
        write(priorityInput, "2");
        clickElement(createTaskButton);
    }

    public void orderByTitle() {
        clickElement(titleButton);
    }

    public boolean isOrderByTitle() {
        List<String> originalList = getTexts(titleColumn);
        List<String> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList, String.CASE_INSENSITIVE_ORDER);
        return originalList.equals(sortedList);
    }

    public void orderByPriority() {
        clickElement(priorityButton);
    }

    public boolean isOrderByPriority() {
        List<String> originalList = getTexts(priorityColumn);

        List<Integer> newIntegerList = originalList.stream()
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        List<Integer> sortedList = new ArrayList<>(newIntegerList);
        Collections.sort(sortedList);

        return newIntegerList.equals(sortedList);
    }

    public void orderByEndDate() {
        clickElement(endDateButton);
    }

    public boolean isOrderedByEndDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");

        List<LocalDate> originalList = getTexts(endDateColumn)
            .stream()
            .map(date -> LocalDate.parse(date, formatter))
            .collect(Collectors.toList());

        List<LocalDate> sortedList = new ArrayList<>(originalList);
        Collections.sort(sortedList);

        return originalList.equals(sortedList);
    }

    public void nextPage() {
        clickElement(nextPageButton);
    }

    public boolean isNextPage(List<String> originaList) {
        List<String> newPageList = getTexts(titleColumn);

        return originaList.equals(newPageList);
    }

    public void previousPage() {
        clickElement(previousPageButton);
    }

    public void closeMenu() {
        clickElement(closeMenuButton);
    }

    public void openMenu() {
        clickElement(openMenuButton);
    }

    public void compactTable() {
        clickElement(compactTableButton);
    }
}
