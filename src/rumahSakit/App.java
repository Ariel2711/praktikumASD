package rumahSakit;
import java.util.*;

class Pasien{
    String nama;
    int kategori;
    String kategoriString;

    Pasien(String nama, int kategori, String kategoriString){
        this.nama = nama;
        this.kategori = kategori;
        this.kategoriString = kategoriString;
    }
}

public class App {
    public static void main(String[] args) {
        Queue<Pasien> listPasien = new LinkedList<Pasien>();
        LinkedList<Pasien> llPasien = new LinkedList<Pasien>();
        Scanner scanner = new Scanner(System.in);

        int banyakInput = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < banyakInput; i++) {
            String perintah = scanner.nextLine();

            if(perintah.startsWith("ADD")){
                insertPasien(perintah, listPasien, llPasien);
            }

            if(perintah.startsWith("PROCESS")){
                processPasien(listPasien);
            }

            if(perintah.startsWith("LIST")){
                printListPasien(listPasien);
            }
        }

        scanner.close();
    }

    public static void sortPasien(Queue<Pasien> listPasien, LinkedList<Pasien> llPasien){
        listPasien.clear();
        LinkedList<Pasien> ll = new LinkedList<Pasien>();
        for(int i = llPasien.size()-1; i >= 0; i--){
            ll.add(llPasien.get(i));
        }
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < ll.size() - 1; i++) {
                if (ll.get(i).kategori > ll.get(i + 1).kategori) {
                    swapped = true;
                    Pasien temp = ll.get(i);
                    ll.set(i, ll.get(i + 1));
                    ll.set(i + 1, temp);
                }
            }
        } while (swapped);

        for(int i = ll.size()-1; i >= 0; i--){
            Pasien pasien = ll.get(i);
            listPasien.add(pasien);
        }
    }

    public static void insertPasien(String perintah, Queue<Pasien> listPasien, LinkedList<Pasien> llPasien){
        String nama = perintah.split(" ")[1];
        int kategori = Integer.parseInt(perintah.split(" ")[2]);
        String kategoriString = kategoriToString(kategori);

        Pasien pasien = new Pasien(nama, kategori, kategoriString);
        listPasien.add(pasien);
        llPasien.add(pasien);

        System.out.println("Pasien " + pasien.nama + " dengan kategori " + pasien.kategoriString + " telah ditambahkan ke dalam antrean");

        sortPasien(listPasien, llPasien);
    }

    public static String kategoriToString(int kategori){
        String kategoriString = "";
        if(kategori >= 1 && kategori <= 2){
            kategoriString = "Ringan";
        }else if(kategori >= 3 && kategori <= 4){
            kategoriString = "Sedang";
        }else if(kategori >= 5 && kategori <= 6){
            kategoriString = "Darurat";
        }else if(kategori >= 7 && kategori <= 8){
            kategoriString = "Sangat Darurat";
        }
         
        return kategoriString;
    }

    public static void processPasien(Queue<Pasien> listPasien){
        if(listPasien.isEmpty()){
            System.out.println("Tidak ada pasien dalam antrean");
        }else{
            Pasien pasien = listPasien.poll();
            System.out.println("Pasien " + pasien.nama + " dengan kategori " + pasien.kategoriString + " telah melakukan pemeriksaan");
        }
    }

    public static void printListPasien(Queue<Pasien> listPasien){
        if(listPasien.isEmpty()){
            System.out.println("Antrean kosong");
        }else{
            System.out.println("DAFTAR ANTREAN PASIEN");
            int index = 0;
            for(Pasien pasien : listPasien){
                System.out.println((index+1) + ". Pasien " + pasien.nama + " Kategori " + pasien.kategoriString);
                index++;
            }
        }
    }
}
