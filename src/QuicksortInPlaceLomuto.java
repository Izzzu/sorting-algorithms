import java.util.Scanner;

public class QuicksortInPlaceLomuto {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for (int i = 0; i<n; i++) {
            ar[i] = s.nextInt();
        }


        quicksort(ar, 0, n-1);

    }


    public static void quicksort(int[] ar, int start, int end) {
        if (start < end) {
            int pivot_ind = partition(ar, start, end);

            quicksort(ar, start, pivot_ind - 1);
            quicksort(ar, pivot_ind + 1, end);
        }
    }

    private static int partition(int[] ar, int start, int end) {
        int pivot = ar[end];
        int i = start - 1;  //ostatni element który jest <=pivot
        for (int j = start; j<end; j++) {
            if (ar[j]<=pivot) {
                i++;
                swap(ar, i, j);
            }
        }
        swap(ar, i+1, end);
        for (int j = 0; j<ar.length; j++) {
            System.out.print(ar[j] + " ");
        }
        System.out.print("\n");
        return i+1;

    }

    private static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;

    }
}