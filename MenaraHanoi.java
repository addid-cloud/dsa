public class MenaraHanoi {

    public static void doMenara(int cakram, char asal, char tujuan, char bantu) {
        if (cakram == 1) {
            System.out.println("Pindahkan cakram 1 dari " + asal + " ke " + tujuan);
        } else {
            doMenara(cakram - 1, asal, bantu, tujuan);
            System.out.println("Pindahkan cakram " + cakram + " dari " + asal + " ke " + tujuan);
            doMenara(cakram - 1, bantu, tujuan, asal);
        }
    }

    public static void main(String[] args) {
        int jumlahCakram = 3; 

        System.out.println("=== Permainan Menara Hanoi dengan " + jumlahCakram + " cakram ===");
        doMenara(jumlahCakram, 'A', 'C', 'B'); 
    }
}
