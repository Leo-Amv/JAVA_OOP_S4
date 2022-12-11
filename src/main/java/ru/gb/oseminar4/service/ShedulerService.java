package ru.gb.oseminar4.service;

import ru.gb.oseminar4.data.FileOperation;
import ru.gb.oseminar4.data.Task;
import ru.gb.oseminar4.data.TaskMapper;

import java.util.ArrayList;
import java.util.List;


public class ShedulerService {
    private final TaskMapper taskMapper = new TaskMapper();
    private final FileOperation fileOperation = new FileOperation("Sheduler.txt");

    public List<Task> getTaskList() {
        List<String> lines = fileOperation.readAllLines();
        List<Task> taskList= new ArrayList<>();
        for (String line: lines) {
            taskList.add(taskMapper.map(line));
        }
        return taskList;
    }

    public void addTask(Task task) {
        List<String> lines = fileOperation.readAllLines();
        long taskId = 0L;
        for (Task t: getTaskList()) {
            Long id = t.getTaskId();
            if (taskId<id){
                taskId = id;
            }
        }
        task.setTaskId(++taskId);
        lines.add(taskMapper.map(task));
        fileOperation.saveAllLines(lines);
    }

    public void removeTask(Task task) {
        List<String> lines = fileOperation.readAllLines();
        lines.remove(taskMapper.map(task));
        fileOperation.saveAllLines(lines);
    }

    public Task getTaskByID(Long taskId) {
        Task result = null;
        for (Task task : getTaskList()) {
            if (task.getTaskId().equals(taskId)) {
                result = task;
            } else {
                throw new IllegalStateException("Task is not found!");
            }
        }
        return result;
    }

}
