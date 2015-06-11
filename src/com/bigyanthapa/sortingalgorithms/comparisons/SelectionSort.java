
//INSERTION SORT CLASS

package com.bigyanthapa.sortingalgorithms.comparisons;


/**
 * @author bigyanthapa
 *
 */


public class SelectionSort
{

	//default constructor
	public SelectionSort()
	{
	}	
	
//***********************************************************************//    
    //function definition to perform selection sorting. This function performs selection sort for the provided array and returns the comparisons.
    public int selectionSort(int[] array)
    {
		int selectCount=0;
    	int temp=0; //int[] newArray=array;
    	for(int i=0;i<=array.length-2;i++)
    	{
    		int smallest_index=i;
    		for(int j=i+1;j<=array.length-1;j++)
    		{
    			//check 				
    			if(array[j]<array[smallest_index])
				{
    				smallest_index=j; 					
				}
				selectCount++;
    		}//end for
    		//now swap the values
    		temp=array[i];
    		array[i]=array[smallest_index];
    		array[smallest_index]=temp;
    	
    	}//end for loop
    	
    	//lets check if the array is properly sorted
    	/*System.out.println("\n Array sorted by Selection Sort Algorithm.\n");
    	for(int count=0;count<array.length;count++)
    		System.out.print(array[count]+" ");*/
		return selectCount;
    }//end function  
	
}