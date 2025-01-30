import java.util.Scanner;

public class MaxHeap {
    static void insert(int[] arr, int n) {
        int i = n;
        int item = arr[n];
        while (i > 0 && (item > arr[(i - 1) / 2])) {
            arr[i] = arr[(i - 1) / 2];
            i = (i - 1) / 2;
        }
        arr[i] = item;
    }

    static int delete(int[] arr, int n) {
        if (n < 0) {
            System.out.println("Heap is empty");
            return -1;
        }
        int temp = arr[0];
        arr[0] = arr[n];
        arr[n] = temp;
        adjust(arr, 0, n - 1);
        return temp;
    }

    static void adjust(int[] arr, int i, int n) {
        int item = arr[i];
        int j = 2 * i + 1;
        while (j <= n) {
            if (j + 1 <= n && arr[j + 1] > arr[j]) j++;
            if (item >= arr[j]) break;
            arr[i] = arr[j];
            i = j;
            j = 2 * i + 1;
        }
        arr[i] = item;
    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = 11;
            int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1, 70};

            insert(arr, n - 1);
            System.out.println("Heap after insertion:");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            int temp=delete(arr, n - 1);
            n--;
            System.out.println("Heap after deletion:");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("Deleted element: "+temp);
        }
    }
}