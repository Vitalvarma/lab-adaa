import java.util.Arrays;

public class MinHeap {
    
    // Function to insert an element into the heap
    static void insert(int arr[], int n) {
        int item = arr[n]; // Get the last element to be inserted
        int i = n; 

        // Move up the tree while maintaining heap property
        while (i > 0 && item < arr[(i - 1) / 2]) {
            arr[i] = arr[(i - 1) / 2]; // Move parent down
            i = (i - 1) / 2; // Move to parent index
        }
        arr[i] = item; // Place the item at the correct position
    }

    // Function to delete the root element (smallest element in MinHeap)
    static int delete(int arr[], int n) {
        if (n < 0) {
            System.out.println("Heap is empty, deletion not possible.");
            return -1; // Error case
        }

        int item = arr[0]; // Store root element to return
        arr[0] = arr[n]; // Move last element to root
        arr[n] = item; // Place removed element at the end (for visualization)

        adjust(arr, n - 1); // Reheapify the heap
        return item;
    }

    // Function to maintain the min-heap property after deletion
    static void adjust(int arr[], int n) {
        int item = arr[0]; // Store root element
        int i = 0; // Start from root
        int j = 1; // Left child index

        while (j <= n) {
            // Choose the smaller child
            if (j + 1 <= n && arr[j + 1] < arr[j]) {
                j++; // Right child is smaller, use it
            }

            if (item < arr[j]) break; // Stop if heap property is satisfied
            
            arr[i] = arr[j]; // Move child up
            i = j; // Move down the tree
            j = 2 * i + 1; // Left child index of new position
        }
        arr[i] = item; // Place item at correct position
    }

    // Function to build a min-heap from an unsorted array
    public static void main(String args[]) {
        int[] arr = {10, 20, 15, 25, 40, 50, 100, 30, 45}; // Unsorted array
        int n = arr.length;


        System.out.println("Min Heap:");
        System.out.println(Arrays.toString(arr));

        insert(arr, n - 1); // Insert last element
        System.out.println("Heap after insertion:");
        System.out.println(Arrays.toString(arr));

        int temp = delete(arr, n - 1); // Delete min element
        n--;
        System.out.println("Heap after deletion:");
        System.out.println(Arrays.toString(Arrays.copyOf(arr, n)));

        System.out.println("Deleted element: " + temp);
    }
}
