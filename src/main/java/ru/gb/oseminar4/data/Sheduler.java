package ru.gb.oseminar4.data;

import java.util.ArrayList;
import java.util.List;

public class Sheduler {
    private final List<Task> taskList;

    public Sheduler() {
        this.taskList = new ArrayList<>();
    }

    public List<Task> getSheduler() {
        return taskList;
    }
}
