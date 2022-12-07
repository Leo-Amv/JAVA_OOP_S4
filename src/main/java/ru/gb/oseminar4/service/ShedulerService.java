package ru.gb.oseminar4.service;

import ru.gb.oseminar4.data.Task;

import java.util.ArrayList;
import java.util.List;


public class ShedulerService {
    private final List<Task> taskList;

    public ShedulerService() {
        this.taskList = new ArrayList<>();
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void addTask(Task task) {
        this.taskList.add(task);
    }

    public void removeTask(Task task) {
        this.taskList.remove(task);
    }

    public Task getTaskByID(Long taskId) {
        Task result = null;
        for (Task task : taskList) {
            if (task.getTaskId().equals(taskId)) {
                result = task;
            } else {
                throw new IllegalStateException("Task is not found!");
            }
        }
        return result;
    }

}
