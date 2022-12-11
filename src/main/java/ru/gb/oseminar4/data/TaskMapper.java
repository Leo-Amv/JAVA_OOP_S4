package ru.gb.oseminar4.data;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskMapper {
    public String map(Task task){
        User user = task.getAuthor();
        return String.format("%s;%s;%s;%s;%s;%s;%s;%s",
                user.getFirstName(),
                user.getLastName(),
                user.getUserId(),
                task.getTask(),
                task.getPriority(),
                task.getStatus(),
                task.getDateCreate(),
                task.getTaskId());
    }
    public Task map(String line) {
        String[]lines = line.split(";");
        User user = new User(lines[0],lines[1],Long.valueOf(lines[2]));
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd hh:mm");
        try{
            Date date = dateFormat.parse(lines[6]);
            return new Task(user,
                    lines[3],
                    Priority.valueOf(lines[4]),
                    Boolean.valueOf(lines[5]),
                    date,
                    Long.valueOf(lines[7]));
        }catch (Exception e){
            System.out.println(e.getMessage());
            return null;
        }
    }
}
