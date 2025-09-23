package Teori;

import java.util.LinkedList;

public class Kota {
    int koorDinatX;
    int koorDinaty;
    String nama;

    public Kota(int koorDinatX, int koorDinaty, String nama) {
        this.koorDinatX = koorDinatX;
        this.koorDinaty = koorDinaty;
        this.nama = nama;
    }

    public String toString() {
        return nama + " " + koorDinatX + " " + koorDinaty;
    }

    public int getKoordinatx() {
        return this.koorDinatX;
    }

    public int getKoordinaty() {
        return this.koorDinaty;
    }

}
