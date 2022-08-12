package learn;

import learn.model.Task;
import java.util.List;

public interface HistoryManager {
    void addTask(Task task);
    void remove(Task id);
    List<Task> getHistory();
}


