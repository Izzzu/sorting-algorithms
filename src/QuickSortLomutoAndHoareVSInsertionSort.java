import java.util.Scanner;

public class QuickSortLomutoAndHoareVSInsertionSort {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        int [] ar2 = new int[n];
        int [] ar3 = new int[n];
        for (int i = 0; i<n; i++) {
            ar[i] = s.nextInt();
            ar2[i] = ar[i];
            ar3[i] = ar[i];
        }

        int[] quickSwaps = new int[1];
        quicksortLomuto(ar, 0, n-1, quickSwaps);
        int insertShifts = insertionsort(ar2);
        // System.out.print(insertShifts-quickSwaps[0]);

        int[] quickSwaps2 = new int[1];

        quicksortHoare(ar, 0, n-1, quickSwaps2);
        System.out.println("Lomuto swaps: " + quickSwaps[0]);
        System.out.println("Hoare swaps: " + quickSwaps2[0]);
        System.out.println("Insertion shifts: " + insertShifts);
    }

    private static int insertionsort(int[] ar) {
        int shifts = 0;
        if (ar.length == 0) return 0;
        if (ar.length == 1) return 0;
        for (int i = 1; i < ar.length ; i++) {

            int key = ar[i];
            int j = i-1;
            while (j>=0 && ar[j]>key) {
                ar[j+1] = ar[j];
                shifts++;
                j--;
            }
            ar[j+1] = key;
        }
        return shifts;
    }


    public static void quicksortLomuto(int[] ar, int start, int end, int[] swaps) {
        if (start < end) {
            int pivot_ind = partitionLomuto(ar, start, end, swaps);

            quicksortLomuto(ar, start, pivot_ind - 1, swaps);
            quicksortLomuto(ar, pivot_ind + 1, end, swaps);
        }
    }

    public static void quicksortHoare(int[] ar, int start, int end, int[] swaps) {
        if (start < end) {
            int pivot_ind = partitionHoare(ar, start, end, swaps);

            quicksortHoare(ar, start, pivot_ind - 1, swaps);
            quicksortHoare(ar, pivot_ind + 1, end, swaps);
        }
    }

    private static int partitionHoare(int[] ar, int start, int end, int[] swaps) {
        int pivot = ar[start];
        int i = start;
        int j = end;
        while(true) {
            while(ar[i]<pivot) i++;
            while(ar[j]>pivot) j--;
            if (i<j) {
                swap(ar, i, j);
                swaps[0]++;
            } else {
                return j;
            }

        }

    }


    private static int partitionLomuto(int[] ar, int start, int end, int[] swaps) {
        int pivot = ar[end];
        int i = start - 1;  //ostatni element który jest <=pivot
        for (int j = start; j<end; j++) {
            if (ar[j]<=pivot) {
                i++;
                swap(ar, i, j);
                swaps[0]++;
            }
        }
        swap(ar, i+1, end);
        swaps[0]++;
        return i+1;

    }

    private static void swap(int[] ar, int i, int j) {
        int temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;

    }

}
