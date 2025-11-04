package UTS;

import java.util.LinkedList;

class Kamus {
    String kataId;
    String kataEn;

    public Kamus(String kataId, String kataEn) {
        this.kataEn = kataEn;
        this.kataId = kataId;
    }
}

public class KamusApp {
    public static void main(String[] args) {
        LinkedList<Kamus> data = new LinkedList<>();
        data.add(new Kamus("api", "fire"));

    }

    public static void tambahData(String kataEn, String kataId, LinkedList<Kamus> data) {
        data.add(new Kamus(kataId, kataEn));
    }

    public static String findKata(String target, LinkedList<Kamus> data) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).kataId.toLowerCase().compareTo(target.toLowerCase()) == 0) {
                return data.get(i).kataEn;
            }
        }
        return "kata tidak terdaftar dalam kamus";
    }

    public static void removeData(String target, LinkedList<Kamus> data) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i).kataId.toLowerCase().compareTo(target.toLowerCase()) == 0) {
                data.remove(i);
            }
        }
    }

}
