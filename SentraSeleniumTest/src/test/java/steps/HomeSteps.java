package steps;

import org.junit.Assert;

import io.cucumber.java.en.*;
import pages.Home;

public class HomeSteps {
    Home landingPage = new Home();

    @When("Navego a la sección principal")
    public void iNavToHome() {
        landingPage.navigateToHome();
    }

    @And("Creo una tarea")
    public void iCreateANewTask() {
        landingPage.createANewTask();
    }

    @Then("La tarea aparece en la lista")
    public void iValidTheNewTask() {
        
    }

    @And("Ordeno las tareas por título")
    public void iOBT() {
        landingPage.orderByTitle();
    }

    @Then("Las tareas están ordenadas por título")
    public void iSeeOBT() {
        Assert.assertTrue(landingPage.isOrderByTitle());
    }

    @And("Ordeno las tareas por Prioridad")
    public void iOBP() {
        landingPage.orderByPriority();
    }

    @Then("Las tareas se ordenan por prioridad")
    public void iSeeOBP() {
        Assert.assertTrue(landingPage.isOrderByPriority());
    }

    @And("Ordeno las tareas por fecha de término")
    public void iOBED() {
        landingPage.orderByEndDate();
    }

    @Then("Las tareas se ordenan por fecha de término")
    public void iSeeOBED() {
        Assert.assertTrue(landingPage.isOrderedByEndDate());
    }

    @And("Pagino la lista de tareas")
    public void iClickToNextPage() {
        landingPage.nextPage();
    }

    @Then("La página me muestra las demás tareas")
    public void iSeeTheNextPage() {
        
    }

    @And("Doy clic en la visualización compacta")
    public void iCompactTheTable() {
        landingPage.compactTable();
    }

    @And("Doy clic en el cierre de la barra lateral")
    public void iCloseTheMenu() {
        landingPage.closeMenu();
    }
}
