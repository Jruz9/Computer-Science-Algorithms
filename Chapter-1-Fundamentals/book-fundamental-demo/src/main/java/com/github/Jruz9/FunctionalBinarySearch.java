package com.github.Jruz9;

public class FunctionalBinarySearch {
    public static int indexOF(int[] a,int key)
    {
        //Array must be sorted
        int lo=0;
        int hi  = a.length -1;
        while (lo<=hi)
        {
            //Key is in a [lo..hi] or not present.
            //this will essentially do mid = 1-10 -> 1+(10-1)/2
            int mid=lo+(hi-lo)/2;
            if(key<a[mid])
            {
                hi =mid-1;

            }
            else if (key> a[mid])
            {
                lo=mid+1;
            }
            else {
                return mid;
            }
        }
        return  -1;
    }

    public static void main(String[] args)
    {
       //in the example they use their own array sorter to sort the array
    }
}

