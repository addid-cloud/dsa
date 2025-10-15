package Praktikum.modul5;

public class MenaraHanoi {

    public static void doMenara(int n, char asal, char tujuan, char bantu) {
        if (n == 1) {
            System.out.println("Pindahkan cakram 1 dari " + asal + " ke " + tujuan);
            return;
        }
        doMenara(n - 1, asal, bantu, tujuan);
        System.out.println("Pindahkan cakram " + n + " dari " + asal + " ke " + tujuan);
        doMenara(n - 1, bantu, tujuan, asal);
    }

    public static void main(String[] args) {
        int jumlahCakram = 3;
        System.out.println("Solusi Menara Hanoi dengan " + jumlahCakram + " cakram:");
        doMenara(jumlahCakram, 'A', 'C', 'B');
    }
}
