/*
    Sai Ram Thota
    CWID 11573236
    tsairam@okstate.edu
    Homework 3: CS4343: Data Structures
*/

import java.util.*;
import java.io.*;

public class Homework3{

    public static void main(String[] args)
    {
        File input1 = new File("Input-1.txt");
        File input2 = new File("Input-2.txt");
        ArrayList<Long> small = new ArrayList<Long> ();
        ArrayList<Long> large = new ArrayList<Long> ();
    
        try
        {
            Scanner m = new Scanner(input1);
            Scanner n = new Scanner(input2);
            
            while(m.hasNextLine())
            {
                String temp = m.nextLine();
                long k = Long.parseLong(temp);
                small.add(k);
            }
            m.close();
            while(n.hasNextLine())
            {
                String temp = n.nextLine();
                large.add(Long.parseLong(temp));
            }
            n.close();
            
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
       
        long time1 = System.currentTimeMillis();
        insertionSort(small);
        long time2 = System.currentTimeMillis();
        
        
        long time3 = System.currentTimeMillis();
        insertionSort(large);
        long time4 = System.currentTimeMillis();
        
        long time5 = System.currentTimeMillis();
        hilbertShellSort(small);
        long time6 = System.currentTimeMillis();
        
        long time7 = System.currentTimeMillis();
        hilbertShellSort(large);
        long time8 = System.currentTimeMillis();
        
        long time9 = System.currentTimeMillis();
        oddShellSort(small);
        long time10 = System.currentTimeMillis();
        
        long time11 = System.currentTimeMillis();
        oddShellSort(large);
        long time12 = System.currentTimeMillis();
         
        System.out.println("Time taken for small Insertion sort " + (time2 - time1) + " milliseconds");
        System.out.println("Time taken for  large Insertion sort " + (time4 - time3)+ " milliseconds");
        System.out.println("Time taken for  small Hilbert Shell sort " + (time6 - time5)+ " milliseconds");
        System.out.println("Time taken for  large Hilbert Shell sort " + (time8 - time7)+ " milliseconds");
        System.out.println("Time taken for  small Odd Shell sort " + (time10 - time9)+ " milliseconds");
        System.out.println("Time taken for  large Odd Shell sort " + (time12 - time11)+ " milliseconds");
  
    }//EndofMainMethod
    
    public static void insertionSort(ArrayList<Long> Input) {
        
        int i, j;
        long key = 0;
        
        for (i = 1; i < Input.size(); i++)
        {
            
            key = Input.get(i);
    
            j = i;
            while((j > 0) && (Input.get(j - 1) > key))
            {
                Input.set(j,Input.get(j - 1));
                j--;
            }
            Input.set(j,key);
        }
        
        //Output
        //for(int n =0;n<Input.size();n++)
        //{
        //  System.out.println(Input.get(n));
        //}
        
    }//End of insertion sort
    
    public static void hilbertShellSort(ArrayList<Long> a)
    {
        int x, y;
        long t; //temperary variable
        int s = 1; //increment variable
        int n = 0; //incrementing factor
        
        while (s <= a.size()+1)
        {
            for (x = s; x<=a.size()-1; x++)
            {
                t = a.get(x);
                y = x;
                while ( y >= s && a.get(y-s) > t)
                {
                    a.set(y,a.get(y-s));
                    y = y - s;
                }
                a.set(y,t);
            }
            n = n + 1;
            s = (int)(java.lang.Math.pow(2,n))-(int)1;
            //Hilbert incrementation with 2^s-1
        }
        
        //Output
        //for(n =0;n<a.size();n++)
        //{
        //    System.out.println(a.get(n));
        // }
        
    }//EndofHilbertShellSort
    
    public static void oddShellSort(ArrayList<Long> a)
    {
        int x, y;
        long t; //temperary variable
        int s = 1; //increment variable
        int n = 0; //incrementing factor
        
        while (s <= a.size()+1)
        {
            for (x = s; x<=a.size()-1; x++)
            {
                t = a.get(x);
                y = x;
                while ( y >= s && a.get(y-s) > t)
                {
                    a.set(y,a.get(y-s));
                    y = y - s;
                }
                a.set(y,t);
            }
            n = n + 1;
            s = (2*s)+1;
            //Adding odd increments of 2s+1
        }
        
        //Output
        //for(n =0;n<a.size();n++)
        //{
        //  System.out.println(a.get(n));
        //}
        
    }//EndofOddShellSort
}//EndofClass
