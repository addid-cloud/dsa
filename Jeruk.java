public class Jeruk {

String[] label = {"limau","cina kecil","cina besar","purut","bali","keprok"};
public static int[][] Pytagoras(int[][] data, int[] data2) {
    for (int i = 0; i < data.length; i++) {
        int x1 = data[i][1];
        int y1 = data[i][2];
        int z1 = data[i][3];
        int x2 = data2[0];
        int y2 = data2[1];
        int z2 = data2[2];
        double jarak = Math.sqrt(
            Math.pow(x1 - x2, 2) +
            Math.pow(y1 - y2, 2) +
            Math.pow(z1 - z2, 2)
        );
        data[i][4] = (int)jarak;
    }
    // for (int i = 0; i < data.length; i++) {
    //     double jarak = 0;
    //     for (int j = 1; j < 4; j++) {
    //         for (int h= 0; h < data2.length; h++) {
    //             jarak += Math.sqrt(Math.pow((double)data[i][j] - (double)data2[h],2));
    //         }
    //     }
            // data[i][data[i].length-1] = (int) jarak; 
    // }
    return data;
}
public static int[][] sort(int[][] data){
    for (int h = 0; h < data.length; h++) {
            for (int i = 0; i < data.length; i++) {
                if(data[h][4] < data[i][4]){
                    int temp[] = data[h];
                    data[h] = data[i];
                    data[i] = temp;
                }
            }
        }
        return data;
}
public static void main(String[] args) {
    //nim+id, t,l,w,
    int[][] data ={
        {5,18,20,30,0},
        {1,3,5,10,0},
        {2,7,8,90,0},
        {6,4,5,80,0},
        {5,17,19,90,0},
        {1,2,3,20,0},
        {1,1,2,15,0},
        {2,5,7,80,0},
        {3,12,14,85,0},
        {4,6,8,30,0},
        {5,21,22,35,0},
        {6,4,5,35,0},
        { 1, 5, 4, 10, 0 },
        { 2, 3, 3, 90, 0 },
        { 3, 7, 8, 80, 0 },
        { 4, 6, 6, 5, 0 },
        { 5, 25, 15, 20, 0 },
        { 6, 5, 8, 95, 0 }
};
int data2[] = {18,20,30};
    Pytagoras(data,data2);
    sort(data);
    for (int i = 0; i < data2.length; i++) {
        System.out.print(data2[i]);
    }
    
    System.out.println("\n==================================");
    for (int i = 0; i < data.length; i++) {
        for (int j = 0; j < data[i].length; j++) {
            System.out.print(data[i][j] +  " ");
        }
        System.out.println();
    }
}

}