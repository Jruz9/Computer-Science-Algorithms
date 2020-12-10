package sortingAlgorithms;

public class selectionSort extends Example  {
    public static void sort(Comparable[] a)
    {
        //sorts a[] into increasing order
        Integer arraySize = a.length;
        for(int i=0; i<arraySize; i++)
        {
            //exchanges a[i] with smallest entry in a[i] ,... a[n-1].
            //a[n-1] is the index of the minimal entry
            Integer minimumNumber=i;
            for(int j=i+1;j<arraySize;j++)
            {
                if(lessThan(a[j],a[minimumNumber])) {
                    minimumNumber=j;
                }

                else {
                    exchange(a,i,minimumNumber);
                }
            }
        }
    }
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
