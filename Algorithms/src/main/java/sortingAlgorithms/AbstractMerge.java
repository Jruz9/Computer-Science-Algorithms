package sortingAlgorithms;

import java.util.ArrayList;

public class AbstractMerge<data> extends Example {
    //this is a example of a normal merge sort;


    public static  void merge(Comparable[] a, int firstNumber,int middleNumber,int lastNumber)
    {
        int firstHalfOfArrayNumber =firstNumber;
        int secondHalfNumber=middleNumber+1;
        Comparable[] secondArray=new Comparable[lastNumber];

        for (int k=firstNumber; k<=lastNumber;k++)
        {
            secondArray[k]=a[k];
        }
        for (int k=firstNumber;k<=lastNumber;k++)
        {
            if(firstHalfOfArrayNumber>middleNumber)
            {
                a[k]=secondArray[secondHalfNumber++];
            }

            else if (secondHalfNumber>lastNumber)
            {
                a[k]=secondArray[firstHalfOfArrayNumber++];
            }

            //these last 2  if statements are the most important due to doing most of the work.
            //This else if will look if the second half of the array is
            else if (lessThan(secondArray[secondHalfNumber],secondArray[firstHalfOfArrayNumber]))
            {
                a[k]=secondArray[secondHalfNumber++];
            }
            else {
                a[k]=secondArray[firstHalfOfArrayNumber++];
            }
        }
    }
}
