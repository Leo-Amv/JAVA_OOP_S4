package ru.gb.oseminar4.data;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task {
    private User author;
    private String task;
    private Priority priority;
    private Boolean status;
    private final Date dateCreate;
    private final Long taskId;
    private static Long id = 0L;

    public Task(User author, String task, Priority priority) {
        this.author = author;
        this.task = task;
        this.priority = priority;
        this.status = false;
        this.dateCreate = Calendar.getInstance().getTime();
        this.taskId = ++id;
    }

    public Task(User author, String task, Priority priority, Boolean status, Date dateCreate, Long taskId) {
        this.author = author;
        this.task = task;
        this.priority = priority;
        this.status = status;
        this.dateCreate = dateCreate;
        this.taskId = taskId;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getDateCreate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        return dateFormat.format(dateCreate);
    }

    public Long getTaskId() {
        return taskId;
    }

    @Override
    public String toString() {
        return "Task:\t" + taskId+
                "\nAuthor:\t" + author +
                "\nTask:\t" + task + '\'' +
                "\nPriority:\t" + priority +
                "\nStatus:\t" + status +
                "\nDateCreate:\t" + dateCreate;
    }
}
