package pengirimanKilat;
import java.util.*;

public class App {
    public static void main(String[] args) {
        LinkedList<String> ll = new LinkedList<String>();
        Scanner scanner = new Scanner(System.in);

        int banyakInput = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < banyakInput; i++) {
            String perintah = scanner.nextLine();

            if(perintah.startsWith("INSERT"))
                ll = insertPaket(ll, perintah);

            if(perintah.startsWith("DELETE"))
                ll = hapusPaket(ll, perintah);

            if(perintah.startsWith("SORT"))
                ll = sortJenis(ll, perintah);

            if(perintah.startsWith("SHOW"))
                showPaket(ll);
        }

        scanner.close();
    }

    public static LinkedList<String> insertPaket (LinkedList<String> ll, String perintah){
        String[] perintahSplit = perintah.split(" ", 3);
        int tipeNumber = Integer.parseInt(perintahSplit[1].replace("P", ""));
        String tipe = getTipe(tipeNumber);
        String jenis = getJenis(perintahSplit[2]);
        System.out.println("Paket " + tipe + " dengan jenis barang " + jenis + " berhasil ditambahkan ke dalam daftar pengiriman");
        ll.add(tipeNumber + " " + perintahSplit[2]);
        ll = sortPaket(ll);
        return ll;
    }

    public static LinkedList<String> hapusPaket(LinkedList<String> ll, String perintah){
        String[] perintahSplit = perintah.split(" ",2);
        int index = Integer.parseInt(perintahSplit[1])-1;
        if(ll.isEmpty()){
            System.out.println("Daftar pengiriman paket kosong");
        }else if(index < 0 || index >= ll.size()){
            System.out.println("Penghapusan paket gagal");
        }else{
            String[] paketSplit = ll.get(index).split(" ", 2);
            String tipe = getTipe(Integer.parseInt(paketSplit[0]));
            String jenis = getJenis(paketSplit[1]);
            System.out.println("Paket " + tipe + " dengan jenis barang " + jenis + " telah dihapus dari daftar pengiriman");
            ll.remove(index);
        }
        return ll;
    }

    public static void showPaket(LinkedList<String> ll){
        if(ll.isEmpty()){
            System.out.println("Daftar pengiriman paket kosong");
        }else{
            System.out.println("DAFTAR PENGIRIMAN PAKET");
            for (int i = 0; i < ll.size(); i++) {
                String[] paketSplit = ll.get(i).split(" ", 2);
                String tipe = getTipe(Integer.parseInt(paketSplit[0]));
                String jenis = getJenis(paketSplit[1]);
                System.out.println(i + 1 + ". Paket " + tipe + " Jenis " + jenis);
            }
        }
    }

    public static LinkedList<String> sortPaket (LinkedList<String> ll){
        boolean swapped = false;
        do {
            swapped = false;
            for (int i = 0; i < ll.size() - 1; i++) {
                int currentValue = Integer.parseInt(ll.get(i).split(" ", 2)[0]);
                int nextValue = Integer.parseInt(ll.get(i+1).split(" ", 2)[0]);
                if (currentValue > nextValue) {
                    swapped = true;
                    String temp = ll.get(i);
                    ll.set(i, ll.get(i + 1));
                    ll.set(i + 1, temp);
                }
            }
        } while (swapped);
        return ll;
    }

    public static LinkedList<String> sortJenis(LinkedList<String> ll, String perintah) {
        if(ll.isEmpty()){
            System.out.println("Daftar pengiriman paket kosong");
        }else{
            String[] perintahSplit = perintah.split(" ", 2);
            String[] sortOrder = perintahSplit[1].split(" ");
            boolean swapped;
            do {
                swapped = false;
                for (int i = 0; i < ll.size() - 1; i++) {
                    String jenis1 = ll.get(i).split(" ", 2)[1];
                    String jenis2 = ll.get(i + 1).split(" ", 2)[1];
                    
                    int indexJenis1 = getOrderIndex(jenis1, sortOrder);
                    int indexJenis2 = getOrderIndex(jenis2, sortOrder);
        
                    if (indexJenis1 > indexJenis2) {
                        swapped = true;
                        String temp = ll.get(i);
                        ll.set(i, ll.get(i + 1));
                        ll.set(i + 1, temp);
                    }
                }
            } while (swapped);
            sortPaket(ll);
            System.out.println("Daftar pengiriman paket berhasil diurutkan");
        }
        return ll;
    }
    
    public static int getOrderIndex(String jenis, String[] sortOrder) {
        for (int i = 0; i < sortOrder.length; i++) {
            if (sortOrder[i].equals(jenis)) {
                return i;
            }
        }
        return -1;
    }

    public static String getTipe(int tipe){
        String tipeName = "";
        switch (tipe) {
            case 1:
                tipeName = "Instant";
                break;
            case 2:
                tipeName = "Same Day";
                break;
            case 3:
                tipeName = "Express";
                break;
            case 4:
                tipeName = "Regular";
                break;
            default:
                break;
        }
        return tipeName;
    }

    public static String getJenis(String jenis){
        String jenisName = "";
        switch (jenis) {
            case "E":
                jenisName = "Elektronik";
                break;
            case "P":
                jenisName = "Pakaian";
                break;
            case "M":
                jenisName = "Makanan";
                break;
            case "D":
                jenisName = "Dokumen";
                break;
            default:
                break;
        }
        return jenisName;
    }
}