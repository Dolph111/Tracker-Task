package learn;

public class IdGenerator {
    static int currentId = 1;

    public static int nextId() {

        return currentId++;
    }
}
