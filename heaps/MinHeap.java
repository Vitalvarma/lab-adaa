import java.util.Scanner;

public class MinHeap {
    static void insert(int arr[],int n){
        int item=arr[n];
        int i=n;
        while(i>0 && item<arr[(i-1)/2]){
            arr[i]=arr[(i-1)/2];
            i=(i-1)/2;
        }
        arr[i]=item;
    }

    static int delete(int arr[],int n){
        int item=arr[0];
        arr[0]=arr[n];
        arr[n]=item;

        adjust(arr,n-1); 
        return item;
    }

    static void adjust(int arr[],int n){
        int item=arr[0];
        int i=0;
        int j=1;
        while(j<=n){
            if(j+1<=n && arr[j+1]<arr[j]){j++;}
            if(item<arr[j]) break;
            arr[i]=arr[j];
            i=j;
            j=2*i+1;
        }
        arr[i]=item;
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
