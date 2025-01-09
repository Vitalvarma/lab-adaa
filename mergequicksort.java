
class MergeQuickSort{
    public static void main(String[] args){
        int arr[]={12,11,13,5,6,7};
        quickSort(arr, 0, arr.length-1);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
    public static void mergeSort(int arr[],int low,int high){
        if(low<high){
            int mid=(low+high)/2;
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr,low,mid,high);
        }
    }
    public static void merge(int arr[],int low,int mid,int high){
        int n1=mid-low+1;
        int n2=high-mid;

        int L[]=new int[n1];
        int R[]=new int[n2];

        for(int i=0;i<n1;i++)
            L[i]=arr[low+i];
        for(int j=0;j<n2;j++)
            R[j]=arr[mid+1+j];

        int i=0,j=0;
        int k=low;
        while(i<n1 && j<n2){
            if(L[i]<=R[j]){
                arr[k]=L[i];
                i++;
            }
            else{
                arr[k]=R[j];
                j++;
            }
            k++;
        }

        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }

        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    
    }
    public static void quickSort(int arr[],int low,int high){
        if(high>low){
            int j=quickPartition(arr,low,high);
            quickSort(arr, low, j-1);
            quickSort(arr, j+1, high);
        }
    }
    public static int quickPartition(int arr[],int low,int high){
        int pivot=arr[low];
        int i=low+1;
        int j=high;
        while(j>i){
            while(i<=j && arr[i]<pivot){i++;}
            while(arr[j]>pivot && j>=low){j--;}
            if(i<j){swap(arr,i,j);}
        }
        if(low<j){swap(arr, low, j);}
        return j;
    }
    public static void swap(int arr[],int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
