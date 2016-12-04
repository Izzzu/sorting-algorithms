import java.util.Scanner;

public class HeapSort {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
        for(int i=0;i<s;i++){
            ar[i]=in.nextInt();
        }
        sort(ar);
        for(int i=0;i<s;i++){
            System.out.print(ar[i] + " ");
        }

    }

    public static void sort(int[] ar) {

        int n = ar.length;

        //length/2 -1 -> ostatni node, np jak 5 el w liscie to = 1
        //    (0)
        //    /  \
        //  (1)  (2)
        //  / \  / 
        //(4)(3)(5)
        for (int i = n/2-1; i >=0 ; i--) {
            heapify(ar, n, i);
        }
        for (int i = n-1; i >= 0; i--) {
            swap(ar, i, 0);
            heapify(ar, i, 0);

        }

    }

    private static void heapify(int[] ar, int n, int i) {

        int largest = i;
        int left = 2*i + 1;
        int right = 2*i + 2;

        if (left<n && ar[left] > ar[largest]) {
            largest = left;
        }

        if (right<n && ar[right] > ar[largest]) {
            largest = right;
        }

        if (largest!=i) {
            swap(ar, largest, i);
            heapify(ar, n, largest);
        }



    }

    private static void swap(int[] ar, int largest, int i) {
        int temp = ar[largest];
        ar[largest] = ar[i];
        ar[i] = temp;
    }
}
