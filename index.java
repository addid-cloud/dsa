class index{
    public static void main(String[] args) {
        int[] arr = {5,2,42,35,34,653,723,563,45,367,3562,3,1};
        // ini simpan pairnya
        int[][] pair = new int[arr.length-1][2];
        for (int i = 0; i < pair.length; i++) {
            for(int j=0; j<pair[i].length;j++){
                pair[i][0] = i;
                pair[i][1] = arr[i];
            }
        }
        // pair close
        int key = 367;
        selectionSort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        int ketemu = binerySearch(key, arr);
        System.out.println(ketemu);
    }
    static int[] selectionSort(int arr[]){
        for (int h = 0; h < arr.length; h++) {
            for (int i = 0; i < arr.length; i++) {
                if(arr[h] < arr[i]){
                    // System.out.println(arr[0]);
                    arr[h] = arr[h]^arr[i];
                    // System.out.println(arr[0]);
                    arr[i] = arr[h]^arr[i];
                    // System.out.println(arr[i]);
                    // System.out.println(arr[0]);
                    arr[h] = arr[h]^arr[i];
                    // System.out.println(arr[0]);
                }
            }
        }
        return arr;
    }
    static int binerySearch(int key, int arr[]){
        int a = 0;
        int b = arr.length-1;
        int t = (a+b)/2;
        while (a<=b) {
            if(arr[t]< key){
                a=t+1;
                t=(a+b)/2;
            }else{
                b=t-1;
                t=(a+b)/2;
            }
            if(key==arr[a]){
                return a;
            } if(key == arr[b]){
                return b;
            }if(key == arr[t]){
                return t;
            }
        }
        return -1;
    }
}