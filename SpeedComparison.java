package learn;

import learn.model.Task;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SpeedComparison {
    List<Task> tasks = new ArrayList<>();
    List<Integer> randomIds = new ArrayList<>();

    InMemoryHistoryManager slow = new InMemoryHistoryManager();
    FastInMemoryHistoryManager fast = new FastInMemoryHistoryManager();

    public void testSpeed() {
        int taskCount = 10000;
        int iterationCount = 1000000;

        for (int i = 0; i < taskCount; i++) {
            Task task = new Task();
            task.name = "Task" + i;
            tasks.add(task);
        }

        Random random = new Random();
        for (int i = 0; i <iterationCount ; i++) {
            randomIds.add(random.nextInt(taskCount));
        }

        Instant before;

        before = Instant.now();
        for (int i = 0; i < iterationCount; i++) {
            slow.addTask(tasks.get(randomIds.get(i)));
        }
        System.out.println(Instant.now().compareTo(before));

        before = Instant.now();
        for (int i = 0; i < iterationCount; i++) {
            fast.addTask(tasks.get(randomIds.get(i)));
        }
        System.out.println(Instant.now().compareTo(before));
    }
}
