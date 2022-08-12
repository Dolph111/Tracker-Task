package learn;

import learn.model.Epic;
import learn.model.Task;

public interface TaskManager {
    void newTask();
    void addSubtask(Epic epic);
    boolean storageNotEmpty();
    void getTasks();
    void deleteAllTask();
    void getTaskForId();
    void deleteTaskForId();
    void createSubtask(Task task);
    void updateTask();
}
