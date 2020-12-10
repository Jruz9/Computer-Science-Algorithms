package sortingAlgorithms;

public class ShellSort extends Example {
    public static void sort(Comparable[] a)
    {
        int arrayLength=a.length;
        int hSpot =1;
        while(hSpot<arrayLength/3)
        {
            hSpot=(3*hSpot)+1;    //1,4,13,40,121
        }

        while (hSpot>=1)
        {
            for (int i=hSpot;i<arrayLength;i++)
            {
                //Insert a[i] among a[i-h], a[i-h*2],a[i-h*2],.....
                for (int j=i; j>=hSpot && lessThan(a[j],a[j-hSpot]); j -=hSpot)
                {
                    exchange(a,j,j-hSpot);
                }
                hSpot=hSpot/3;
            }
        }
    }

    //has bug with getting is instead of a for some reason;
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
