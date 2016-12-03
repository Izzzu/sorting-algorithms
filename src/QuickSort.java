public class QuickSort {

    private static void quicksort(long newArr[], int leftIndex, int rightIndex) {

        int index = partition(newArr, leftIndex, rightIndex);
        if (leftIndex< index-1) {
            quicksort(newArr, leftIndex, index-1);
        }
        if(rightIndex > index) {
            quicksort(newArr, index, rightIndex);
        }

    }

    private static int partition(long[] arr, int leftIndex, int rightIndex) {

        int right = rightIndex;
        int left = leftIndex;
        long pivot = arr[(right-left)/2];

        while (right > left) {
            while(arr[left]<pivot) {
                left++;
            }
            while(arr[right]>pivot) {
                right++;
            }

            if (right>left) {
                long temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
            }
        }
        return left;
    }

}
