package Teori;

import java.util.LinkedList;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<Kota> Provinsi = new LinkedList<>();
        Kota malang = new Kota(101, 120, "malang");
        Kota Gresik = new Kota(201, 130, "gresik");
        Kota surabaya = new Kota(230, 320, "surabaya");
        Kota lamongan = new Kota(330, 320, "lamongan");
        // for (Kota kota : Provinsi) {
        // System.out.print(kota.koorDinatX + " ");
        // System.out.print(kota.koorDinaty + " ");
        // System.out.print(kota.nama);
        // System.out.println();
        // }
        Stack<Kota> jalanJalan1 = new Stack<Kota>();
        Stack<Kota> jalanJalan2 = new Stack<Kota>();
        jalanJalan1.add(Provinsi.get(0));
        jalanJalan1.add(Provinsi.get(1));
        jalanJalan1.add(Provinsi.get(2));
        jalanJalan2.add(Provinsi.get(0));
        jalanJalan2.add(Provinsi.get(3));
        jalanJalan2.add(Provinsi.get(2));
        double jarak1 = euclideanDistance(jalanJalan1);
        double jarak2 = euclideanDistance(jalanJalan2);
        System.out.println(jarak1);
        System.out.println(jarak2);
    }

    public static double euclideanDistance(Stack<Kota> tour) {
        double total = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            double jarak = Math.sqrt(
                    Math.pow(Math.abs(tour.get(i).koorDinatX - tour.get(i + 1).koorDinatX), 2)
                            + Math.pow(Math.abs(tour.get(i).koorDinaty - tour.get(i + 1).koorDinaty), 2));
            total += jarak;
        }
        return total;
    }

}
