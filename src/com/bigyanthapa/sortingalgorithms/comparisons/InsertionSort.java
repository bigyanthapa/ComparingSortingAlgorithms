

//INSERTION SORT CLASS

package com.bigyanthapa.sortingalgorithms.comparisons;


/**
 * @author bigyanthapa
 *
 */

public class InsertionSort
{
	
	//default constructor
	public InsertionSort()
	{
		
	}	
	
//***********************************************************************//    
    //function definition to perform insertion sorting . This function performs insertion sort for the provided array and returns the comparisons.  
    public int insertionSort(int[] array)
    {   
		int insertCount=0;
    	for(int j=1;j<=array.length-1;j++){
			int temp = array[j];
			int i= j-1;	
				//check
				
				while(i>=0 && array[i] > temp){
					//swap values
					array[i+1] = array[i];
					i= i -1;
					insertCount++;
				}//end while
				insertCount++;
				array[i+1]=temp;
		}//for loop closed
    	
    	//lets check if the array is properly sorted
    /*	System.out.println("\n Array sorted by Insertion Sort Algorithm.\n");
    	for(int count=0;count<array.length;count++)
    		System.out.print(array[count]+" ");*/
		return insertCount;
    }//end function
	
}