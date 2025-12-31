package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.Home;
import pages.TestData;

public class HomeSteps {
    Home landingPage = new Home();

    @When("Navego a la sección principal")
    public void iNavToHome() {
        landingPage.navigateToHome();
    }

    /* Visualizar Lista de Tareas */
    @Then("Veo la lista de tareas")
    public void iSeeTheTaskList() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (landingPage.theTaskList() == true) {
            System.out.println("La lista no está vacía");
        } else {
            System.out.println("La lista está vacía");
        }
    }

    /* Creando una Nueva Tarea */
    @And("Quiero crear una nueva tarea")
    public void iWantToCreateATask() {
        landingPage.aNewTask();
    }

    @And("Ingreso los nuevos datos")
    public void iWriteTheNewTaskInformation() {
        landingPage.creatingANewTask(
                TestData.TITLE_INPUT,
                TestData.DESCRIPTION_INPUT,
                TestData.PRIORITY_INPUT);
    }

    @And("Ingreso los nuevos datos incorrectos")
    public void iWriteTheNewTaskInformationWrong() {
        // Información vacía. Error obvio.
    }

    @Then("Creo una tarea")
    public void iCreateANewTask() {
        landingPage.createANewTask();
    }

    @And("Valido la nueva tarea creada")
    public void iValidTheNewTask() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if (landingPage.validatingANewTask() == true) {
            System.out.println("La tarea se creó correctamente");
        } else {
            System.out.println("La tarea se creó incorrectamente");
        }
    }

    /* Ordenar Tareas por Título */
    @And("Ordeno las tareas por título")
    public void iOBT() {
        landingPage.orderByTitle();
    }

    @Then("Las tareas están ordenadas por título")
    public void iSeeOBT() {
        if (landingPage.isOrderByTitle() == true) {
            System.out.println("La lista de tareas está ordenada por título correctamente.");
        } else {
            System.out.println("La lista de tareas está ordenada por título incorrectamente.");
        }
    }

    /* Ordenar por Prioridad */
    @And("Ordeno las tareas por Prioridad")
    public void iOBP() {
        landingPage.orderByPriority();
    }

    @Then("Las tareas se ordenan por prioridad")
    public void iSeeOBP() {
        if (landingPage.isOrderByPriority() == true) {
            System.out.println("La lista de tareas está ordenada por prioridad correctamente.");
        } else {
            System.out.println("La lista de tareas está ordenada por prioridad incorrectamente.");
        }
    }

    /* Ordenar por Fecha de Término */
    @And("Ordeno las tareas por fecha de término")
    public void iOBED() {
        landingPage.orderByEndDate();
    }

    @Then("Las tareas se ordenan por fecha de término")
    public void iSeeOBED() {
        if (landingPage.isOrderedByEndDate() == true) {
            System.out.println("La lista de tareas está ordenada por título correctamente.");
        } else {
            System.out.println("La lista de tareas está ordenada por título incorrectamente.");
        }
    }

    /* Paginar Lista de Tareas */
    @And("Pagino la lista de tareas")
    public void iClickToNextPage() {
        landingPage.nextPage();
    }

    @Then("La página me muestra las demás tareas")
    public void iSeeTheNextPage() {

    }

    /* Compactar la Lista de Tareas */
    @And("Doy clic en la visualización compacta")
    public void iCompactTheTable() {
        landingPage.compactTable();
    }

    /* Cerrar Barra Lateral del Menú */
    @And("Doy clic en el cierre de la barra lateral")
    public void iCloseTheMenu() {
        landingPage.closeMenu();
    }

    @Then("La página cierra la barra")
    public void iSeeTheMenuClosed() {
        boolean isClosed = landingPage.isTheMenuClosed();
        System.out.println(isClosed);
        
        if (isClosed) {
            System.out.println("La barra lateral fue cerrada correctamente.");
        } else {
            System.out.println("La barra lateral fue cerrada incorrectamente.");
        }
    }
}
