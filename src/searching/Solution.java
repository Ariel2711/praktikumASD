package searching;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int jumlah = scanner.nextInt();
        if (jumlah < 1 || jumlah > 100000) {
            System.out.println("Input tidak sesuai");
            return;
        }

        int[] listKode = new int[jumlah];
        for (int i = 0; i < jumlah; i++) {
            String kodeString = scanner.next();
            if (kodeString.length() != 3 || !cekKode(kodeString)) {
                System.out.println("Input tidak sesuai");
                return;
            }
            listKode[i] = Integer.parseInt(kodeString);
        }

        String targetString = scanner.next();
        if (targetString.length() != 3 || !cekKode(targetString)) {
            System.out.println("Input tidak sesuai");
            return;
        }
        int target = Integer.parseInt(targetString);

        Arrays.sort(listKode);

        int indeks = binarySearch(listKode, target);

        if (indeks == -1)
            System.out.println("Buku tidak ditemukan");
        else
            System.out.println("Buku ditemukan di indeks " + indeks);

    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int tengah = left + (right - left) / 2;

            if (arr[tengah] == target)
                return tengah;

            if (arr[tengah] < target)
                left = tengah + 1;
            else
                right = tengah - 1;
        }

        return -1;
    }

    public static boolean cekKode(String kode) {
        try {
            int value = Integer.parseInt(kode);
            return value >= 1 && value <= 999;
        } catch (Exception e) {
            return false;
        }
    }
}
