package ru.gb.oseminar4.controller;

import ru.gb.oseminar4.data.Priority;
import ru.gb.oseminar4.data.Task;
import ru.gb.oseminar4.data.User;
import ru.gb.oseminar4.service.ShedulerService;
import ru.gb.oseminar4.service.TaskService;

import java.util.List;

public class Controller {
    ShedulerService shedulerService = new ShedulerService();
    TaskService taskService = new TaskService();

    public void createTask(User author, String task, Priority priority) {
        shedulerService.addTask(taskService.createTask(author, task, priority));
    }

    public void deleteTask(Long taskId) {
        Task task = shedulerService.getTaskByID(taskId);
        shedulerService.removeTask(task);
    }

    public<T> void editTask(Long taskId,T field) {
        Task task = shedulerService.getTaskByID(taskId);
        shedulerService.removeTask(task);
        taskService.editTask(task,field);
        shedulerService.addTask(task);
    }
    public Task getTaskById(Long taskId){
        return shedulerService.getTaskByID(taskId);

    }
    public List<Task> getAllTasks(){
       return shedulerService.getTaskList();
    }

}
