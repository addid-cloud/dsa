package UTS;

import java.util.ArrayList;
import java.util.Scanner;

class Dosen {
    int NIP;
    String nama;

    public Dosen(int NIP, String nama) {
        this.NIP = NIP;
        this.nama = nama;
    }
}

public class Contoh {
    public static void main(String[] args) {
        ArrayList<Dosen> data = new ArrayList<>();
        boolean stop = false;
        Scanner sc = new Scanner(System.in);
        int menu;
        while (!stop) {
            System.out.println("==========================================");
            System.out.println("masukan menu : ");
            System.out.println("1. tambah data");
            System.out.println("2. tampilkan data");
            System.out.println("3. Sort data");
            System.out.println("==========================================");
            menu = sc.nextInt();
            if (menu == 0) {
                stop = true;
                break;
            } else if (menu == 1) {
                System.out.println("masukan nip");
                int nip = sc.nextInt();
                sc.nextLine();
                System.out.println("masukan nama");
                String nama = sc.nextLine();
                data.add(new Dosen(nip, nama));
            } else if (menu == 2) {
                for (int i = 0; i < data.size(); i++) {
                    System.out.println(data.get(i).nama + " " + data.get(i).NIP);
                }
            } else if (menu == 3) {
                Dosen temp;
                for (int i = data.size(); i > 0; i--) {
                    for (int j = 0; j < data.size() - 1; j++) {
                        if (data.get(j).nama.compareTo(data.get(j + 1).nama) > 0) {
                            temp = data.get(j);
                            data.set(j, data.get(j + 1));
                            data.set(j + 1, temp);
                        }
                    }
                }
            }
        }
    }
}
