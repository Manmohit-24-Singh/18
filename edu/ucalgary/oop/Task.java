package edu.ucalgary.oop;

import java.util.Objects;

//• The Task class should include properties for id, title, and isCompleted.
//• You must implement a copy method for deep copying task objects.

public class Task {

    private int id;
    private String title;
    private boolean isCompleted;


    // Constructor
    public Task(int id, String title, boolean isCompleted){
        this.id = id;
        this.title = title;
        this.isCompleted = isCompleted;
    }


    // Getters
    public int getId(){
        return this.id;
    }
    public String getTitle(){
        return this.title;
    }
    public boolean getIsCompleted(){
        return this.isCompleted;
    }

    // Setters
    public void setId(int id){
        this.id = id;
    }
    public void setTitle(String title){
        this.title = title;
    }
    public void setIsCompleted(boolean isCompleted){
        this.isCompleted = isCompleted;
    }

    // Deep Copy
    public Task copy() {
        return new Task(this.id, this.title, this.isCompleted);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Task task = (Task) obj;
        return Objects.equals(id, task.id) &&
               Objects.equals(title, task.title) &&
               isCompleted == task.isCompleted; 
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, isCompleted);
    }
}
