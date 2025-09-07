package Teori;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        LinkedList<Kota> Provinsi = new LinkedList<>();
        Kota malang = new Kota(101,120, "malang");
        Kota Gresik = new Kota(201,130, "gresik");
        Provinsi.add(malang);
        Provinsi.add(Gresik);
        for (Kota kota : Provinsi) {
            System.out.print(kota.koorDinatX + " ");
            System.out.print(kota.koorDinaty + " ");
            System.out.print(kota.nama);
            System.out.println();
        }
    }
}
