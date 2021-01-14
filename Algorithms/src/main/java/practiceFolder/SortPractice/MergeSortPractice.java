package practiceFolder.SortPractice;

import sortingAlgorithms.AbstractMerge;

public class MergeSortPractice extends AbstractMerge {
    private static Comparable[] copyArray;

    public static  void sort(Comparable[] array){
        copyArray=new Comparable[array.length];
        mergeSort(array,0,array.length);
    }
    private static void  mergeSort(Comparable[] a,int lo,int hi){
        if (hi<=lo){
            return;
        }
        int mid=lo+(hi-lo)/2;
        mergeSort(a,lo,mid);
        mergeSort(a,mid,hi);
        merge(a,lo,mid,hi);
    }
}
