/**
 * @author      Sabrina Li <a href="mailto:sabrina.li1@ucalgary.ca">sabrina.li1@ucalgary.ca</a>
 * @version     1.0
 * @since       1.0
*/

package edu.ucalgary.oop;

import java.util.*;

public class ToDoList implements IToDoList {
    private List<Task> toDoList;
    private Stack<List<Task>> listHistory;

    
    public void addTask(Task taskToAdd) {
        updateListHistory();

        this.toDoList.add(taskToAdd);
    }

    public void completeTask(String id) {
        updateListHistory();

        Iterator<Task> iter = this.toDoList.iterator();

        while (iter.hasNext()) {
            if (iter.next().getId() == id) {
                iter.next().setIsCompleted(true);
            }
        }
    }

    public void deleteTask(String taskToDelete) {
        updateListHistory();

        this.toDoList.remove(taskToDelete);
    }

    public void editTask(String id, String title, boolean isCompleted) {}
    // need updateListHistory(), edit stuff


    public List<Task> listTasks() {
        return this.toDoList;
    }

    public void updateListHistory() {
        List<Task> currentList = this.listTasks();
        this.listHistory.push(currentList);
    }

    public void undo() {
    }

}