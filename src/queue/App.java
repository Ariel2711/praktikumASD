package queue;
import java.util.*;

public class App {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(Collections.reverseOrder());
        q.add(1);
        q.add(3);
        q.add(2);
        q.add(5);
        q.add(4);

        System.out.println(q);
    }

}
