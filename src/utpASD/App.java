package utpASD;

import java.util.LinkedList;
import java.util.Scanner;

class Tamu {
    String nama;
    int indexDuduk;

    Tamu(String nama, int indexDuduk) {
        this.nama = nama;
        this.indexDuduk = indexDuduk;
    }
}

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Tamu> listTamu = new LinkedList<Tamu>();

        int banyakInput = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < banyakInput; i++) {
            if (scanner.hasNextLine()) {
                String jabatan = scanner.nextLine();
                int urutanDuduk = jabatanToInt(jabatan);
                if (urutanDuduk == -1) {
                    System.out.println("Jabatan tidak dikenal, tidak dapat dimasukkan.");

                } else {
                    Tamu tamu = new Tamu(jabatan, urutanDuduk);
                    listTamu.add(tamu);
                }
            }
        }

        listTamu = sortJabatan(listTamu);

        if (listTamu.isEmpty()) {
            System.out.println("\nPenyusup mencoba menjadi tamu!");
        } else {
            System.out.println("Jabatan Tamu:");
            for (int i = 0; i < listTamu.size(); i++) {
                System.out.print(intToJabatan(listTamu.get(i).indexDuduk));
                if (i < listTamu.size() - 1)
                    System.out.print(", ");
            }
            System.out.println();
            System.out.println();

            System.out.println("Urutan Duduk:");
            for (int i = 0; i < listTamu.size(); i++) {
                System.out.print(listTamu.get(i).nama);
                if (i < listTamu.size() - 1)
                    System.out.print(", ");
            }
        }

        scanner.close();
    }

    public static int jabatanToInt(String jabatan) {
        int index = -1;
        if (jabatan.equals("Rektor") || jabatan.equals("Wakil Rektor") || jabatan.equals("Dekan")
                || jabatan.equals("Wakil Dekan") || jabatan.equals("Beyonce")) {
            index = 0;
        } else if (jabatan.equals("Staf Akademik") || jabatan.equals("Dosen") || jabatan.equals("Kaprodi")) {
            index = 1;
        } else if (jabatan.equals("Ketua BEM") || jabatan.equals("Ketua EM") || jabatan.equals("Mahasiswa")) {
            index = 2;
        }
        return index;
    }

    public static String intToJabatan(int index) {
        String jabatan = "";
        switch (index) {
            case 0:
                jabatan = "VIP";
                break;
            case 1:
                jabatan = "Tamu Khusus";
                break;
            case 2:
                jabatan = "Reguler";
                break;
            default:
                break;
        }
        return jabatan;
    }

    private static LinkedList<Tamu> sortJabatan(LinkedList<Tamu> ll) {
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < ll.size() - 1; i++) {
                if (ll.get(i).indexDuduk > ll.get(i + 1).indexDuduk) {
                    swapped = true;
                    Tamu temp = ll.get(i);
                    ll.set(i, ll.get(i + 1));
                    ll.set(i + 1, temp);
                }
            }
        } while (swapped);
        return ll;
    }
}
