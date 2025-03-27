import java.util.Random;

public class QuickSort {

    // QuickSort implementation
    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[low];  // First element as pivot
        int i = low - 1;
        int j = high + 1;

        while (true) {
            // Find leftmost element >= pivot
            do {
                i++;
            } while (arr[i] < pivot && i<=high);

            // Find rightmost element <= pivot
            do {
                j--;
            } while (arr[j] > pivot && j>=low);

            // If pointers crossed
            if (i >= j) {
                return j;
            }

            swap(arr, i, j);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Generate test cases
    private static int[] generateBestCase(int size) {
        // Already sorted array (balanced partitions)
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static int[] generateAverageCase(int size) {
        // Random array
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }

    private static int[] generateWorstCase(int size) {
        // Already sorted array with pivot always being largest/smallest element
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = size - i; // Reverse sorted
        }
        return arr;
    }

    // Measure execution time
    private static void measurePerformance(int[] arr, String caseType) {
        int[] copy = arr.clone();
        
        long startTime = System.nanoTime();
        quickSort(copy, 0, copy.length - 1);
        long endTime = System.nanoTime();
        
        double duration = (endTime - startTime) / 1_000_000.0; // milliseconds
        System.out.printf("%-10s case (n=%6d): %.3f ms%n", caseType, arr.length, duration);
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000, 1000000};
        
        System.out.println("QuickSort Performance Analysis");
        System.out.println("--------------------------------");
        
        for (int size : sizes) {
            System.out.println("Testing size: " + size);
            
            // Best case (already sorted with balanced partitions)
            int[] bestCase = generateBestCase(size);
            measurePerformance(bestCase, "Best");
            
            // Average case (random elements)
            int[] avgCase = generateAverageCase(size);
            measurePerformance(avgCase, "Average");
            
            // Worst case (already reverse sorted)
            int[] worstCase = generateWorstCase(size);
            measurePerformance(worstCase, "Worst");
            
            System.out.println();
        }
    }
}
