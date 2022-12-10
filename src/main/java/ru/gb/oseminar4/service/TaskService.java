package ru.gb.oseminar4.service;

import ru.gb.oseminar4.data.Priority;
import ru.gb.oseminar4.data.Task;
import ru.gb.oseminar4.data.User;

public class TaskService {
    public Task createTask(User author, String task, Priority priority){
        return new Task(author, task, priority);
    }

    public<T> void editTask(Task task,T field){
        switch (field.getClass().getSimpleName()){
            case "User":
                task.setAuthor((User) field);
                break;
            case "String":
                task.setTask((String) field);
                break;
            case "Priority":
                task.setPriority((Priority) field);
                break;
            case "Boolean":
                task.setStatus((Boolean) field);
                break;
            default:
                throw new IllegalStateException("Field not found!");
        }
    }
}
