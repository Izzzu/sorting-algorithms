import java.util.Scanner;

public class CountingSort {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int [] ar = new int[n];
        for (int i = 0; i<n; i++) {
            ar[i] = s.nextInt();
        }

        int[] countArr = new int[100];
        int[] result = new int[ar.length];

        countingSort(ar, 100, result);

        for (int i = 0; i<result.length; i++) {
            System.out.print(result[i] + " ");
        }

    }

    private static void countingSort(int[] ar, int range, int[] result) {
        int[] countArr = new int[range];

        for (int i = 0; i<countArr.length; i++) {
            countArr[i] = 0;
        }

        for (int i = 0; i<ar.length; i++) {
            countArr[ar[i]] = countArr[ar[i]] + 1;
        }

        for (int i = 1; i<countArr.length; i++) {
            countArr[i] = countArr[i-1] + countArr[i];
        }
        for (int i = 0; i<countArr.length; i++) {
            System.out.print(countArr[i] + " ");
        }

        for (int i = ar.length-1; i>=0; i--) {
//            System.out.println("i: "+i);
//            System.out.println("ar[i]: "+ar[i]);
//            System.out.println("countArr[ar[i]]: "+countArr[ar[i]]);

            result[countArr[ar[i]]-1] = ar[i];
            countArr[ar[i]]--;
        }
    }
}
