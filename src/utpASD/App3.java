package utpASD;

import java.util.LinkedList;
import java.util.Scanner;

public class App3 {
    public static void main(String[] args) {
        LinkedList<String> listCard = new LinkedList<>();

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String[] cardAwal = input.split(" ");

        for (String cardAwalItem : cardAwal) {
            listCard.add(cardAwalItem);
        }

        listCard = acakSelangSeling(listCard);

        if (!listCard.isEmpty()) {
            listCard = acak3x1(listCard);
        }

        StringBuilder output = new StringBuilder();
        for (String cardAktif : listCard) {
            output.append(cardAktif).append(" ");
        }
        System.out.println(output.toString().trim());

        scanner.close();
    }

    private static LinkedList<String> acakSelangSeling(LinkedList<String> card) {
        if (card.size() <= 1)
            return card;

        LinkedList<String> hasil = new LinkedList<>();
        int mid = (card.size() + 1) / 2;

        for (int i = 0; i < mid; i++) {
            hasil.add(card.get(i));
            if (mid + i < card.size()) {
                hasil.add(card.get(mid + i));
            }
        }

        return hasil;
    }

    private static LinkedList<String> acak3x1(LinkedList<String> card) {
        LinkedList<String> hasil = new LinkedList<>(card);

        for (int i = 0; i < card.size(); i++) {
            int targetIndex;
            if (i % 2 == 0) {
                targetIndex = i / 2;
            } else {
                targetIndex = (3 * i + 1) % card.size();
            }

            if (targetIndex != i) {
                String temp = hasil.get(i);
                hasil.set(i, hasil.get(targetIndex));
                hasil.set(targetIndex, temp);
            }
        }
        return hasil;
    }
}
