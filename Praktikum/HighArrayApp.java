package Praktikum;
class HighArray{
    private int[] arr;
    private int nElemen;
    public HighArray(int max){
        arr = new int[max] ;
        nElemen = 0;
    }
public void insert(int value){
    // int i ;
    // for (i = 0; i < nElemen; i++) {
    //     if(arr[i] > value){
    //         break;
    //     }
    // }
    // for (int j = nElemen; j >i; j--) {
    //     arr[j] = arr[j-1]; 
    // }
    // arr[i] = value; 
    arr[nElemen] = value;
    nElemen++;
}
    public boolean find(int key){
        for (int i = 0; i < nElemen; i++) {
            if(arr[i] == key){
                return true;
            }else{
                return false;
            }
        }
        return false;
    }
    public int size(){
        return arr.length;
    }
public boolean delete(int value){
    for (int i = 0; i < nElemen; i++) {
        if(arr[i] == value){
            for (int j = i; j < nElemen - 1; j++) {
                arr[j] = arr[j+1];
            }
            nElemen--;
            return true;
        }
    }
    return false;
}
        public void display() { 
        for (int i = 0; i < nElemen; i++) { 
            System.out.print(arr[i] + " "); 
        } 
        System.out.println(""); 
    } 
    public void BubbleSort(){
        int batas, i;
        for ( batas = nElemen-1; batas >0; batas--) {
            for ( i = 0; i < nElemen; i++) {
                    if(arr[i] < arr[i+1]){
                    swap(i, i+1);
                    // display();
                }
            }
        }
    }
    public void swap(int one,int two){
        int temp = arr[one];
        arr[one] = arr[two];
        arr[two] = temp;
    }
public void selectionSort() {
    int awal, i, min;
    for (awal = 0; awal < nElemen - 1; awal++) {
        min = awal;
        for (i = awal + 1; i < nElemen; i++) {
            if (arr[i] < arr[min]) {
                min = i;
            }
        }
        swap(awal, min);   
        display();         
    }
}
public void insertionSort() {
    int i, curIn;
    for (curIn = 1; curIn < nElemen; curIn++) {
        int temp = arr[curIn];   
        i = curIn;
        while (i > 0 && arr[i - 1] > temp) {
            arr[i] = arr[i - 1];
            display();
            i--;
        }
        arr[i] = temp;
    }
}

}


public class HighArrayApp { 
    public static void main(String[] args) { 
    int maxSize = 100; 
    HighArray arr; 
    arr = new HighArray(maxSize); 
    arr.insert(70); 
    arr.insert(25); 
    arr.insert(75); 
    arr.insert(80); 
    arr.insert(55); 
    arr.insert(30); 
    arr.insert(0); 
    arr.insert(85); 
    arr.insert(40) ;
    arr.insert(90); 
    arr.insert(1);
    arr.insert(100);
    arr.display(); 
    System.out.println("sesudah diurutkan : ");
    arr.insertionSort();
    arr.display();
    // int key = 25; 
    // if (arr.find(key)) { 
    //     System.out.println(key + " ditemukan"); 
    // } else { 
    //     System.out.println(key + " tidak ditemukan"); 
    // } 
    // arr.delete(00); 
    // arr.delete(80); 
    // arr.delete(55); 
    // arr.display(); 
} 
}