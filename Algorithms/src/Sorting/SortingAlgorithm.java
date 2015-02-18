package Sorting;


public class SortingAlgorithm {
	
	private static int[] theArray;
	private static long startTime,stopTime;
	
	  private static int[] numbers;
	  private static int[] helper;
	  private static int number;
	  
	public static void main(String args[]){
		
		int [] array =  {10,15,2,0,55,66,8,1};
		
		/*System.out.println("array Before bubble sorting");
		displayArray(array);		
		quickSort(array);		
		System.out.println("array After bubble sorting");
		displayArray(array);*/
		
		System.out.println("\n\narray Before quick sorting");
		displayArray(array);
		
		quickSort(array);
		
		System.out.println("array After quick sorting");
		displayArray(theArray);
		
		/*System.out.println("\n\narray Before merge sorting");

	    sort_mearg(array);

		System.out.println("\n\narray Before merge sorting");*/
	}
	
	 public static void sort_mearg(int[] values) {
		 
		    numbers = values;
		    number = values.length;
		    helper = new int[number];
		    startTime= System.currentTimeMillis();
		    mergesort(0, number - 1);

		stopTime= System.currentTimeMillis();
		System.out.println("Total Time to Merge Sort is "+ (stopTime-startTime));
	}
	 
	 
	public static int[] generateRandomeArray(){
		int[] kickerNumbers = new int[10000];
		for(int i = 0; i < kickerNumbers.length; i++) {
		    kickerNumbers[i] = (int)(Math.random()*10+19);
		}
		return kickerNumbers;
	}
	public static int[] bubbleSort(int[] array){
		startTime= System.currentTimeMillis();
		for(int i = 0;i<array.length - 1 ; i++){
			for(int j = i+1;j< array.length;j++){
				if(array[i]>array[j]){
					swapValues(array,i,j);
				}
			}
		}
		stopTime= System.currentTimeMillis();
		System.out.println("Total Time to Bubble Sort is "+ (stopTime-startTime));
		return array;
	}
	
	 private static void mergesort(int low, int high) {
		    // check if low is smaller then high, if not then the array is sorted
		    if (low < high) {
		      // Get the index of the element which is in the middle
		      int middle = low + (high - low) / 2;
		      // Sort the left side of the array
		      mergesort(low, middle);
		      // Sort the right side of the array
		      mergesort(middle + 1, high);
		      // Combine them both
		      merge(low, middle, high);
		    }
		  }

		  private static void merge(int low, int middle, int high) {

		    // Copy both parts into the helper array
		    for (int i = low; i <= high; i++) {
		      helper[i] = numbers[i];
		    }

		    int i = low;
		    int j = middle + 1;
		    int k = low;
		    // Copy the smallest values from either the left or the right side back
		    // to the original array
		    while (i <= middle && j <= high) {
		      if (helper[i] <= helper[j]) {
		        numbers[k] = helper[i];
		        i++;
		      } else {
		        numbers[k] = helper[j];
		        j++;
		      }
		      k++;
		    }
		    // Copy the rest of the left side of the array into the target array
		    while (i <= middle) {
		      numbers[k] = helper[i];
		      k++;
		      i++;
		    }

		  }

		  public static void quickSort(int[] array){
			 theArray = array;
			 int low = 0;
			 int high = array.length-1;
			 sort(low,high);
		  }
		  public static void sort(int low, int high){
			  int temp_high = high;
			  int temp_low = low;
			  int pivot = theArray[low + (high-low)/2];
			  
			while (temp_low<=temp_high) {
			 
			  while(theArray[temp_low]<pivot){
				temp_low++; 
			  }
			  while(theArray[temp_high]>pivot){
				  temp_high--; 
			  }
			  
			  if(temp_low<=temp_high){
				  swapValues(theArray,temp_low, temp_high);
				  temp_low++; 
				  temp_high--;
			  }
			}

			if(low<temp_high){
				sort(low,temp_high);
			}
			if(temp_low<high){
				sort(temp_low,high);
			}
			
		  }
	
	
	
	////// Helping functions ////////////
	
	private static void swapValues(int[] array, int i,int j){
		int temp = array[j];
		array[j]= array[i];
		array[i] = temp;
	}
	
	private static void displayArray(int[] array){
		System.out.print("{");
		for(int i = 0 ; i <array.length;i++){
			System.out.print(" "+array[i]);
		}
		System.out.print("}\n");
	}
}