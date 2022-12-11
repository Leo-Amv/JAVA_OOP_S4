package ru.gb.oseminar4.view;

import ru.gb.oseminar4.controller.Controller;
import ru.gb.oseminar4.data.*;

import java.util.Scanner;

public class Viewer {
    private final Controller controller = new Controller();
    public void start(){
        while (true){
            menu();
            String command = input("Enter command:\t").toUpperCase();
            Commands cmd = Commands.valueOf(command.toUpperCase());
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
                    Long taskID = Long.valueOf(input("Enter task id:\t"));
                    TaskFields field = TaskFields.valueOf(input("Enter field:\n" +
                            "TASK\n" +
                            "AUTHOR\n" +
                            "STATUS\n" +
                            "PRIORITY\n").toUpperCase());
                    switch (field){
                        case TASK:
                            controller.editTask(taskID ,input("Enter task:\t"));
                            break;
                        case AUTHOR:
                            String fName = input("Enter firstName:\t");
                            String lName = input("Enter lastName:\t");
                            User author = controller.getTaskById(taskID).getAuthor();
                            author.setFirstName(fName);
                            author.setLastName(lName);
                            controller.editTask(taskID ,author);
                            break;
                        case STATUS:
                            Boolean status = Boolean.valueOf(input("Enter status 'true' or 'false':\t"));
                            controller.editTask(taskID ,status);
                            break;
                        case PRIORITY:
                            Priority prior = Priority.valueOf(input("Enter priority 'HIGH' 'MEDIUM' 'LOW' :\t").toUpperCase());
                            controller.editTask(taskID ,prior);
                            break;
                    }
                    break;
                case SHOW:
                    Long Id = Long.valueOf(input("Enter taskId:\t"));
                    System.out.println(controller.getTaskById(Id));
                    break;
                case ALL:
                    for (Task t: controller.getAllTasks()) {
                        System.out.println(t);
                    }
                    break;
                case EXIT:
                    return;
            }
        }
    }
    private void menu(){
        System.out.println("\nChoose command:\n" +
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
