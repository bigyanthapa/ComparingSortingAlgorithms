// This is the menu driven test class.

package com.bigyanthapa.sortingalgorithms.comparisons;


import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * @author bigyanthapa
 *
 */


public class Test
{
	 
	public static void main(String args[])
	{
		//declare a boolean variable to track the loop
		boolean condition = true;
		//create objects of our classes that we need later
		InsertionSort is = new InsertionSort();		
		SelectionSort ss = new SelectionSort();
		BubbleSort bs = new BubbleSort();
		
		//create object of scanner class to take input from user
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		int choice = 0;
		int check = 0;
		//PERFORM SOME MENU DRIVEN PROGRAM
		// keep the menu running until the user wants to exit
		while(condition==true)
		{
			System.out.println("\n\t\tThis is Assignment Two 'A'. 'Sorting Algorithm Analysis.'");
			System.out.println("\tPlease input '1' to provide your array to test, '2' to test of the sorting algorithms for randomly generated array, ");
			System.out.println("\n'3' to test the sorting algorithms for presorted array, or '4' to directly view the results for 6 sorts performed for randomly generated array and pre-sorted array.");
			System.out.println("**************************************************************************************************************************************************************************************");
			choice = in.nextInt();
		
		
			//check the choice bit
			if(choice==1||choice==2||choice==3||choice==4)
			{
				if(choice==1)
				{
					//this means that user want to provide array to test. now take user array as input			
					System.out.println("\tYou have selected to provide your own array to test. Please input the array values.");
					System.out.println("\tNOTE !!! - Please enter one by one and enter '0' to denote end of array");
					//	declare an array list to hold the number and later convert into array
					ArrayList<Integer> input= new ArrayList<Integer>();
					int x = in.nextInt();
					while(x!=0)
					{
						x=in.nextInt();
						input.add(x);
					}
					int[] bubbleArr = convert(input);
					int[] insertionArr= new int[bubbleArr.length];
					int[] selectionArr= new int[bubbleArr.length];
					System.arraycopy(bubbleArr, 0, insertionArr, 0, bubbleArr.length);
					System.arraycopy(bubbleArr, 0, selectionArr, 0, bubbleArr.length);
										
					//now test the array for the insertion sorting algorithm and display the number of comparisons required in each sorting algorithm
					//also record the time for each sorting algorithm
					long bubbleStart=System.currentTimeMillis();
					int bubbleCompare = bs.bubbleSort(bubbleArr);
					long bubbleEnd=System.currentTimeMillis();
					
					long selectStart = System.currentTimeMillis();
					int selectCompare = ss.selectionSort(selectionArr);
					long selectEnd = System.currentTimeMillis();
					
					long insertStart = System.currentTimeMillis();
					int insertCompare = is.insertionSort(insertionArr);
					long insertEnd = System.currentTimeMillis();
					
					//display the results for each sorting algorithms
					System.out.println("\n The comparisons required for each sorting algorithm with the array size "+input.size()+" are as follows.");
					System.out.println("\n\t\t Algorithm \t\t  Comparisons \t\t Time required");
					
					System.out.println("\t\t Selection Sort"+"\t\t\t"+selectCompare+"\t\t\t"+(selectEnd-selectStart) +"ms");		
					System.out.println("\t\t Bubble Sort"+"\t\t\t"+bubbleCompare+"\t\t\t"+(bubbleEnd-bubbleStart) +"ms");
					System.out.println("\t\t Insertion Sort"+"\t\t\t"+insertCompare+"\t\t\t"+(insertEnd-insertStart) +"ms");
					
					//ask the user if S/He wants to continue
					System.out.println("\n\t Press '1', if you like to continue the program OR Press '0' if you like to exit.");
					check=in.nextInt();
					
					if(check==1)
						condition=true;
					else
					{
						if(check==0){
							System.out.println("//\n---------------------------------------------------------------------------//");
							System.out.println("\t!You have selected to exit. Thank you. I hope the program was satisfactory.!");
							condition=false;								
						}
					}					
				 }//close first case
				
				else
				{
					if(choice == 2)	//test the randomly generated array
					{
						System.out.println("\tPlease input a integer size for an array to perform test on randomly generated array : ");
						int size = in.nextInt();
						
						//now generate the array of the size provided by the user				
						int[] bubbleArray = generateArray(size);						
						int[] insertionArray= new int[bubbleArray.length];
						int[] selectionArray= new int[bubbleArray.length];
						System.arraycopy(bubbleArray, 0, insertionArray, 0, bubbleArray.length);
						System.arraycopy(bubbleArray, 0, selectionArray, 0, bubbleArray.length);						
						
						//now test the array for the insertion sorting algorithm and display the number of comparisons required in each sorting algorithm
						long bubbleStart = System.currentTimeMillis();
						int bubbleComparison = bs.bubbleSort(bubbleArray);
						long bubbleEnd = System.currentTimeMillis();
						
						long selectStart = System.currentTimeMillis();
						int selectComparison = ss.selectionSort(selectionArray);
						long selectEnd = System.currentTimeMillis();
						
						long insertStart = System.currentTimeMillis();
						int insertComparison = is.insertionSort(insertionArray);
						long insertEnd = System.currentTimeMillis();
						System.out.println("\n The comparisons required for each sorting algorithm to sort the randomly generated array of size "+bubbleArray.length+" are as follows.");
						System.out.println("\n\t\t Algorithm \t\t     Comparisons \t\t Time required");
						
						System.out.println("\t\t Selection Sort"+"\t\t\t"+selectComparison+"\t\t\t\t"+(selectEnd-selectStart) +"ms");		
						System.out.println("\t\t Bubble Sort"+"\t\t\t"+bubbleComparison+"\t\t\t\t"+(bubbleEnd-bubbleStart) +"ms");
						System.out.println("\t\t Insertion Sort"+"\t\t\t"+insertComparison+"\t\t\t\t"+(insertEnd-insertStart) +"ms");
						
						//ask the user if S/He wants to continue
						System.out.println("\n\t Press '1', if you like to continue the program OR Press '0' if you like to exit.");
						check=in.nextInt();
						
						if(check==1)
							condition=true;
						else
						{
							if(check==0){
								System.out.println("//\n---------------------------------------------------------------------------//");
								System.out.println("\t!You have selected to exit. Thank you. I hope the program was satisfactory.!");
								condition=false;								
							}
						}						
					}//close second case
					
					else
					{
						if(choice == 3)	//test the presorted array
						{					
							System.out.println("\tYou have selected to perform test on presorted array : ");
							System.out.println("\tPlease input the size of presorted array you want to test.");
							int size1=in.nextInt();
							
							//now generate the array of the size 200
							int[] bubbleArray = new int[size1];
							int[] insertionArray = new int[size1];
							int[] selectionArray = new int[size1];	
							
							//lets populate the arrays, this gives us sorted array of size 200
							for(int count=0;count<size1;count++)
							{
								insertionArray[count]=count+1;
								bubbleArray[count]=count+1;						
								selectionArray[count]=count+1;
							}
							//lets print the unsorted array if it works
						/*	System.out.println("\n Here is the unsorted array\n");
					    	for(int count=0;count<bubbleArray.length;count++)
					    		System.out.print(bubbleArray[count]+" ");	*/
							
							//now test the array for the insertion sorting algorithm and display the number of comparisons required in each sorting algorithm
							long bubbleStart = System.currentTimeMillis();
							int bubbleComparison = bs.bubbleSort(bubbleArray);
							long bubbleEnd = System.currentTimeMillis();
							
							long selectStart = System.currentTimeMillis();
							int selectComparison = ss.selectionSort(selectionArray);
							long selectEnd = System.currentTimeMillis();
							
							long insertStart = System.currentTimeMillis();
							int insertComparison = is.insertionSort(insertionArray);
							long insertEnd = System.currentTimeMillis();
							
							System.out.println("\n The comparisons required for each sorting algorithm with the array size "+bubbleArray.length+" are as follows.");
							System.out.println("\n\t\t Algorithm \t\t      Comparisons \t\tTime required");
							
							System.out.println("\t\t Selection Sort"+"\t\t\t"+selectComparison+"\t\t\t"+(selectEnd-selectStart) +"ms");		
							System.out.println("\t\t Bubble Sort"+"\t\t\t"+bubbleComparison+"\t\t\t"+(bubbleEnd-bubbleStart) +"ms");
							System.out.println("\t\t Insertion Sort"+"\t\t\t"+insertComparison+"\t\t\t"+(insertEnd-insertStart) +"ms");
							
							//ask the user if S/He wants to continue
							System.out.println("\n\t Press '1', if you like to continue the program OR Press '0' if you like to exit.");
							check=in.nextInt();
							
							if(check==1)
								condition=true;
							else
							{
								if(check==0){
									System.out.println("//\n---------------------------------------------------------------------------//");
									System.out.println("\t!You have selected to exit. Thank you. I hope the program was satisfactory.!");
									condition=false;								
								}
							}
														
						}//close third case
						else
						{
							if(choice==4)
							{
								//this means the user likes to view the overall performance details for 5 randomly generated generated array
								System.out.println("\n Your are in case '4', i.e. you would prefer to view results for 6 sorts for varied sized arrays.");
								System.out.println("\n ! Please wait until the sorts are complete, the results will be displayed on your screen after a while! \n\t\t\tThank you!!!.");
								
								//lets define an array to store various sizes
								int[] variousSize ={10,100,500,1000,5000,10000};
								
								//lets declare the comparisons arrays for each sorting algorithms
								int[] bubbleComparisons=new int[6];
								int[] selectComparisons=new int[6];
								int[] insertComparisons= new int[6];
								
								//lets declare the arrays to hold the time variables for each sorting algorithms
								long[] bubbleStart=new long[6];
								long[] bubbleEnd=new long[6];
								long[] insertStart=new long[6];
								long[] insertEnd=new long[6];
								long[] selectStart=new long[6];
								long[] selectEnd=new long[6];
								
								for(int count=0;count<variousSize.length;count++)
								{
									bubbleStart[count]=System.currentTimeMillis();
									bubbleComparisons[count] = bs.bubbleSort(generateArray(variousSize[count]));
									bubbleEnd[count]=System.currentTimeMillis();
									
									selectStart[count]=System.currentTimeMillis();
									selectComparisons[count] = ss.selectionSort(generateArray(variousSize[count]));
									selectEnd[count]=System.currentTimeMillis();
									
									insertStart[count]=System.currentTimeMillis();
									insertComparisons[count] = is.insertionSort(generateArray(variousSize[count]));
									insertEnd[count]=System.currentTimeMillis();
									
								}	
								
								//lets display the results
								System.out.println("\n Here is the details of the sorting results for 6 different sized randomly generated arrays.");
								System.out.println("\n\t\t Algorithm \t\tArray Size\t\tComparisons \t\tTime required");
								for(int count=0;count<variousSize.length;count++)
								{
									System.out.println("\t\t Selection Sort"+"\t\t"+variousSize[count]+"\t\t\t"+selectComparisons[count]+"\t\t\t\t"+(selectEnd[count]-selectStart[count]) +"ms");		
									System.out.println("\t\t Bubble Sort"+"\t\t"+variousSize[count]+"\t\t\t"+bubbleComparisons[count]+"\t\t\t\t"+(bubbleEnd[count]-bubbleStart[count]) +"ms");
									System.out.println("\t\t Insertion Sort"+"\t\t"+variousSize[count]+"\t\t\t"+insertComparisons[count]+"\t\t\t\t"+(insertEnd[count]-insertStart[count]) +"ms");
									System.out.println("*************************************************************************************************************");
									
								}	
								//-------------------------------------------ENDS THE RANDOMLY GENERATED ARRAY------------------------------//
								
								//now lets do the same for presorted arrays
								
								for(int count=0;count<variousSize.length;count++)
								{
									bubbleStart[count]=System.currentTimeMillis();
									bubbleComparisons[count] = bs.bubbleSort(generatePresortedArray(variousSize[count]));
									bubbleEnd[count]=System.currentTimeMillis();
									
									selectStart[count]=System.currentTimeMillis();
									selectComparisons[count] = ss.selectionSort(generatePresortedArray(variousSize[count]));
									selectEnd[count]=System.currentTimeMillis();
									
									insertStart[count]=System.currentTimeMillis();
									insertComparisons[count] = is.insertionSort(generatePresortedArray(variousSize[count]));
									insertEnd[count]=System.currentTimeMillis();
									
								}	
								
								//lets display the results
								System.out.println("\n Here is the details of the sorting results for 6 different sized pre-sorted generated arrays.");
								System.out.println("\n\t\t Algorithm \t\tArray Size\t\tComparisons \t\tTime required");
								for(int count=0;count<variousSize.length;count++)
								{
									System.out.println("\t\t Selection Sort"+"\t\t"+variousSize[count]+"\t\t\t"+selectComparisons[count]+"\t\t\t\t"+(selectEnd[count]-selectStart[count]) +"ms");		
									System.out.println("\t\t Bubble Sort"+"\t\t"+variousSize[count]+"\t\t\t"+bubbleComparisons[count]+"\t\t\t\t"+(bubbleEnd[count]-bubbleStart[count]) +"ms");
									System.out.println("\t\t Insertion Sort"+"\t\t"+variousSize[count]+"\t\t\t"+insertComparisons[count]+"\t\t\t\t"+(insertEnd[count]-insertStart[count]) +"ms");
									System.out.println("*************************************************************************************************************");
									
								}
								
								//ask the user if S/He wants to continue
								System.out.println("\n\t Press '1', if you like to continue the program OR Press '0' if you like to exit.");
								check=in.nextInt();
								
								if(check==1)
									condition=true;
								else
								{
									if(check==0){
										System.out.println("//\n---------------------------------------------------------------------------//");
										System.out.println("\t!You have selected to exit. Thank you. I hope the program was satisfactory.!");
										condition=false;								
									}
								}
								
								
							}
						} //end case 4 here
				}
			}
		}
		else
		{
			System.out.println("\n You have provided the wrong value. Please enter correct value as mentioned above and continue,\n Please Note!!! Correct Values are (1, 2, 3, 4)");
			System.out.println("\n**********************************************************************************************************");
		}
	} // END WHILE LOOP
				
		
	}// end main class
	
	//function definition to generate array random numbers
    public static int[] generateArray(int size)
    {
    	// the array that will be returned to the user
		int[] theArray = new int[size];
		
		// use random to generate an array of numbers in the range [0, 500]
		Random random = new Random(1);
		for(int i = 0; i < size; i++)
			theArray[i] = random.nextInt(501);
		
		// return the array to the user
		return theArray;
    }
    
    //generate a pre-sorted array
    public static int[] generatePresortedArray(int size)
    {
    	// the array that will be returned to the user
		int[] theArray = new int[size];
		
		//lets populate the presorted array		
		for(int i = 0; i < size; i++)
			theArray[i] = i+1;
		
		// return the array to the user
		return theArray;
    }
    
    //function definition to convert arraylist to array
    public static int[] convert(ArrayList<Integer> arr) 
    {
        int[] intArray = new int[arr.size()];
        int count = 0;
        for(int i : arr){
            intArray[count++] = i;
        }
        return intArray;
    }

} //end of class
