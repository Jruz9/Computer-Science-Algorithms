package sortingAlgorithms;

//this contains the classes we will implment to the program to avoid too much work bruh (sorry)
public class Example {
    public static void sort(Comparable[] a)
    {
    // the implmentation of this will be in the following examples of sort algorithm

    }
    private static boolean lessThan(Comparable firstValue, Comparable secondValue)
    {
        //compares if the first value is less than the second value
        //true if less than zero
        //false if more than zero
        return firstValue.compareTo(secondValue)<0;

    }
    private static void exchange(Comparable[] a, int i, int j)
    {
        Comparable t =a[i];
        a[i]=a[j];
        a[j]=t;
    }
    public static boolean isSorted(Comparable[] a)
    {
        for(int i =1;i<a.length;i++)
        {
            if(lessThan(a[i],a[i-1])){
                return false;
            }
        }
        return true;
    }
    public static void main(String arg[])
    {
        String testString = "thisisastring";
        String[] a=testString.split("");
        sort(a);
        assert isSorted(a);
        System.out.println(a[0]);
    }
}
