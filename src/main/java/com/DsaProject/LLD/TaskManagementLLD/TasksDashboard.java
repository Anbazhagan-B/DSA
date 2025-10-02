package com.DsaProject.LLD.TaskManagementLLD;

import java.util.Date;
import java.util.List;

public class TasksDashboard {
    public static void main(String[] args) {
        TaskManager taskManager = TaskManager.getInstance();

        // Create users
        User user1 = new User( "John Doe", "john@example.com");
        User user2 = new User( "Jane Smith", "jane@example.com");

        // Create tasks
        Task task1 = new Task("Task 1", "Description 1", new Date(), TaskPriority.LOW, user1);
        Task task2 = new Task("Task 2", "Description 2", new Date(), TaskPriority.MEDIUM, user2);
        Task task3 = new Task("Task 3", "Description 3", new Date(), TaskPriority.HIGH, user1);

        // Add tasks to the task manager
        taskManager.createTask(task1);
        taskManager.createTask(task2);
        taskManager.createTask(task3);

        // Update a task
        task2.setDescription("Updated task2 status");
        taskManager.updateTaskStatus(task2.getId(), TaskStatus.IN_PROGRESS);
        taskManager.updateTaskStatus(task1.getId(), TaskStatus.TODO);
        taskManager.updateTaskStatus(task3.getId(), TaskStatus.TODO);

        // Search tasks
        List<Task> searchResults = taskManager.searchTasks("Task");
        System.out.println("Tasks with keyword Task:");
        for (Task task : searchResults) {
            System.out.println(task.getTitle());
        }

        // Filter tasks by status
        List<Task> filteredTasks = taskManager.listTasksByStatus(TaskStatus.TODO);
        System.out.println("TODO Tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getTitle());
        }

        // Mark a task as done
        taskManager.updateTaskStatus(task2.getId(), TaskStatus.DONE);

        // Get tasks assigned to a user
        List<Task> taskHistory = taskManager.listTaskByUser(user1);
        System.out.println("Task for " + user1.getName() + ":");
        for (Task task : taskHistory) {
            System.out.println(task.getTitle());
        }

        // Delete a task
        taskManager.deleteTask(task3.getId());
    }
}
