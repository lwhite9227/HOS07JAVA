/*----------------------------------------------------------------------------------------
 * Copyright (c) Microsoft Corporation. All rights reserved.
 * Licensed under the MIT License. See LICENSE in the project root for license information.
 *---------------------------------------------------------------------------------------*/
package com.mycompany.app;

// Enum to represent task priority levels
enum TaskPriority {
    LOW, MEDIUM, HIGH;

    @Override
    public String toString() {
       return name().charAt(0) + name().substring(1).toLowerCase();
    }    
}

// A simple Task class with a generic type
class Task {
    private String name;
    private TaskPriority priority;

    public Task(String name, TaskPriority priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public TaskPriority getPriority() {
        return priority;
    }

    @Override
    public String toString() {
        return "Task{name='" + name + "', priority=" + priority + "}";
    }
}

class TaskManager<T> {
    private Object[] tasks;
    private int size = 0;
    private int capacity = 10;

    public TaskManager() {
        this.tasks = new Object[this.capacity];
    }

    public TaskManager(int capacity) {
        this.capacity = capacity > 0 ? capacity : 10;
        this.tasks = new Object[this.capacity];
    }

    public void addTask(T task) {
        if (size < capacity) {
            tasks[size++] = task;
            System.out.println("Added: " + task);
        } else {
            System.out.println("Cannot add tasks. Capacity full.");
        }
    }

    public void showAllTasks() {
        System.out.println("All Tasks:");
        for (int i = 0; i < size; i++) {
            @SuppressWarnings("unchecked")
            T task = (T) tasks[i];
            System.out.println(task);
        }
    }
}


public class App {
    public static void main(String[] args) {
        TaskManager<Task> manager = new TaskManager<>(5);

        Task t1 = new Task("Submit project", TaskPriority.HIGH);
        Task t2 = new Task("Reply to emails", TaskPriority.MEDIUM);
        Task t3 = new Task("Organize desk", TaskPriority.LOW);

        manager.addTask(t1);
        manager.addTask(t2);
        manager.addTask(t3);
        
        
        manager.showAllTasks();
    }
}        
