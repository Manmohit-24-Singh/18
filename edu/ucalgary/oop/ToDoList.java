/**
 * @author      Sabrina Li <a href="mailto:sabrina.li1@ucalgary.ca">sabrina.li1@ucalgary.ca</a>
 * @version     1.0
 * @since       1.0
*/

package edu.ucalgary.oop;

import java.util.*;

public class ToDoList implements IToDoList {
    private List<Task> toDoList = new ArrayList<>();
    private Stack<List<Task>> listHistory = new Stack<>();


    public void addTask(Task taskToAdd) {
        updateListHistory();

        this.toDoList.add(taskToAdd);
    }

    public void completeTask(String taskId) {
        updateListHistory();

        Iterator<Task> iter = this.toDoList.iterator();

        while (iter.hasNext()) {
            Task currentTask = iter.next();
            if (currentTask.getId().equals(taskId)) {
                currentTask.setIsCompleted(true);
            }
        }
    }

    public void deleteTask(String taskId) {
        updateListHistory();

        Iterator<Task> iter = this.toDoList.iterator();

        while (iter.hasNext()) {
            Task currentTask = iter.next();
            if (currentTask.getId().equals(taskId)) {
                iter.remove();
            }
        }
    }

    public void editTask(String taskId, String title, boolean isCompleted) {
        updateListHistory();

        Iterator<Task> iter = this.toDoList.iterator();

        while (iter.hasNext()) {
            Task currentTask = iter.next();
            if (currentTask.getId().equals(taskId)) {
                // currentTask.setId(taskId);
                currentTask.setTitle(title);
                currentTask.setIsCompleted(isCompleted);
            }
        }
    }


    public List<Task> listTasks() {
        return this.toDoList;
    }

    public void updateListHistory() {
        List<Task> currentList = this.listTasks();
        List<Task> currentListCopy = new ArrayList<>();

        Iterator<Task> iter = currentList.iterator();

        while (iter.hasNext()) {
            Task currentTask = iter.next();
            currentListCopy.add(currentTask.copy());
        }

        this.listHistory.push(currentListCopy);
    }

    public void undo() {
        if (!this.listHistory.isEmpty()) {
            this.toDoList = this.listHistory.pop();
        }
    }

}