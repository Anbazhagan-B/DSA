package com.DsaProject.StreamPratice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.*;
import java.util.stream.Collectors;

public class MyStreams {
    public static void main(String[] args){
//        List<Employee> employee = getEmployees().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).toList();
//
//        employee.forEach(emp -> System.out.println(emp.getName() +",  "+ emp.getSalary()));

        Map<String, List<Employee>> emps = getEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment));

        for(Map.Entry<String, List<Employee>> entry : emps.entrySet())
        {
            System.out.println("Department :- " + entry.getKey());
            entry.getValue().forEach(emp -> System.out.println(emp.getName()));
            System.out.println(" Average Salary :- " + entry.getValue().stream().collect(Collectors.averagingDouble(Employee::getSalary)));
            System.out.println("---------\n");
        }
    }

    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(1, "Alice", "HR", 50000, 30, "Chennai"),
                new Employee(2, "Bob", "Finance", 60000, 35, "Bangalore"),
                new Employee(3, "Charlie", "IT", 70000, 28, "Hyderabad"),
                new Employee(4, "David", "IT", 80000, 40, "Chennai"),
                new Employee(5, "Eva", "Finance", 55000, 25, "Pune"),
                new Employee(6, "Frank", "HR", 52000, 38, "Mumbai"),
                new Employee(7, "Grace", "IT", 90000, 32, "Bangalore"),
                new Employee(8, "Hannah", "Marketing", 48000, 29, "Hyderabad"),
                new Employee(9, "Ian", "Marketing", 47000, 31, "Chennai"),
                new Employee(10, "Jack", "Finance", 62000, 27, "Pune")
        );
    }
}
