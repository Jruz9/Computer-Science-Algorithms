package sortingAlgorithms;

import java.util.ArrayList;

public class AbstractMerge<data> extends Example {
    //this is a example of a normal merge sort;


    private static  void merge(Comparable[] a, int first,int middle,int lastNumber)
    {
        int firstHalfOfArrayNumber =first;
        int secondHalfNumber=middle+1;
        Comparable[] secondArray=new Comparable[lastNumber];

        for (int k=first; k<=lastNumber;k++)
        {
            secondArray[k]=a[k];
        }
        for (int k=first;k<=lastNumber;k++)
        {
            if(firstHalfOfArrayNumber>middle)
            {
                a[k]=secondArray[secondHalfNumber++];
            }

            else if (secondHalfNumber>lastNumber)
            {
                a[k]=secondArray[firstHalfOfArrayNumber++];
            }

            //this last 2  else if and else are the most imporant due to doing most of the work.
            else if (lessThan(secondArray[secondHalfNumber],secondArray[firstHalfOfArrayNumber]))
            {
                a[k]=secondArray[firstHalfOfArrayNumber++];
            }
            else {
                a[k]=secondArray[firstHalfOfArrayNumber++];
            }
        }
    }
}
