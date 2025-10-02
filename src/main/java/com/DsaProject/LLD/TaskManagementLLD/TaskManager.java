package com.DsaProject.LLD.TaskManagementLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManager {

    Map<String, Task> tasks;

    public TaskManager(){
        tasks = new HashMap<>();
    }

    public void createTask(Task task)
    {
        tasks.put(task.id, task);
    }

    public Task getTaskById(String taskID)
    {
        checkTaskExists(taskID);
        return tasks.get(taskID);
    }

    public void updateTaskStatus(String taskID, TaskStatus taskStatus)
    {
        checkTaskExists(taskID);
        tasks.get(taskID).setStatus(taskStatus);
    }
    public void assignTask(User user, String taskId)
    {
        tasks.get(taskId).setAssignee(user);
    }

    public void addComment(String taskID, String commentContent, User user){
        checkTaskExists(taskID);
        tasks.get(taskID).addComment(new Comment(commentContent, user));
    }

    public List<Task> listTaskByUser(User user)
    {
        return  tasks.values().stream().filter(task -> task.getAssignee().equals(user)).toList();
    }

    public List<Task> listTasksByStatus(TaskStatus taskStatus)
    {
        return  tasks.values().stream().filter(task -> task.getStatus().equals(taskStatus)).toList();
    }

    public void deleteTask(String taskID)
    {
        tasks.remove(taskID);
    }

    void checkTaskExists(String taskID)
    {
        if(!tasks.containsKey(taskID))
        {
            throw new RuntimeException("No task found with id :- " + taskID);
        }
    }

    public List<Task> searchTasks(String keyword)
    {
        List<Task> searchResults = new ArrayList<>();
        tasks.values().forEach(task -> {
            if(task.getTitle().contains(keyword) || task.getDescription().contains(keyword))
            {
                searchResults.add(task);
            }
        });
        return searchResults;
    }

    public static TaskManager getInstance()
    {
        return new TaskManager();
    }
}
