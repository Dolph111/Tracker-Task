package learn;

import learn.model.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainLinkedList {
    private Node first = null;
    private Node last = null;

    private int count = 0;

    public int getCount() {

        return count;
    }

    public Node linkLast(Task task) {
        Node node = new Node();
        if (first == null) {
            node.task = task;
            node.next = null;
            node.prev = null;

            first = node;
            last = node;
            count = 1;

            return node;
        } else {
            node.task = task;
            node.next = null;
            node.prev = null;

            last.next = node;
            node.prev = last;
            last = node;
            count++;

            return node;
        }
    }

   // public Node get(Integer position);
   // public void remove(Integer position);
   // public void print();

    /*public Node getTask(Integer position) {
        if (count / position > 2) {
            // left side,from beginning
            int currentPosition = 0;
            Node current = first;

            while(currentPosition != position) {
                current = current.next;
                currentPosition++;
            }

            return current;
        } else {
            // right side, from end
            int currentPosition = count - 1;
            Node current = last;

            while (currentPosition != position) {
                current = current.prev;
                currentPosition--;
            }

            return current;
        }
    }*/

    public List<Task> getTask(Map<Task, Node> taskPositionInList) {
        List<Task> historyListOfTask = new ArrayList<>();
        historyListOfTask.addAll(taskPositionInList.keySet());
        return historyListOfTask;
    }

    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;

        prev.next = next;
        next.prev = prev;
    }

    public boolean sizeIsNull() {
        if (count == 0) {
            return true;
        } else {
            return false;
        }
    }
}
