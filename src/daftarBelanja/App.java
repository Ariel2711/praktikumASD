package daftarBelanja;

import java.util.*;

public class App {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        Scanner scanner = new Scanner(System.in);

        int banyakInput = scanner.nextInt();
        scanner.nextLine();

        LinkedList<String> listOutput = new LinkedList<String>();

        for (int i = 0; i < banyakInput; i++) {
            if(scanner.hasNextLine()){
                String perintah = scanner.nextLine();
                String[] perintahSplit = perintah.split(" ", 3);
                
                String perintah1 = perintahSplit[0];
                String perintah2 = perintahSplit.length > 1 ? perintahSplit[1] : "";
                String perintah3 = perintahSplit.length > 2 ? perintahSplit[2] : "";

                if(perintah1.equalsIgnoreCase("INSERT")) {
                    String namaBarang = perintah.substring(perintah.indexOf(" ") + 1);
                    listOutput.add(namaBarang + " berhasil ditambahkan ke List Belanja");
                    ll.addLast(namaBarang);
                }

                if (perintah.equalsIgnoreCase("HAPUS BARANG")) {
                    if (ll.isEmpty()) {
                        listOutput.add("List Barang kosong");
                    } else {
                        listOutput.add(ll.getLast() + " berhasil dihapus dari List Belanja");
                        ll.removeLast();
                    }
                }

                if (perintah1.equalsIgnoreCase("SISIP")) {
                    int index = Integer.parseInt(perintah2);
                    if (index >= ll.size() || index < 0) {
                        listOutput.add("Index melebihi batas");
                    } else {
                        listOutput.add(perintah3 + " berhasil ditambahkan pada index ke-" + index);
                        ll.add(index, perintah3);
                    }
                }

                if (perintah1.equalsIgnoreCase("CETAK")) {
                    if (ll.isEmpty()) {
                        listOutput.add("List Barang kosong");
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Start - ");
                        for (int j = 0; j < ll.size(); j++)
                            sb.append(ll.get(j) + " - ");
                        sb.append("End");
                        listOutput.add(sb.toString());
                    }
                }
            }
        }

        for (String output : listOutput)
            System.out.println(output);

        scanner.close();
    }
}