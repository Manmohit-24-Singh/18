public interface IToDoList {
    void addTask(Task newTask);
    void completeTask(String taskNum);
    void deleteTask(String taskNum);
    void editTask(String taskNum, String task, boolean bool);
    void undo();
    void listTasks();
}
