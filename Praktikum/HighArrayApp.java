package Praktikum;
class HighArray{
    private int[] arr;
    private int nElemen;
    public HighArray(int max){
        arr = new int[max] ;
        nElemen = 0;
    }
public void insert(int value){
    int i ;
    for (i = nElemen - 1; i >= 0; i--) {
        arr[i + 1] = arr[i]; 
    }
    arr[i + 1] = value; 
    // arr[nElemen] = value;
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
            if(value == arr[i]){
                break;
            }
            if(i == nElemen){
                return false;
            }else{
                for (int j = 0; j < nElemen; j++) {
                    arr[j] = arr[j+1];
                }
                nElemen--;
                return true;
            }
        }return false;
    }
        public void display() { 
        for (int i = 0; i < nElemen; i++) { 
            System.out.print(arr[i] + " "); 
        } 
        System.out.println(""); 
    } 
}

public class HighArrayApp { 
    public static void main(String[] args) { 
    int maxSize = 100; 
    HighArray arr; 
    arr = new HighArray(maxSize); 
    arr.insert(70); 
    arr.insert(80); 
    arr.insert(75); 
    arr.insert(55); 
    arr.insert(85); 
    arr.insert(25); 
    arr.insert(30); 
    arr.insert(00); 
    arr.insert(90); 
    arr.insert(40) ;
    arr.display(); 
    int key = 25; 
    if (arr.find(key)) { 
        System.out.println(key + " ditemukan"); 
    } else { 
        System.out.println(key + " tidak ditemukan"); 
    } 
    arr.delete(00); 
    arr.delete(80); 
    arr.delete(55); 
    arr.insert(1);
    arr.display(); 
} 
}