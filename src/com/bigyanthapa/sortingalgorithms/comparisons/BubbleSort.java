
//INSERTION SORT CLASS

package com.bigyanthapa.sortingalgorithms.comparisons;


/**
 * @author bigyanthapa
 *
 */

public class BubbleSort
{
	
	//default constructor
	public BubbleSort()
	{
	}	
	
//***********************************************************************//    
    //function definition to perform bubble sort. This function performs bubble sort for the provided array and returns the comparisons.
	public int bubbleSort(int[] array)
    {
		int bubbleCount=0;    	 
    	for(int i=0;i<=array.length-1;i++)
    	{
    		int temp=0;
    		for(int j=0;j<=array.length-i-2;j++)
    		{
    			//check				
    			if(array[j]>array[j+1])
    			{
					//now swap the values
					temp=array[j];
					array[j]=array[j+1];
					array[j+1]=temp;					
				}
				bubbleCount++;							
    		}//end for
    	}//end for loop
    	
    	//lets check if the array is properly sorted
    	/*System.out.println("\n Array sorted by Bubble Sort Algorithm.\n");
    	for(int count=0;count<array.length;count++)
    		System.out.print(array[count]+" ");*/
    	
		return bubbleCount;
    }//end function
	
}