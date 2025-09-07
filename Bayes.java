public class Bayes {
    public static void main(String[] args) {
        String data[][]={
            {"cerah","panas"},
            {"cerah","sejuk"},
            {"hujan","sejuk"},
            {"hujan","dingin"},
            {"mendung","sejuk"},
        };
        String dataTes[] = {"cerah","dingin"};
        String label[] = {"tidak","ya","ya","tidak","ya"};
        double prior[] = new double[2];
        // hitung prior
        for (int i = 0; i < label.length; i++) {
            if(label[i] == "ya"){
                prior[0]++;
            }else{
                prior[1]++;
            }
        }
        for (int i = 0; i < prior.length; i++) {
            prior[i] = prior[i] / label.length;
        }
        // hitung likelihood
        // ya
        double cerahy = 0;
        double hujany = 0;
        double mendungy = 0;
        double panasy = 0;
        double sejuky = 0;
        double dinginy = 0;
        double ceraht = 0;
        double hujant = 0;
        double mendungt = 0;
        double panast = 0;
        double sejukt = 0;
        double dingint = 0;
        double toty = 0;
        double tott = 0;
        for (int i = 0; i < label.length; i++) {
            if(label[i] == "ya"){
                toty++;
            }else{
                tott++;
            }
        }
        for (int i = 0; i < data.length; i++) {
            if(label[i] == "ya"){
                if(data[i][0] == "cerah"){
                    cerahy++;
                }else if(data[i][0] == "hujan"){
                    hujany++;
                }else{
                    mendungy++;
                }
            }else{
                if(data[i][0] == "cerah"){
                    ceraht++;
                }else if(data[i][0] == "hujan"){
                    hujant++;
                }else{
                    mendungt++;
                }
            }
        }
        for (int i = 0; i < data.length; i++) {
            if(label[i] == "ya"){
                if(data[i][1] =="panas"){
                    panasy++;
                }else if(data[i][1] == "sejuk"){
                    sejuky++;
                }else{
                    dinginy++;
                }
            }else{
                if(data[i][1] =="panas"){
                    panast++;
                }else if(data[i][1] == "sejuk"){
                    sejukt++;
                }else{
                    dingint++;
                }

            }
        }
        double[][] likelihoodYa = {{cerahy,hujany,mendungy},{panasy,sejuky,dinginy}};
        double[][] likelihoodTidak = {{ceraht,hujant,mendungt},{panast,sejukt,dingint}};
        String[][] labelLikelihood = {{"cerah","hujan","mendung"},{"panas","sejuk","dingin"}};
        for (int i = 0; i < likelihoodYa.length; i++) {
            for (int j = 0; j < likelihoodYa[i].length; j++) {
                // System.out.println(likelihoodYa[i][j]);
            }
        }
        System.out.println("========================");
int jumlahKategoriX0 = 3; // cerah, hujan, mendung
int jumlahKategoriX1 = 3; // panas, sejuk, dingin

for (int i = 0; i < likelihoodYa.length; i++) {
    for (int j = 0; j < likelihoodYa[i].length; j++) {
        if (i == 0) { // fitur cuaca
            likelihoodYa[i][j] = (likelihoodYa[i][j] + 1) / (toty + jumlahKategoriX0);
            likelihoodTidak[i][j] = (likelihoodTidak[i][j] + 1) / (tott + jumlahKategoriX0);
        } else { // fitur suhu
            likelihoodYa[i][j] = (likelihoodYa[i][j] + 1) / (toty + jumlahKategoriX1);
            likelihoodTidak[i][j] = (likelihoodTidak[i][j] + 1) / (tott + jumlahKategoriX1);
        }
    }
}


        // for (int i = 0; i < likelihoodYa.length; i++) {
        //     for (int j = 0; j < likelihoodYa[i].length; j++) {
        //         System.out.println(likelihoodYa[i][j]);
        //         System.out.println(likelihoodTidak[i][j]);
        //     }
        // }
        // prediksi data baru
// prediksi data baru
double hasil[] = new double[2]; // [0] = ya, [1] = tidak
hasil[0] = prior[0];
hasil[1] = prior[1];

for (int i = 0; i < labelLikelihood.length; i++) {
    for (int j = 0; j < labelLikelihood[i].length; j++) {
        if (dataTes[i].equals(labelLikelihood[i][j])) {
            hasil[0] *= likelihoodYa[i][j];
            hasil[1] *= likelihoodTidak[i][j];
        }
    }
}

System.out.println("Probabilitas YA = " + hasil[0]);
System.out.println("Probabilitas TIDAK = " + hasil[1]);
System.out.println("Prediksi = " + (hasil[0] > hasil[1] ? "YA" : "TIDAK"));




    }
}