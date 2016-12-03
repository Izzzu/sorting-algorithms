import java.util.Scanner;

public class InsertionSort {

    public static void insertionSortPart2(int[] ar)
    {
        for (int i = 0; i<ar.length-1; i++) {
            int key = ar[i+1];
            if (key<ar[i]) {
                int j = i;
                while(j >=0 && key<ar[j]) {
                    ar[j+1] = ar[j];
                    j--;
                }
                ar[j+1] = key;
            }
            printArray(ar);
        }
        // Fill up the code for the required logic here
        // Manipulate the array as required
        // The code for Input/Output is already provided
    }



    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        insertionSortPart2(ar);

    }
    private static void printArray(int[] ar) {
        for(int n: ar){
            System.out.print(n+" ");
        }
        System.out.println("");
    }
}
