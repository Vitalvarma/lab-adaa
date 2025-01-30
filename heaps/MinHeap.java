import java.util.Scanner;

public class MinHeap {
    static void insert(int arr[],int n){
        int item=arr[n];
        int i=n;
        while(i>0){
            if(item<arr[(i-1)/2]){
                arr[i]=arr[(i-1)/2];
                i=(i-1)/2;
            }
            arr[i]=item;
        }

    }

    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            int[] arr = {1,2,3,6,9,5,10,14,4};
            int n=arr.length;

            insert(arr, n - 1);
            System.out.println("Heap after insertion:");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            /* */
            int temp=delete(arr, n - 1);
            n--;
            System.out.println("Heap after deletion:");
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            System.out.println("Deleted element: "+temp);*/
        }
    }
}
