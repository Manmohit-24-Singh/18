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
            if (iter.next().getId() == taskId) {
                iter.next().setIsCompleted(true);
            }
        }
    }

    public void deleteTask(String taskId) {
        updateListHistory();

        Iterator<Task> iter = this.toDoList.iterator();

        while (iter.hasNext()) {
            if (iter.next().getId() == taskId) {
                toDoList.remove(iter.next());
            }
        }
    }

    public void editTask(String taskId, String title, boolean isCompleted) {
        updateListHistory();

        Iterator<Task> iter = this.toDoList.iterator();

        while (iter.hasNext()) {
            if (iter.next().getId() == taskId) {
                iter.next().setId(taskId);
                iter.next().setTitle(title);
                iter.next().setIsCompleted(isCompleted);
            }
        }
    }


    public List<Task> listTasks() {
        return this.toDoList;
    }

    public void updateListHistory() {
        List<Task> currentList = this.listTasks();
        this.listHistory.push(currentList);
    }

    public void undo() {
        this.toDoList = this.listHistory.pop();
    }

}