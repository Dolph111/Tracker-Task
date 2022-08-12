package learn;


import learn.model.Task;

import java.util.ArrayList;
import java.util.List;

public class InMemoryHistoryManager implements HistoryManager {
    private static final String ARRAY_LIST_IS_EMPTY = "История просмотренных задач пуста. Вначале просмотрите задачу";
    private static final int COUNT_OF_TASKS_IN_ARRAYLIST = 10;

    List<Task> listForTaskHistory = new ArrayList<>();

    @Override
    public void addTask(Task task) {
        checkArrayListSize();
        checkTaskInList(task);
        listForTaskHistory.add(task);
    }

    @Override
    public void remove(Task id) {
        listForTaskHistory.remove(id);
    }

    @Override
    public List<Task> getHistory() {
        if (arrayListNotEmpty()) {
            System.out.println("История последних просмотренных задач:");
            return listForTaskHistory;
        } else {
            return null;
        }
    }

    public void checkArrayListSize() {
        if (listForTaskHistory.size() == COUNT_OF_TASKS_IN_ARRAYLIST) {
            listForTaskHistory.remove(0);
        }
    }

    public void checkTaskInList(Task task) {
        if (listForTaskHistory.contains(task)) {
            remove(task);
        }
    }

    public boolean arrayListNotEmpty() {
        if (listForTaskHistory.isEmpty()) {
            System.out.println(ARRAY_LIST_IS_EMPTY);
        }
        return !listForTaskHistory.isEmpty();
    }
}
