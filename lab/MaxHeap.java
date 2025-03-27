import java.util.Arrays;

public class MaxHeap {
    
    // Function to insert an element into the max-heap
    static void insert(int[] arr, int n) {
        int i = n;
        int item = arr[n]; // New element to insert

        // Move up the tree while maintaining max-heap property
        while (i > 0 && (item > arr[(i - 1) / 2])) {
            arr[i] = arr[(i - 1) / 2]; // Move parent down
            i = (i - 1) / 2; // Move to parent index
        }
        arr[i] = item; // Place the item at the correct position
    }

    // Function to delete the root element (maximum element in MaxHeap)
    static int delete(int[] arr, int n) {
        if (n < 0) {
            System.out.println("Heap is empty, deletion not possible.");
            return -1; // Error case
        }

        int temp = arr[0]; // Store max element to return
        arr[0] = arr[n]; // Move last element to root
        arr[n] = temp; // Place removed element at the end (for visualization)

        adjust(arr, 0, n-1); // Reheapify the heap
        return temp;
    }

    // Function to maintain the max-heap property after deletion
    static void adjust(int[] arr, int i, int n) {
        int item = arr[i]; // Store root element
        int j = 2 * i + 1; // Left child index

        while (j <= n) {
            // Choose the larger child
            if (j + 1 <= n && arr[j + 1] > arr[j]) {
                j++; // Right child is larger, use it
            }

            if (item >= arr[j]) break; // Stop if heap property is satisfied
            
            arr[i] = arr[j]; // Move child up
            i = j; // Move down the tree
            j = 2 * i + 1; // Left child index of new position
        }
        arr[i] = item; // Place item at correct position
    }

    // Function to build a max-heap from an unsorted array

    public static void main(String args[]) {
        int[] arr = {16, 14, 10, 8, 7, 9, 3, 2, 4, 1, 70}; // Unsorted array
        int n = arr.length;

        System.out.println("Max Heap:");
        System.out.println(Arrays.toString(arr));

        insert(arr, n - 1); // Insert last element
        System.out.println("Heap after insertion:");
        System.out.println(Arrays.toString(arr));

        int temp = delete(arr, n-1); // Delete max element
        n--;
        System.out.println("Heap after deletion:");
        System.out.println(Arrays.toString(Arrays.copyOf(arr, n)));

        System.out.println("Deleted element: " + temp);
    }
}

