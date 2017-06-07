//======================================================================================================================
//Sai Ram Thota
//CS 4343 Data Structures
//Assignment 5
//CWID: 11573236
//email id: tsairam@okstate.edu

//Run the program thrice, using 1,2 and 3 as your input for different partition selection.
// Repeat the same process for three cases for "InputArray.txt", "QS-TestCase-1.txt",
//and "QS-TestCase-2.txt" respectively. You need to edit the file name and the array size each time you change the file.
//=======================================================================================================================
import java.lang.Long;
import java.io.*;
import java.util.*;

public class QuickSort {
    static int countOfCompares = 0;
    
    
    public static int partitionSorting (int[] tempArray, int low, int high)
    {
        int temp1 = low, temp2 = high+1;
        while(true){
            while(tempArray[++temp1] < tempArray[low]) {
                countOfCompares++;
                if(temp1==high) break;
            }
            while(tempArray[low] < tempArray[--temp2]){
                countOfCompares++;
                if(temp2==low) break;
            }
            if(temp1>=temp2) break;
            swapValues(tempArray, temp1, temp2);
        }
        swapValues(tempArray,low,temp2);
        return temp2;
    }
    
    public static int medianOfThree (int[] tempArray, int low, int middle , int high)
    {
        
        if (tempArray[low] > tempArray[middle])
            swapValues(tempArray, low, middle);
        
        if (tempArray[low] > tempArray[high])
            swapValues(tempArray, low , high);
        
        if (tempArray[middle] > tempArray[high])
            swapValues(tempArray, middle, high);
        
        swapValues(tempArray, middle, high - 1);
        return tempArray[high - 1];
    }
    
    public static void sort(int[] tempArray, int low , int high)
    {
        if( high <= low ) return;
        
        int temp2 = partitionSorting(tempArray, low , high);
        sort(tempArray, low , temp2-1);
        sort(tempArray, temp2+1, high);
        
    }
    
    public static void sort(int[] tempArray, int choiceOfPivotSelection) {
        
        int low  = 0;
        int high = tempArray.length - 1;
        
        
        
        
        switch(choiceOfPivotSelection)
        {
            // Case 1: Will use first emlem as pivot
            case 1:
                sort(tempArray, low , high);
                break;
            // Case 2: Pivot is randomly generated
            case 2:
                Random temp4 = new Random();
                int temp5 = temp4.nextInt((high - low ) + 1) + low ;
                swapValues(tempArray, high, temp5);
                sort(tempArray, low , high);
                break;
                
            // Case 3: Pivot is taken by median of 3
            case 3:
                int median = medianOfThree(tempArray, low , low  + ((high-low )/2) , high);
                swapValues(tempArray, low , median);
                sort(tempArray, low , high);
                break;
                
            default:
                break;
        }
        
    }
    
    public static void main(String[] args) throws Exception
    {
        File inputArray = new File("InputArray.txt");
        Scanner tempScanner = new Scanner(inputArray);
        int[] array = new int[100000];
        
        int temp1 = 0;
        while(tempScanner.hasNext()){
            if(tempScanner.hasNextInt()){
                array[temp1] = tempScanner.nextInt();
                temp1++;
            }
        }
        
        
        System.out.println("Enter your choice of pivot selection: ('1', '2', '3')");
       
        Scanner tempScanner1 = new Scanner(System.in);
        int choiceOfPivotSelection = tempScanner1.nextInt();
       
        
        long runTime1 = System.currentTimeMillis();
        sort(array,choiceOfPivotSelection);
        long runTime2 = System.currentTimeMillis();
        long resultTime = runTime2 - runTime1;
        
        System.out.println("Case " + choiceOfPivotSelection + " resultTime:"+resultTime);
        System.out.println("Case " +choiceOfPivotSelection+" countOfCompares: "+countOfCompares);
       
        
    }
    
    public static void swapValues (int tempArray[], int temp6, int temp7)
    {
        int temp8 = tempArray[temp6];
        tempArray[temp6] = tempArray[temp7];
        tempArray[temp7] = temp8;
    }
}
