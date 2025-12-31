package pages;

import java.time.LocalDateTime;

public class FilaDeTareas {
    private String title;
    private LocalDateTime creationDate;
    private LocalDateTime dueDate;
    private int priority;

    public FilaDeTareas() {}

    public FilaDeTareas(String title, LocalDateTime creationDate, LocalDateTime dueDate, int priority) {
        this.title = title;
        this.creationDate = creationDate;
        this.dueDate = dueDate;
        this.priority = priority;
    }

    public void imprimirFila() {
        System.out.print(title + " / ");
        System.out.print(creationDate + " / ");
        System.out.print(dueDate + " / ");
        System.out.print(priority);

    }

    public String getTitle() { return title; }
    public LocalDateTime getCreationDate() { return creationDate; }
    public LocalDateTime getDueDate() { return dueDate; }
    public int getPriority() { return priority; }

    public void setTitle(String title) { this.title =  title; }
    public void setCreationDate(LocalDateTime creationDate) { this.creationDate = creationDate; }
    public void setDueDate(LocalDateTime dueDate) { this.dueDate = dueDate; }
    public void setPriority(int priority) { this.priority = priority; }
}
