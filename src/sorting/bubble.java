package sorting;

import java.util.LinkedList;

public class bubble {
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(3);
        ll.addLast(2);
        ll.addLast(1);
        ll.addLast(5);

        bubbleSort(ll);

    }

    private static void bubbleSort(LinkedList<Integer> ll) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < ll.size() - 1; i++) {
                if (ll.get(i) > ll.get(i + 1)) {
                    swapped = true;
                    int temp = ll.get(i);
                    ll.set(i, ll.get(i + 1));
                    ll.set(i + 1, temp);
                }
                // System.out.println(ll);
            }
        } while (swapped);
        System.out.println(ll);
    }
}
