class labprograms{
	static int linearSearch(int arr[],int key){
		int n=arr.length;
		for(int i=0;i<n;i++){
			if(arr[i]==key){
				return i;
			}
		}
		return -1;
	}
	static int binarySearch(int arr[],int key){
		int n=arr.length;
		int low=0;
		int high=n-1;
		int mid;
		while(high>=low){
			mid=(low+high)/2;
			if(arr[mid]==key){
				return mid;
			}

			elseif(arr[mid)>key)
				high=mid-1;
			else
				low=mid+1;
		}
		return -1
	}
	static void swap(int a,int b){
		int temp=a;
		a=b;
		b=temp;
	}
	static void bubbleSort(int arr[],int n){
		for(int i=0;i<n-1;i++){
			for(int j=0;j<n-i-1;j++){
				if(arr[j]>arr[j+1]){
					swap(arr[j],arr[j+1]);
				}
			}
		}
	}
	static void selectionSort(int arr[],int n){
		for(int i=0;i<n-1;i++){
			int min=i;
			for(int j=i+1;j<n;i++){
				if(arr[min]>arr[j])
					min=j;
			}
			swap(arr[i],arr[min]);
		}
	}
	static void insertionSort(int arr[],int n){
		for(int i=0;i<n;i++){
			temp=arr[i]
			while(j>=0 && arr[j]<arr[j+1]){
				arr[j+1]=arr[j];
				j--;
			}
			arr[j+1]=temp;		
		}
	}
	public static void main(String args[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter the size of the array: ");
		int n=sc.nextInt();
		int arr[] = new int(n);
		for(int i=0;i<n;i++){
			arr[i]=sc.nextInt();
		}
		System.out.println();
		System.out.print("Enter element to Search: ");
		int key=sc.nextInt();
		int ls=linearSearch(arr,key);
		System.out.println("LINEAR SEARCH");
		if(ls==-1){
			System.out.println("Key not fouund");
		}
		else[
			System.out.println("key found at",ls);
		}
		/*
		int bs=binarySearch(arr,key);
		System.out.println("LINEAR SEARCH");
		if(bs==-1){
			System.out.println("Key not fouund");
		}
		else[
			System.out.println("key found at"+ls);
		}
		System.out.println("BUBBLE SORT");
		bubbleSort(arr,arr.length);
		for(int i=0;i<n;i++){
			System.otu.print(arr[i]+" ");
		}
		System.out.println("SELECTION SORT");
		selectionSort(arr,arr.length);
		for(int i=0;i<n;i++){
			System.otu.print(arr[i]+" ");
		}
		System.out.println("INSERTION SORT");
		insertionSort(arr,arr.length);
		for(int i=0;i<n;i++){
			System.otu.print(arr[i]+" ");
		}
		*/
		
		
	}
	
}
