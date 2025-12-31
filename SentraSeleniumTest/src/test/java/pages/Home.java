package pages;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.TimeZone;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import pages.FilaDeTareas;

public class Home extends BasePage {
    private String homeSection = "//span[normalize-space()='Home']";
    private String newTaskButton = "//button[normalize-space()='Nueva Tarea']";

    /* Lista de Tareas Vacía */
    private String emptyList = "//*[@id=\"root\"]/div/main/div[2]/div/div[2]";

    /* Formulario de Nueva Tarea */
    private String titleInput = "//input[@id='title']";
    private String descriptionInput = "//textarea[@id='title']";
    private String dateInput = "//div[4]//div[1]//input[1]";
    private String priorityInput = "(//input[@id='dueDate'])[2]";
    private String createTaskButton = "//button[normalize-space()='Crear Tarea']";

    /* Columna de Título */
    private String titleColumn = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[1]";
    private String titleButton = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[1]/span";
    /* Columna de Prioridad */
    private String priorityColumn = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[4]";
    private String priorityButton = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[4]/span";
    /* Columna de Fecha de Vencimiento */
    private String endDateColumn = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[3]";
    private String endDateButton = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[3]/span";
    /* Columna de Fecha de Creación */
    private String creationDateButton = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/thead/tr/th[2]/span";

    private String newTaskCreated = "//*[@id=\"root\"]/div/main/div[2]/div/div/div[1]/table/tbody/a[1]";

    /* Automatizaciones adicionales */
    private String nextPageButton = "//button[@title='Go to next page']";
    private String previousPageButton = "//button[@title='Go to previous page']";
    private String closeMenuButton = "//*[@id=\"root\"]/div/div/div/div/div/div[2]/div/button";
    private String openMenuButton = "//button[@aria-label='open drawer']";
    private String compactTableButton = "//*[@id=\"root\"]/div/main/div[2]/div/label/span[1]/span[1]";

    private LocalDateTime timeOClock;

    private List<FilaDeTareas> originalList;
    private List<FilaDeTareas> newOrderList;
    
    public Home() {
        super();
    }
    
