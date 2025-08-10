public class ArrayAbis {
    int arr[];
    int[][] pair = new int[arr.length-1][2];
    ArrayAbis(int arr[]){
        this.arr = arr;
        for (int i = 0; i < pair.length; i++) {
            for(int j=0; j<pair[i].length;j++){
                pair[i][0] = i;
                pair[i][1] = arr[i];
            }
        }
    }
    public void print(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
    int[] selectionSort(){
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
    int binerySearch(int key){
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
