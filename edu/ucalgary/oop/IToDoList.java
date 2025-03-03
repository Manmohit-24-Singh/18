package edu.ucalgary.oop;

import java.util.*;

public interface IToDoList {
    void addTask(Task taskToAdd);
    void completeTask(String taskId);
    void deleteTask(String taskId);
    void editTask(String taskId, String title, boolean isCompleted);
    void undo();
    List<Task> listTasks();
}
