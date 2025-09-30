package Teori;

import java.util.LinkedList;
import java.util.Random;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        LinkedList<Kota> Provinsi = new LinkedList<>();
        Kota malang = new Kota(101, 120, "malang");
        Kota gresik = new Kota(201, 130, "gresik");
        Kota surabaya = new Kota(230, 320, "surabaya");
        Kota lamongan = new Kota(330, 320, "lamongan");
        Provinsi.add(malang);
        Provinsi.add(gresik);
        Provinsi.add(surabaya);
        Provinsi.add(lamongan);
        Stack<Kota> jalanJalan1 = new Stack<>();
        // Stack<Kota> jalanJalan2 = new Stack<>();
        FisherYates(Provinsi);
        jalanJalan1.add(Provinsi.get(0));
        jalanJalan1.add(Provinsi.get(1));
        jalanJalan1.add(Provinsi.get(2));
        // FisherYates(Provinsi);
        // jalanJalan2.add(Provinsi.get(0));
        // jalanJalan2.add(Provinsi.get(1));
        // jalanJalan2.add(Provinsi.get(2));
        double jarak1 = euclideanDistance(jalanJalan1);
        // double jarak2 = euclideanDistance(jalanJalan2);

        System.out.println("Tour 1: " + jalanJalan1);
        // System.out.println("Tour 2: " + jalanJalan2);
        System.out.println("Jarak Tour 1 = " + jarak1);
        // System.out.println("Jarak Tour 2 = " + jarak2);
    }

    public static void FisherYates(LinkedList<Kota> list) {
        Random rand = new Random();
        for (int i = list.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Kota temp = list.get(i);
            list.set(i, list.get(j));
            list.set(j, temp);
        }
    }

    public static double euclideanDistance(Stack<Kota> tour) {
        double total = 0;
        for (int i = 0; i < tour.size() - 1; i++) {
            double jarak = Math.sqrt(
                    Math.pow(tour.get(i).koorDinatX - tour.get(i + 1).koorDinatX, 2)
                            + Math.pow(tour.get(i).koorDinaty - tour.get(i + 1).koorDinaty, 2));
            total += jarak;
        }
        return total;
    }
}
