package com.github.Jruz9;

public class RecursiveBinarySearch {

    public static int indexOf(int[] a,int key)
    {
        return indexOF(a,key,0,a.length-1);
    }
    public static int indexOF(int[] a,int key,int lo,int hi)
    {
        //Index of key in a[], if present, is not smaller than lo and not larger than hi.
        if(lo>hi){
            return -1;
        }
        int mid=lo+(hi-lo)/2;

        if(key<a[mid])
        {
            return indexOF(a, key, lo, mid-1);
        }
        else if (key>a[mid])
        {
            return indexOF(a, key,mid+1,hi);
        }
        else{
            return mid;
        }

    }
}
