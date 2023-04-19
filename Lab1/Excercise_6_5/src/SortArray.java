import java.util.*;

public class SortArray {

    public static int[] bubbleSort(int[] arr) {
        int n = arr.length;
        int temp;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        return arr;
    }

    public static long sum(int[] arr) {
        int n = arr.length;
        long res = 0;
        for (int i = 0; i < n; ++i) {
            res += arr[i];
        }
        return res;
    }

    public static double average(int[] arr) {
        int n = arr.length;
        long sumArray = sum(arr);

        return (double) sumArray / n;

    }

    public static void main(String[] args) {

        int[] arr = {1, 5, 7, 3, 2, 7, 223, 6323, 2, 6, 2};

        int[] sortedArr = bubbleSort(arr);

        String average = String.format("%.2f", average(sortedArr));

        System.out.println("The sorted array is: " + Arrays.toString(sortedArr));

        System.out.println("The sum of the array is: " + sum(sortedArr));

        System.out.println("The average of the array is: " + average);
    }

}
