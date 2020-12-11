package sortingAlgorithms;
// this is a bottom up merge implmentation
//I lke this better than the other one.
public class MergeBU extends AbstractMerge {
    private static Comparable[] aux;

    public static void sort(Comparable[] a)
    {
        // do lg n passes of pair wise merges
        int n =a.length;
        aux=new Comparable[n];
        for(int len=1; len<n; len *=2)
        {
            for(int lo=0; lo < n-len; lo+=len+len){
                merge(a,lo,lo+len-1,Math.min(lo+len+len-1,n-1));

            }
        }
    }
}
