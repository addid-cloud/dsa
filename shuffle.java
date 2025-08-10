public class shuffle {
    public static void main(String[] args) {
        String[] js = {"a","b","c","d","e"};
        String temp;
        int max = js.length-1;
        for (int i = 0; i < js.length; i++) {
            int min = i;
            int j =(int) (Math.random()*(max));
            temp = js[i];
            js[i] = js[j];
            js[j] = temp;
        }
        for (int i = 0; i < js.length; i++) {
            System.out.println(js[i]);
        }
    }
}
