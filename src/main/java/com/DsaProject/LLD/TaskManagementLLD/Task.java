package com.DsaProject.LLD.TaskManagementLLD;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Task {
    String id;
    String title;
    String description;
    Date dueDate;
    TaskStatus status;
    TaskPriority priority;
    List<Comment> comments;
    List<Task> subTasks;
    User assignee;

    public Task(String title, String description, Date dueDate, TaskPriority taskPriority, User assignee)
    {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.dueDate = dueDate;
        this.priority = taskPriority;
        this.assignee = assignee;
        this.comments = new ArrayList<>();
        this.subTasks = new ArrayList<>();
    }

    public String getId()
    {
        return this.id;
    }

    public String getDescription() {
        return description;
    }

    public List<Task> getSubTasks() {
        return subTasks;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public String getTitle() {
        return title;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public void addComment(Comment comments) {
        this.comments.add(comments);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setPriority(TaskPriority priority) {
        this.priority = priority;
    }

    public void setSubTasks(List<Task> subTasks) {
        this.subTasks = subTasks;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

}
