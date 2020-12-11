package sortingAlgorithms;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class QuickSort extends Example {
    public static  void sort(Comparable[] a)
    {
        shuffle(a);
        sort(a,0,a.length-1);
    }

    private static void sort(Comparable[] a, int lo,int hi)
    {
        if(hi<=lo){
            return;
        }
        int j=partition(a,lo,hi);
        sort(a,lo,j-1); //sorts the left part a[lo...j-1]
        sort(a,j+1,hi); //sorts the right part a[j+1...hi]

    }

    private  static int partition(Comparable[] a, int lo, int hi)
    {
        //partition into a [lo..j-1], a[j],a[j+1..hi] and return j.
        int i=lo,j=hi+1;    //left and right scan indices
        Comparable v =a[lo];    //Partitioning item
        while (true)    //checks right and left. scans for completion and  exchange.
        {
            while(lessThan(a[++i],v))
            {
                if(i==hi)
                {
                    break;
                }
            }
            while (lessThan(v,a[--j]))
            {
                if(j==lo){
                    break;
                }
            }
            if (i>= j){
                break;
            }
        }
        exchange(a,lo,j);   //put partitioning item v into a[j].
        return j;           //with a [lo..j-1]<=a[j] <=a[j+1..hi]
    }

    public static void shuffle(Comparable [] a)
    {
        Random randomizer =new Random();
        for (int i =0;i<a.length;i++)
        {
            int randomIndexToSwap=randomizer.nextInt(a.length);
            Comparable temp=a[randomIndexToSwap];
            a[randomIndexToSwap]=a[i];
            a[i]=temp;

        }
    }
}
