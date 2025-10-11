package com.DsaProject.IntPack;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class StreamPracticeData {

    // ========== BEGINNER LEVEL DATA ==========

    // Simple number lists
    public static List<Integer> getNumbers() {
        return Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }

    public static List<Integer> getMixedNumbers() {
        return Arrays.asList(15, 8, 23, 4, 42, 16, 7, 31, 12, 50, 3, 19);
    }

    // Simple string lists
    public static List<String> getFruits() {
        return Arrays.asList("Apple", "Banana", "Cherry", "Date", "Elderberry",
                "Fig", "Grape", "Honeydew", "apple", "BANANA");
    }

    public static List<String> getWords() {
        return Arrays.asList("hello", "world", "java", "stream", "api",
                "functional", "programming", "lambda");
    }

    // ========== INTERMEDIATE LEVEL DATA ==========

    public static class Employee {
        private int id;
        private String name;
        private int age;
        private String department;
        private double salary;
        private String city;

        public Employee(int id, String name, int age, String department, double salary, String city) {
            this.id = id;
            this.name = name;
            this.age = age;
            this.department = department;
            this.salary = salary;
            this.city = city;
        }

        // Getters
        public int getId() { return id; }
        public String getName() { return name; }
        public int getAge() { return age; }
        public String getDepartment() { return department; }
        public double getSalary() { return salary; }
        public String getCity() { return city; }

        @Override
        public String toString() {
            return String.format("Employee{id=%d, name='%s', age=%d, dept='%s', salary=%.2f, city='%s'}",
                    id, name, age, department, salary, city);
        }
    }

    public static List<Employee> getEmployees() {
        return Arrays.asList(
                new Employee(1, "Alice Johnson", 28, "IT", 75000, "New York"),
                new Employee(2, "Bob Smith", 35, "HR", 65000, "Los Angeles"),
                new Employee(3, "Charlie Brown", 42, "IT", 95000, "New York"),
                new Employee(4, "Diana Prince", 31, "Finance", 80000, "Chicago"),
                new Employee(5, "Eve Davis", 26, "IT", 70000, "San Francisco"),
                new Employee(6, "Frank Miller", 45, "HR", 72000, "New York"),
                new Employee(7, "Grace Lee", 33, "Finance", 88000, "Chicago"),
                new Employee(8, "Henry Wilson", 29, "IT", 78000, "San Francisco"),
                new Employee(9, "Ivy Chen", 38, "Marketing", 82000, "Los Angeles"),
                new Employee(10, "Jack Taylor", 27, "Marketing", 68000, "New York"),
                new Employee(11, "Kate Anderson", 41, "Finance", 92000, "Chicago"),
                new Employee(12, "Leo Martinez", 30, "IT", 76000, "San Francisco")
        );
    }

    // ========== ADVANCED LEVEL DATA ==========

    public static class Product {
        private int id;
        private String name;
        private String category;
        private double price;
        private int stock;
        private double rating;

        public Product(int id, String name, String category, double price, int stock, double rating) {
            this.id = id;
            this.name = name;
            this.category = category;
            this.price = price;
            this.stock = stock;
            this.rating = rating;
        }

        public int getId() { return id; }
        public String getName() { return name; }
        public String getCategory() { return category; }
        public double getPrice() { return price; }
        public int getStock() { return stock; }
        public double getRating() { return rating; }

        @Override
        public String toString() {
            return String.format("Product{id=%d, name='%s', category='%s', price=%.2f, stock=%d, rating=%.1f}",
                    id, name, category, price, stock, rating);
        }
    }

    public static List<Product> getProducts() {
        return Arrays.asList(
                new Product(101, "Laptop", "Electronics", 899.99, 15, 4.5),
                new Product(102, "Mouse", "Electronics", 25.99, 50, 4.2),
                new Product(103, "Desk Chair", "Furniture", 199.99, 8, 4.7),
                new Product(104, "Monitor", "Electronics", 299.99, 12, 4.6),
                new Product(105, "Keyboard", "Electronics", 79.99, 30, 4.3),
                new Product(106, "Bookshelf", "Furniture", 149.99, 5, 4.1),
                new Product(107, "Desk Lamp", "Furniture", 45.99, 20, 4.4),
                new Product(108, "Webcam", "Electronics", 89.99, 18, 4.0),
                new Product(109, "Standing Desk", "Furniture", 399.99, 3, 4.8),
                new Product(110, "Headphones", "Electronics", 129.99, 25, 4.5)
        );
    }

    public static class Transaction {
        private int id;
        private int customerId;
        private int productId;
        private int quantity;
        private double amount;
        private LocalDate date;
        private String paymentMethod;

        public Transaction(int id, int customerId, int productId, int quantity,
                           double amount, LocalDate date, String paymentMethod) {
            this.id = id;
            this.customerId = customerId;
            this.productId = productId;
            this.quantity = quantity;
            this.amount = amount;
            this.date = date;
            this.paymentMethod = paymentMethod;
        }

        public int getId() { return id; }
        public int getCustomerId() { return customerId; }
        public int getProductId() { return productId; }
        public int getQuantity() { return quantity; }
        public double getAmount() { return amount; }
        public LocalDate getDate() { return date; }
        public String getPaymentMethod() { return paymentMethod; }

        @Override
        public String toString() {
            return String.format("Transaction{id=%d, customerId=%d, productId=%d, qty=%d, amount=%.2f, date=%s, payment='%s'}",
                    id, customerId, productId, quantity, amount, date, paymentMethod);
        }
    }

    public static List<Transaction> getTransactions() {
        return Arrays.asList(
                new Transaction(1, 501, 101, 1, 899.99, LocalDate.of(2024, 10, 1), "Credit Card"),
                new Transaction(2, 502, 102, 2, 51.98, LocalDate.of(2024, 10, 2), "PayPal"),
                new Transaction(3, 501, 105, 1, 79.99, LocalDate.of(2024, 10, 3), "Credit Card"),
                new Transaction(4, 503, 103, 1, 199.99, LocalDate.of(2024, 10, 3), "Debit Card"),
                new Transaction(5, 504, 104, 2, 599.98, LocalDate.of(2024, 10, 5), "Credit Card"),
                new Transaction(6, 502, 107, 1, 45.99, LocalDate.of(2024, 10, 6), "PayPal"),
                new Transaction(7, 505, 110, 1, 129.99, LocalDate.of(2024, 10, 7), "Credit Card"),
                new Transaction(8, 501, 102, 3, 77.97, LocalDate.of(2024, 10, 8), "Credit Card"),
                new Transaction(9, 506, 109, 1, 399.99, LocalDate.of(2024, 10, 9), "Debit Card"),
                new Transaction(10, 503, 108, 1, 89.99, LocalDate.of(2024, 10, 10), "PayPal"),
                new Transaction(11, 507, 106, 1, 149.99, LocalDate.of(2024, 10, 12), "Credit Card"),
                new Transaction(12, 504, 102, 5, 129.95, LocalDate.of(2024, 10, 13), "Debit Card")
        );
    }

    // ========== PRACTICE EXERCISES ==========

    public static void main(String[] args) {
//        System.out.println("=== BEGINNER EXERCISES ===");
//        System.out.println("1. Filter even numbers from getNumbers()");
//        System.out.println("2. Convert all fruits to uppercase");
//        System.out.println("3. Find sum of all numbers in getMixedNumbers()");
//        System.out.println("4. Count words with length > 5 in getWords()");
//        System.out.println("5. Find max number in getMixedNumbers()");

        System.out.println("\n=== INTERMEDIATE EXERCISES ===");

        System.out.println("6. Find all employees in IT department :- " + getEmployees().stream().filter(employee -> employee.getDepartment().equals("IT")).toList());

        System.out.println("7. Get average salary of all employees :- " + getEmployees().stream().mapToDouble(Employee::getSalary).average().orElse(0.0));

        System.out.println("8. Group employees by department :- " + getEmployees().stream().collect(Collectors.groupingBy(Employee::getDepartment)));

        System.out.println("9. Find top 3 highest paid employees :- " + getEmployees().stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).limit(3).toList());
        System.out.println("10. Get list of unique cities :- " + getEmployees().stream().map(Employee::getCity).distinct().toList());
        System.out.println("11. Find employees with salary > 75000 and age < 35 :- " + getEmployees().stream().filter(emp -> emp.getSalary() > 75000 && emp.getAge() < 35).toList());
//
//        System.out.println("\n=== ADVANCED EXERCISES ===");
//        System.out.println("12. Group products by category and calculate average price per category");
//        System.out.println("13. Find total revenue per customer from transactions");
//        System.out.println("14. Get products with rating >= 4.5 sorted by price descending");
//        System.out.println("15. Find most popular payment method");
//        System.out.println("16. Calculate total quantity sold per product");
//        System.out.println("17. Find employees with above-average salary in their department");
//        System.out.println("18. Get top 2 products by rating in each category");
//        System.out.println("19. Find customers who made purchases on multiple days");
//        System.out.println("20. Create a map of department -> list of employee names sorted alphabetically");
    }
}


