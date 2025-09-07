public class OldPhone {

    public static void main(String[] args) {
        // try case
        // 2 = abc, 3 = def, 4 = ghi, 5 = jkl, 6 = mno, 7 = pqrs, 8 = tuv, 9 = wxyz
        String[] alphabet = {"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        String[] listKata = {"addid","kirito"};
        int n = 233434292;
        String kataConv[] = new String[listKata.length];
        for (int i = 0; i < kataConv.length; i++) {
            kataConv[i] = "";
        }
        for (int h = 0; h < listKata.length; h++) {
            for (int i = 0; i < listKata[h].length(); i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    for (int j2 = 0; j2 < alphabet[j].length(); j2++) {
                        // System.out.print(h);
                        // System.out.print(i);
                        if((listKata[h].charAt(i) == alphabet[j].charAt(j2))){
                            // System.out.println(h+2);
                            kataConv[h] +=""+(j+2);
                            // System.out.println(kataConv[j]);
                            break;
                        }
                        // System.out.println();
                        // break;
                    }
                }
            }
        }
        for (int i = 0; i < kataConv.length; i++) {
            System.out.println(kataConv[i] + " ");
        }
    }
}