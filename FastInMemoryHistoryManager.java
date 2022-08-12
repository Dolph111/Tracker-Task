package learn;


import learn.model.Task;

import java.util.*;

public class FastInMemoryHistoryManager implements HistoryManager {
    private static final String ARRAY_LIST_IS_EMPTY = "История просмотренных задач пуста. Вначале просмотрите задачу";
    private static final int COUNT_OF_TASKS_IN_ARRAYLIST = 10;


    MainLinkedList listForTaskHistory = new MainLinkedList();
    Map<Task, Node> taskPositionInList = new HashMap<>();

    @Override
    public void addTask(Task task) {

        if (taskPositionInList.containsKey(task)) {
            taskPositionInList.remove(task);
        }

        Node node = listForTaskHistory.linkLast(task);
        taskPositionInList.put(task, node);
    }

    @Override
    public void remove(Task task) {
        Node node = taskPositionInList.get(task);

        taskPositionInList.remove(task);
        listForTaskHistory.remove(node);
    }


    @Override
    public List<Task> getHistory() {
        if (arrayListNotEmpty()) {
            System.out.println("История последних просмотренных задач:");
            return listForTaskHistory.getTask(taskPositionInList);
        } else {
            return null;
        }
    }

    public boolean arrayListNotEmpty() {
        if (listForTaskHistory.sizeIsNull()) {
            System.out.println(ARRAY_LIST_IS_EMPTY);
        }
        return !listForTaskHistory.sizeIsNull();
    }
}
