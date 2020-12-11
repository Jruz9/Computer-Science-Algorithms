package sortingAlgorithms;

public class TopDownMergeSort extends AbstractMerge {
    private static Comparable[] aux;    //auxiliary array  for merges

    public static void sort(Comparable[] a)
    {
        aux= new Comparable[a.length];  //Allocate space just once
        sort(a,0,a.length); //this uses the sort method in the bottom and tells where it should merge sort.
    }
    private static  void sort(Comparable[] a, int lo, int hi)
    {
        // sort a [lo..hi]

        if(hi<=lo){
            return;
        }
        int mid =lo+(hi-lo)/2;  //calculates the middle number ex: 0-10 0+(10-0)/2 =5 or 0-9 0+(9-0) =4.5 ~4
        sort(a,lo,mid); //sorts the left recursively
        sort(a,mid+1,hi);   //sorts right recursively
        merge(a,lo,mid,hi);


    }
}
