package org.example;

import java.io.Serializable;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Students implements Serializable {
    private List<StudentClass> students = new ArrayList<>();

    public void add() {
        StudentClass student = new StudentClass();
        System.out.println("Enter name");
        student.setName(Main.scanner.nextLine());
        System.out.println("Enter ID");
        student.setID(Main.scanner.nextLine());
        System.out.println("Enter email");
        student.setEmail(Main.scanner.nextLine());
        try {
            System.out.println("Enter year of birth");
            int year = Main.scanner.nextInt();
            System.out.println("Enter month of birth");
            int month = Main.scanner.nextInt();
            System.out.println("Enter day of birth");
            int day = Main.scanner.nextInt();
            Main.scanner.nextLine(); // Consume the remaining newline character
            student.setDOB(LocalDate.of(year, month, day));
            students.add(student);
            Main.logger.info("Student added!");
        } catch (DateTimeException e) {
            Main.logger.info("Invalid date");
        } catch (InputMismatchException e) {
            Main.logger.info("Incorrect input");
            Main.scanner.nextLine(); // Consume the invalid input
        }
    }

    public void remove() {
        System.out.println("Enter ID of student");
        String id = Main.scanner.nextLine();
        try {
            StudentClass searchedStudent = search(id);
            if (searchedStudent != null) {
                students.remove(searchedStudent);
                Main.logger.info("Student deleted");
            } else {
                Main.logger.info("Student not found");
            }
        } catch (Exception e) {
            Main.logger.info("Error occurred while removing student");
        }
    }

    public StudentClass search(String id) {
        try {
            return students.stream()
                    .filter(student -> student.getID().equals(id))
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            return null;
        }
    }

    public void searchAndShowStudent() {
        System.out.println("Enter ID of student");
        String id = Main.scanner.nextLine();
        try {
            StudentClass foundStudent = search(id);
            if (foundStudent != null) {
                System.out.println(foundStudent);
            } else {
                System.out.println("Student not found");
            }
        } catch (Exception e) {
            System.out.println("Error occurred while searching for student");
        }
    }

    public List<StudentClass> getStudents() {
        return students;
    }
}