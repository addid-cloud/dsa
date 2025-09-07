import java.util.*;

public class Kmean {
    private Map<String, Map<String, Integer>> wordCounts; // kategori -> (kata -> jumlah)
    private Map<String, Integer> categoryCounts;          // kategori -> jumlah teks
    private Set<String> vocabulary;                       // semua kata unik
    private int totalDocs;

    public Kmean() {
        wordCounts = new HashMap<>();
        categoryCounts = new HashMap<>();
        vocabulary = new HashSet<>();
        totalDocs = 0;
    }

    // Training
    public void train(String category, String text) {
        categoryCounts.put(category, categoryCounts.getOrDefault(category, 0) + 1);
        wordCounts.putIfAbsent(category, new HashMap<>());

        for (String word : text.toLowerCase().split("\\s+")) {
            vocabulary.add(word);
            Map<String, Integer> counts = wordCounts.get(category);
            counts.put(word, counts.getOrDefault(word, 0) + 1);
        }

        totalDocs++;
    }

    // Prediksi kategori teks
    public String predict(String text) {
        double bestScore = Double.NEGATIVE_INFINITY;
        String bestCategory = null;

        for (String category : categoryCounts.keySet()) {
            double score = Math.log((double) categoryCounts.get(category) / totalDocs);

            for (String word : text.toLowerCase().split("\\s+")) {
                int wordCount = wordCounts.get(category).getOrDefault(word, 0);
                int totalWordsInCategory = wordCounts.get(category).values().stream().mapToInt(Integer::intValue).sum();

                // Laplace smoothing
                double wordProb = (wordCount + 1.0) / (totalWordsInCategory + vocabulary.size());
                score += Math.log(wordProb);
            }

            if (score > bestScore) {
                bestScore = score;
                bestCategory = category;
            }
        }

        return bestCategory;
    }

    public static void main(String[] args) {
        Kmean nb = new Kmean();

        // === Dataset Latih (manual label) ===
        nb.train("Positive", "saya sangat senang dengan produk ini");
        nb.train("Positive", "kualitasnya mantap saya suka");
        nb.train("Neutral", "produk sesuai deskripsi oke lah");
        nb.train("Negative", "pelayanan buruk sekali");
        nb.train("Negative", "pengiriman lambat dan mengecewakan");
        nb.train("Neutral", "biasa saja tidak terlalu bagus tapi tidak jelek");

        // === Data Uji ===
        String[] tests = {
            "saya sangat senang dengan produk ini",
            "pelayanan buruk sekali",
            "biasa saja tidak terlalu bagus tapi tidak jelek",
            "kualitasnya mantap saya suka",
            "pengiriman lambat dan mengecewakan",
            "produk sesuai deskripsi oke lah"
        };

        for (String t : tests) {
            System.out.println("Teks: \"" + t + "\" --> " + nb.predict(t));
        }
    }
}

