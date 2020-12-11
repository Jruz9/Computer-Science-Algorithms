package sortingAlgorithms;

public class MaxPQ<Key extends Comparable>  {
    private Key[] pq;   //Heap ordered complete binary tree.
    private int n =0;
    public MaxPQ(int maxN)
    {
        pq=(Key[]) new Comparable[maxN+1];
    }
    public boolean isEmpty()
    {
        return n==0;
    }
    public Integer size()
    {
        return n;
    }
    public Key delMax()
    {
        Key max=pq[1];
        exch(1,n--);
        pq[n+1]=null;
        sink(1);
        return max;
    }

/*
    public  void heapsort(Comparable[] a)
    {
        int n=a.length;
        for(int k= n/2;k>=1;k--)
        {


        }
    }
*/

    //suplmenetary methods
    private boolean less(int i, int j)
    {
        return pq[1].compareTo(pq[j])<0;

    }
    private  void exch(int i, int j)
    {
        Key t=pq[i];
        pq[i]=pq[j];
        pq[j]=t;
    }
    private void swim(int k)
    {
        while (k>1 && less(k/2,k))
        {
            exch(k/2,k);
            k=k/2;
        }
    }
    private void sink(int k)
    {
        while (2*k <=n)
        {
            int j =2*k;
            if(j<n && less(j,j+1) ){
                j++;
            }
            if (!less(k,j)){
                break;
            }
            exch(k,j);
            k=j;

        }
    }

}
