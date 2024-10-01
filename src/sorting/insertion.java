package sorting;

import java.util.LinkedList;

public class insertion {
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(13);
        ll.addLast(20);
        ll.addLast(1);
        ll.addLast(5);

        insertionSort(ll);

    }

    private static void insertionSort(LinkedList<Integer> ll) {
        for (int i = 1; i < ll.size(); i++) {
            int key = ll.get(i);
            int j = i - 1;

            // Memindahkan elemen yang lebih besar dari key ke posisi yang tepat
            while (j >= 0 && ll.get(j) > key) {
                ll.set(j + 1, ll.get(j));
                j--;
            }
            ll.set(j + 1, key);
            // System.out.println(ll);
        }
        System.out.println(ll);
    }
}
