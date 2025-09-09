package Praktikum;
class Mahasiswa{
    private long nim;
    private String nama;
    private String asal;
    public Mahasiswa(long nim, String nama, String asal){
        this.nama = nama;
        this.nim = nim;
        this.asal = asal;
    }
    public void displayMhs(){
        System.out.println("\tnim: " + nim);
        System.out.println("\tnama: " + nama);
        System.out.println("\tasal: " + asal);
    }
    public long getNim(){
        return nim;
    }
    public String getNama(){
        return nama;
    }
}

class DataArray{
    private Mahasiswa[] mhs;
    private int nElemen;
    public DataArray(int max){
        mhs = new Mahasiswa[max];
        nElemen = 0;
    }
    public Mahasiswa find(long searchNim){
        for (int i = 0; i < nElemen; i++) {
            if(mhs[i].getNim() == searchNim){
                return mhs[i];
            }
        }
        return null;
    }
    public void insert(long nim, String nama, String asal){
        mhs[nElemen]  = new Mahasiswa(nim, nama, asal);
        nElemen++;
    }
    public boolean delete(long searchNim){
        for (int i = 0; i < nElemen; i++) {
            if(mhs[i].getNim()==searchNim){
                break;
            }
            if(i == nElemen){
                return false;
            }else{
                for (int j = 0; j < nElemen; j++) {
                    mhs[j] = mhs[j+1];
                }
                nElemen--;
                return true;
            }
        }return false;
    }
    public void display(){
        for (int i = 0; i < nElemen; i++) {
            mhs[i].displayMhs();
        }
    }
     public void bubblesort(){
        int i;
        Mahasiswa temp;
        for (i = nElemen-1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(mhs[j].getNim() > mhs[j+1].getNim()){
                    temp = mhs[j];
                    mhs[j] = mhs[j+1];
                    mhs[j+1] = temp;
                }
            }
        }
}
    public void selectionsort(){
        int i,j,min;
        Mahasiswa temp;
        for (i = 0; i < nElemen-1; i++) {
            min = i;
            for (j = i+1; j < nElemen; j++) {
                if(mhs[j].getNim() < mhs[min].getNim()){
                    min = j;
                }
            }
            temp = mhs[i];
            mhs[i] = mhs[min];
            mhs[min] = temp;
        }
    }
    public void ortByName() {
        int i;
        int min;
        int j;
        Mahasiswa temp;
        for (i = 0; i < nElemen - 1; i++) {
            min = i;
            for (j = i + 1; j < nElemen; j++) {
                if (mhs[j].getNama().compareTo(mhs[min].getNama()) < 0) {
                    min = j;
                }
            }
            temp = mhs[i];
            mhs[i] = mhs[min];
            mhs[min] = temp;
        } 
} 
    // public void InsertionSort() { 
    // int i, curIn; 
    // for (curIn= 1; curIn < nElemen; curIn++) { 
    // int temp = arr[curIn]; 
    // i = curIn; 
    // while (i > 0 && arr[i - 1] >= temp) { 
    // arr[i] = arr[i - 1]; 
    // i--; 
    // } 
    // arr[i] = temp; 
    // } 
    // } 
    } 


class DataArrayApp {
    public static void main(String[] args) {
        int maxSize = 100;
        DataArray arr;
        arr = new DataArray(maxSize);
        arr.insert(16650210, "ahmad", "sidoarjo");
        arr.insert(16650200, "jundi", "malang");
        arr.insert(16650220, "ismail", "Banyuwangi");
        arr.insert(16650250, "rais", "ambon");
        arr.insert(16650230, "sofi", "semarang");
        arr.insert(16650240, "dinda", "bandung");
        arr.insert(16650260, "helmi", "madura");
        arr.insert(16650270, "agung", "madiun");
        arr.insert(16650280, "arina", "malang");
        arr.bubblesort();
        // arr.selectionsort();
        // arr.ortByName();
        arr.display();
        // long searchKey =  16650270;
        // Mahasiswa mhs = arr.find(searchKey);
        // if(mhs != null){
        //     System.out.println("ketemu");
        //     mhs.displayMhs();
        // }else{
        //     System.out.println("tidak ketemu" + searchKey);
        // }
        // searchKey = 16650240;
        // System.out.println("\n hapus nim :" + searchKey +"\n");
        // arr.delete(searchKey);
        // arr.display();
    }
}
