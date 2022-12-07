package ru.gb.oseminar4.controller;

import ru.gb.oseminar4.data.Priority;
import ru.gb.oseminar4.data.Task;
import ru.gb.oseminar4.data.User;
import ru.gb.oseminar4.service.ShedulerService;
import ru.gb.oseminar4.service.TaskService;

public class Controller {
    ShedulerService shedulerService = new ShedulerService();
    TaskService taskService = new TaskService();

    public void createTask(User author, String task, Priority priority) {
        shedulerService.addTask(taskService.createTask(author, task, priority));
    }

    public void deleteTask(Task task) {
        shedulerService.removeTask(task);
    }

    public<T> void editTask(Long taskId,T field) {
        for (Task task: shedulerService.getTaskList()) {
            if (task.getTaskId().equals(taskId)){
                taskService.editTask(task,field);
            }
        }
    }

}
