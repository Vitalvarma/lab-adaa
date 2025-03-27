import java.util.Random;

public class MergeSort{

    // Merge Sort implementation
    public static void mergeSort(int[] arr) {
        if (arr.length > 1) {
            int mid = arr.length / 2;
            int[] left = new int[mid];
            int[] right = new int[arr.length - mid];

            System.arraycopy(arr, 0, left, 0, mid);
            System.arraycopy(arr, mid, right, 0, arr.length - mid);

            mergeSort(left);
            mergeSort(right);

            merge(arr, left, right);
        }
    }

    private static void merge(int[] arr, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }

        while (i < left.length) {
            arr[k++] = left[i++];
        }

        while (j < right.length) {
            arr[k++] = right[j++];
        }
    }

    // Generate test cases
    private static int[] generateBestCase(int size) {
        // Already sorted array (best case for merge sort)
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        return arr;
    }

    private static int[] generateAverageCase(int size) {
        // Random array (average case)
        Random rand = new Random();
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(size * 10);
        }
        return arr;
    }

    private static int[] generateWorstCase(int size) {
        // Alternate between high and low values to maximize merge operations
        int[] arr = new int[size];
        int low = 0, high = size - 1;
        boolean flag = true;
        
        for (int i = 0; i < size; i++) {
            arr[i] = flag ? high-- : low++;
            flag = !flag;
        }
        return arr;
    }

    // Measure execution time
    private static void measurePerformance(int[] arr, String caseType) {
        int[] copy = arr.clone();
        
        long startTime = System.nanoTime();
        mergeSort(copy);
        long endTime = System.nanoTime();
        
        double duration = (endTime - startTime) / 1_000_000.0; // milliseconds
        System.out.printf("%-10s case (n=%7d): %8.3f ms%n", caseType, arr.length, duration);
    }

    public static void main(String[] args) {
        int[] sizes = {100, 1000, 10000, 100000, 1000000};
        
        System.out.println("Merge Sort Performance Analysis");
        System.out.println("=================================");
        System.out.printf("%-10s %12s %15s%n", "Case", "Size", "Time (ms)");
        System.out.println("---------------------------------");
        
        for (int size : sizes) {
            // Best case (already sorted)
            int[] bestCase = generateBestCase(size);
            measurePerformance(bestCase, "Best");
            
            // Average case (random elements)
            int[] avgCase = generateAverageCase(size);
            measurePerformance(avgCase, "Average");
            
            // Worst case (alternating high/low)
            int[] worstCase = generateWorstCase(size);
            measurePerformance(worstCase, "Worst");
            
            System.out.println("---------------------------------");
        }
    }
}