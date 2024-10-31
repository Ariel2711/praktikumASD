package SimpleStack;
import java.util.*;

public class App {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<Integer>();
        Scanner scanner = new Scanner(System.in);
    
        int banyakInput = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < banyakInput; i++) {
            String perintah = scanner.nextLine();

            if(perintah.startsWith("TARUH")){
                int angka = Integer.parseInt(perintah.split(" ")[1]);
                s.push(angka);
            }

            if(perintah.startsWith("AMBIL")){
                if(s.isEmpty()){
                    System.out.println("tidak ada bilangan yang diambil");
                }else{
                    int angka = s.pop();
                    System.out.println("bilangan " + angka + " telah diambil");
                }
            }

            if(perintah.startsWith("LIHAT")){
                if(s.isEmpty()){
                    System.out.println("stack kosong");
                }else{
                    for (int j = 0; j < s.size(); j++) {
                        System.out.print(s.get(j));
                        if(j < s.size()-1) System.out.print(", ");
                    }
                    System.out.println();
                }
            }
        }

        scanner.close();
    }
}
