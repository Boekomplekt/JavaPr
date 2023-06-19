package org.example;

import java.io.Serializable;
import java.time.LocalDate;

public class StudentClass implements Serializable {
    private String name;
    private String ID;
    private String email;
    private LocalDate dOB;

    public StudentClass(String name, String studentID, String email, LocalDate dateOfBirth) {
        this.name = name;
        this.ID = studentID;
        this.email = email;
        this.dOB = dateOfBirth;
    }

    public StudentClass() {
    }

    @Override
    public String toString() {
        return this.name + "\n" + this.ID + "\n" + this.email + "\n" + this.dOB;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDOB() {
        return dOB;
    }

    public void setDOB(LocalDate dOB) {
        this.dOB = dOB;
    }
}