    public List<FilaDeTareas> readTable() {
        List<FilaDeTareas> tasks = new ArrayList<>();
        
        tasks.clear();

        try {
            WebElement nextPage = driver.findElement(By.xpath(nextPageButton));

            while (true) {
                List<WebElement> cells = driver.findElements(By.tagName("td"));
                Queue<String> row = new LinkedList<>();
                
                int i = 0;
                for (WebElement cell : cells) {
                    row.add(cell.getText());
                    i++;
                    
                    if (i%4 == 0) {
                        FilaDeTareas filaAuxiliar = new FilaDeTareas(
                            row.poll(), 
                            LocalDateTime.parse(row.poll()), 
                            LocalDateTime.parse(row.poll()), 
                            Integer.parseInt(row.poll())
                        );
                        
                        tasks.add(filaAuxiliar);
                    }
                }
                
                if (!nextPage.isEnabled())
                    break;
                
                clickElement(nextPageButton);
                Thread.sleep(1000);
            }
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        for (FilaDeTareas task : tasks) {
            task.imprimirFila();
            System.out.println();
        }

        // Volvemos a la primera página de la tabla
        try {
            while (true){
                WebElement previousPage = driver.findElement(By.xpath(previousPageButton));
                
                if (!previousPage.isEnabled())
                    break;
                
                clickElement(previousPageButton);
            }
        } catch (Exception e) {
            // TODO: handle exception
        }

        return tasks;
    }

    public void navigateToHome() {
        clickElement(homeSection);
    }

    public boolean theTaskList() {
        String thereIsATable = null;
        try {
            thereIsATable = getInformation(emptyList);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        if(thereIsATable == null) {
            //readTable();
            return true;
        } else {
            return false;
        }
    }

    /* Creando una Nueva Tarea Exitosa */
    public void aNewTask() {
        clickElement(newTaskButton);
    }

    public void creatingANewTask(String title, String description, String priority) {
        write(titleInput, title);
        write(descriptionInput, description);
        // Dejaré la fecha sin tocar, porque me genera problemas.
        // write(dateInput, "23-12-2025");
        write(priorityInput, priority);
    }

    public void createANewTask() {
        clickElement(createTaskButton);
    }

    public boolean validatingANewTask() {
        timeOClock = LocalDateTime.now();

        clickElement(creationDateButton);
        clickElement(creationDateButton);
        clickElement(newTaskCreated);

        String endDateFromUI = "//*[@id=\"root\"]/div/main/div[2]/table/tbody/tr[5]";

        String endDate = getInformation(endDateFromUI).split(" : ")[1].substring(0, 16);

        /* System.out.println("=== Fecha de Vencimiento ===");
        System.out.println(endDate);
        System.out.println("=== Fecha de Vencimiento ===");
        System.out.println(timeOClock.toString().substring(0, 16)); */

        return timeOClock.toString().substring(0, 16).equals(endDate);
    }

    /* Ordenar Tareas por Título */
    public void orderByTitle() {
        originalList = readTable();
        clickElement(titleButton);
    }

    public boolean isOrderByTitle() {
        // Leemos la tabla y la asignamos a una variable
        newOrderList = readTable();

        List<String> originalTitles = new ArrayList<>();
        List<String> newOrderTitles = new ArrayList<>();

        for (FilaDeTareas element : originalList) {
            originalTitles.add(element.getTitle());
        }

        for (FilaDeTareas element : newOrderList) {
            newOrderTitles.add(element.getTitle());
        }

        List<String> auxiliarList = originalTitles.stream()
            .sorted(Comparator.reverseOrder())
            .collect(Collectors.toList());

        /* System.out.println("\tTitulos de la lista original");
        auxiliarList.forEach(System.out::println);
        System.out.println("\tTitulos de la lista ordenada");
        newOrderTitles.forEach(System.out::println); */

        Set<String> set1 = new HashSet<>(auxiliarList);
        Set<String> set2 = new HashSet<>(newOrderTitles);

        return set1.equals(set2);
    }

    /* Ordenar por Prioridad */
    public void orderByPriority() {
        originalList = readTable();
        clickElement(priorityButton);
    }

    public boolean isOrderByPriority() {
        newOrderList = readTable();
        
        List<Integer> originalPriority = new ArrayList<>();
        List<Integer> newOrderPriority = new ArrayList<>();

        for (FilaDeTareas element : originalList)
            originalPriority.add(element.getPriority());
        
        for (FilaDeTareas element : newOrderList)
            newOrderPriority.add(element.getPriority());

        List<Integer> auxiliarList = originalPriority.stream()
            .sorted()
            .collect(Collectors.toList());

        Set<Integer> set1 = new HashSet<>(auxiliarList);
        Set<Integer> set2 = new HashSet<>(newOrderPriority);
        
        return set1.equals(set2);
    }

    /* Ordenar por Fecha de Término */
    public void orderByEndDate() {
        originalList = readTable();
        clickElement(endDateButton);
    }

    public boolean isOrderedByEndDate() {
        newOrderList = readTable();

        List<LocalDateTime> originalEndDate = new ArrayList<>();
        List<LocalDateTime> newOrderEndDate = new ArrayList<>();

        for (FilaDeTareas element : originalList)
            originalEndDate.add(element.getDueDate());
        
        for (FilaDeTareas element : newOrderList)
            newOrderEndDate.add(element.getDueDate());

        List<LocalDateTime> auxiliarList = originalEndDate.stream()
            .sorted()
            .collect(Collectors.toList());

        /* System.out.println("\tTitulos de la lista original");
        auxiliarList.forEach(System.out::println);
        System.out.println("\tTitulos de la lista ordenada");
        newOrderEndDate.forEach(System.out::println); */

        Set<LocalDateTime> set1 = new HashSet<>(auxiliarList);
        Set<LocalDateTime> set2 = new HashSet<>(newOrderEndDate);
        
        return set1.equals(set2);
    }

    /* Paginar Lista de Tareas */
    public void nextPage() {
        clickElement(nextPageButton);
    }

    public boolean isNextPage(List<String> originaList) {
        List<String> newPageList = getTexts(titleColumn);

        System.out.println(originaList);
        System.out.println(newPageList);

        return originaList.equals(newPageList);
    }

    public void previousPage() {
        clickElement(previousPageButton);
    }

    /* Cerrar Barra Lateral del Menú */
    public void closeMenu() {
        clickElement(closeMenuButton);
    }

    /* Abrir Barra Lateral del Menú */
    public void openMenu() {
        clickElement(openMenuButton);
    }

    /* Compactar la Lista de Tareas */
    public void compactTable() {
        clickElement(compactTableButton);
    }
}
