package ru.gb.oseminar4.view;

import ru.gb.oseminar4.controller.Controller;
import ru.gb.oseminar4.data.Commands;
import ru.gb.oseminar4.data.Priority;
import ru.gb.oseminar4.data.User;

import java.util.Scanner;

public class Viewer {
    private final Controller controller = new Controller();
    public void start(){
        while (true){
            menu();
            String command = input("Enter command:\t").toUpperCase();
            Commands cmd = Commands.valueOf(command);
            switch (cmd){
                case CREATE:
                    String firstName = input("Enter firstName:\t");
                    String lastName = input("Enter lastName:\t");
                    User user = new User(firstName,lastName);
                    String task = input("Enter task:\t");
                    Priority priority = Priority.valueOf(input("Enter priority:\t\n" +
                            "HIGH\n" +
                            "MEDIUM\n" +
                            "LOW\n").toUpperCase());
                    controller.createTask(user,task,priority);
                    break;
                case DELETE:
                    Long taskId = Long.valueOf(input("Enter taskId:\t"));
                    controller.deleteTask(taskId);
                    break;
                case EDIT:
                    break;
                case SHOW:
                    Long Id = Long.valueOf(input("Enter taskId:\t"));
                    controller.showTaskById(Id);
                    break;
                case ALL:
                    controller.showAllTasks();
                    break;
                case EXIT:
                    return;
            }
        }
    }
    private void menu(){
        System.out.println("Choose command:\n" +
                "Create task:\tCREATE\n" +
                "Delete task:\tDELETE\n" +
                "Edit task:\tEDIT\n" +
                "Show task by ID:\tSHOW\n" +
                "Show all tasks:\tALL\n" +
                "Exit program:\tEXIT\n");
    }
    private String input(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextLine();

    }
}
