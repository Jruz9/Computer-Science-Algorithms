package sortingAlgorithms;

public class InsertionSort extends Example {
    //sort array[] into increasing order.
    public static void sort(Comparable[] a)
    {
        Integer arraySize=a.length;
        for(int i=1; i<arraySize;i++){
            //Inserts a[i] among a[i-2].....a[i-n]
            for (int j=i;j>0 && lessThan(a[j],a[j-1]);j--)
            {
                exchange(a,j,j-1);
            }
        }

    }
    //test the alogirithm
    public static void main(String arg[])
    {
        //works this uses the selection sort algo
        String testString = "this is a string";
        String[] a=testString.split(" ");
        sort(a);
        assert isSorted(a);
        System.out.println(a[0]);
    }
}
