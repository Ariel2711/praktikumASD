package sorting;

import java.util.LinkedList;

public class selection {
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(7);
        ll.addLast(6);
        ll.addLast(10);
        ll.addLast(5);

        selectionSort(ll);

    }

    private static void selectionSort(LinkedList<Integer> ll) {
        for (int i = 0; i < ll.size() - 1; i++) {
            // Temukan elemen terkecil dalam array yang belum terurut
            int minIndex = i;
            for (int j = i + 1; j < ll.size(); j++) {
                if (ll.get(j) < ll.get(minIndex)) {
                    minIndex = j;
                }
            }

            // Tukar elemen terkecil dengan elemen pertama yang belum terurut
            int temp = ll.get(minIndex);
            ll.set(minIndex, ll.get(i));
            ll.set(i, temp);
            // System.out.println(ll);
        }
        System.out.println(ll);
    }
}
