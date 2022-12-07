package ru.gb.oseminar4.view;

import ru.gb.oseminar4.data.Commands;

import java.util.Scanner;

public class Viewer {
    public void start(){
        while (true){
            menu();
            Commands cmd = Commands.valueOf(input("Enter command:\t").toUpperCase());
            switch (cmd){
                case CREATE:
                case DELETE:
                case EDIT:
                case SHOW:
                case ALL:
                case EXIT:
                    return;
            }
        }
    }
    public void menu(){
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
        System.out.print(message);
        return scanner.nextLine();

    }
}
