package com.DsaProject.IntPack.curated;

import java.time.LocalDate;

public class Employee {
    private int id;
    private String name;
    private LocalDate dateOfJoining;
    private LocalDate dateOfBirth;
    int age;

    public Employee(int id, String name, int age, LocalDate doj, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.dateOfJoining = doj;
        this.age = age;
        this.dateOfBirth = dob;
    }

    // Getters
    public int getId() { return id; }
    public String getName() { return name; }
    public LocalDate getDateOfJoining() { return dateOfJoining; }
    public LocalDate getDateOfBirth() { return dateOfBirth; }
    public int getAge() {return age; }

    public void setAge(int age) {
        this.age = age;
    }
}

