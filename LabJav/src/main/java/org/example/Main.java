package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static final Scanner scanner = new Scanner(System.in);
    public static final Saver saver = new Saver();
    public static boolean isEnd = false;

    public static void main(String[] args) {
        Students studentList = saver.readFromFile();
        if (studentList == null) {
            studentList = new Students();
        }
        while (!isEnd) {
            printMainMenu();
            handleMainMenuInput(studentList);
        }
        saver.writeToFile(studentList);
    }

    public static void printMainMenu() {
        System.out.println("Menu");
        System.out.println("1. Add Student");
        System.out.println("2. Remove Student");
        System.out.println("3. Generate a report");
        System.out.println("4. Search");
        System.out.println("5. Exit");
    }

    public static void handleMainMenuInput(Students studentList) {
        String input;
        List<String> possibleInputs = Arrays.asList("1", "2", "3", "4", "5");
        while (true) {
            input = scanner.nextLine();
            if (possibleInputs.contains(input)) {
                break;
            } else {
                System.out.println("Enter a number from 1 to 5");
            }
        }
        switch (input) {
            case "1":
                studentList.add();
                break;
            case "2":
                studentList.remove();
                break;
            case "3":
                saver.createAReport(studentList);
                break;
            case "4":
                studentList.searchAndShowStudent();
                break;
            case "5":
                isEnd = true;
                break;
        }
    }
}
