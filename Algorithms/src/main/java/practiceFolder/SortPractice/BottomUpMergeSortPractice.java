package practiceFolder.SortPractice;

import sortingAlgorithms.AbstractMerge;

public class BottomUpMergeSortPractice  extends AbstractMerge {
    private static Comparable[] copyArray;  //second array to copy and exchange it with other

    public static void sort(Comparable[] array){
        Integer arrayLength= array.length;
        copyArray=new Comparable[arrayLength];

        for(int length=1;length<arrayLength;length*=2)
        {
            for (int lo=0;lo<lo-length;lo+=length+length){
                Integer middleNumber=lo+length-1;
                Integer getMinimumOfTwoNumber=Math.min(lo+(length*2)-1,arrayLength-1);

                merge(array,lo,middleNumber,getMinimumOfTwoNumber); //create better names and format to remember this.
            }
        }
    }
}
