import java.util.LinkedList;
import java.util.Scanner;

public class FindMinDistance {


        public static void main(String[] args) {

            Scanner in = new Scanner(System.in);
            int s = in.nextInt();
            int[] ar = new int[s];
            for(int i=0;i<s;i++){
                ar[i]=in.nextInt();
            }
            mergeSort(ar, 0, s-1);

            int minDiff = ar[1] - ar[0];
            LinkedList<Integer> list= new LinkedList<>();
            list.add(ar[0]);
            list.add(ar[1]);
            if (s>2) {
                for(int i = 2; i<s;  i++) {
                    int diff = ar[i] - ar[i-1];
                    if (diff < minDiff) {
                        list.clear();
                        minDiff = diff;
                        list.add(ar[i-1]);
                        list.add(ar[i]);
                    } else if (diff == minDiff) {
                        list.add(ar[i-1]);
                        list.add(ar[i]);
                    }
                }
            }

            StringBuilder b = new StringBuilder();
            list.stream().forEach(num -> b.append(num + " "));
            System.out.println(b.toString());



        }

        private static void mergeSort(int[] ar, int start, int end) {
            if (end-start<1) {
                return;
            }
            int q = (end + start) / 2;
            mergeSort(ar, start, q);
            mergeSort(ar, q+1, end);
            merge(ar, start, end, q);
        }

        private static void merge(int[] ar, int start, int end, int q) {
            int nLeft = q-start +1;
            int nRight= end - q;
            int [] left = new int[nLeft+1];
            int [] right = new int[nRight+1];

            copy(ar, start, q, left);
            copy(ar, q+1, end, right);
            left[nLeft] = Integer.MAX_VALUE;
            right[nRight] = Integer.MAX_VALUE;

            int leftInd = 0;
            int rightInd = 0;
            for (int k = start; k <= end; k++) {
                if (left[leftInd] <= right[rightInd]) {
                    ar[k] = left[leftInd];
                    leftInd++;
                } else  {
                    ar[k] = right[rightInd];
                    rightInd++;
                }
            }
        }

        private static void copy(int[] ar, int start, int q, int[] left) {
            for (int i = start; i<=q; i++) {
                left[i-start] = ar[i];
            }

        }
    }
