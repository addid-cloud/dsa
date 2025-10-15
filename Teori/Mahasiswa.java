package Teori;

import java.util.ArrayList;
import java.util.HashMap;

public class Mahasiswa {
    public static void main(String[] args) {
        HashMap<String, String> mahasiswa = new HashMap<>();
        mahasiswa.put("240605110082", "addid");
        HashMap<String, ArrayList<Double>> nilai_tugas = new HashMap<>();
        ArrayList<Double> nilai1 = new ArrayList<>();
        nilai1.add(90.0);
        nilai1.add(80.0);
        nilai1.add(100.0);
        nilai1.add(100.0);
        nilai_tugas.put("240605110082", nilai1);
        HashMap<String, Double> nilai_uts = new HashMap<>();
        nilai_uts.put("240605110082", 100.0);
        HashMap<String, Double> nilai_uas = new HashMap<>();
        nilai_uas.put("240605110082", 100.0);
        HashMap<String, ArrayList<Double>> totNilai = new HashMap<>();
        ArrayList<Double> nilai24 = new ArrayList<>();
        nilai24.add(avgNilai(nilai_tugas, "240605110082") * 0.45);
        nilai24.add(nilai_uts.get("240605110082") * 0.25);
        nilai24.add(nilai_uas.get("240605110082") * 0.30);
        totNilai.put("240605110082", nilai24);
        // System.out.println(avgNilai(nilai_tugas, "240605110082"));
        double hasil = avgNilai(totNilai, "240605110082");
        System.out.println(hasil);
        System.out.println(convtNilai(hasil));

    }

    public static double avgNilai(HashMap nilai, String nim) {
        double hasil = 0;
        double totNilai = 0;
        ArrayList<Double> nilaiMhs = new ArrayList<>();
        nilaiMhs = (ArrayList<Double>) nilai.get(nim);
        for (int i = 0; i < nilaiMhs.size(); i++) {
            totNilai += nilaiMhs.get(i);
        }
        hasil = totNilai / nilaiMhs.size();
        return hasil;
    }

    public static String convtNilai(double nilai) {
        String hasil = "E";
        if (nilai >= 35) {
            hasil = "A";
        } else if (nilai <= 34 && nilai >= 30) {
            hasil = "B";
        } else if (nilai <= 29 && nilai >= 25) {
            hasil = "C";
        } else if (nilai <= 24 && nilai >= 20) {
            hasil = "D";
        }
        return hasil;
    }
}
