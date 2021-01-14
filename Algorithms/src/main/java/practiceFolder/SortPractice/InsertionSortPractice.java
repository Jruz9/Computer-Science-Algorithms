package practiceFolder.SortPractice;
import sortingAlgorithms.Example;
public class InsertionSortPractice extends Example {

    public static void insertionSort(Comparable[] array)
    {
        Integer arraySize=array.length;

        for (int pointerOne=0;pointerOne<arraySize;pointerOne++){

            int pointerTwo;
            for (pointerTwo=pointerOne;pointerTwo>0 && lessThan(array[pointerTwo],array[pointerTwo-1]);pointerTwo--)
            {
                //pointertwo is current  and pointertwo-1 is the node behind
                //if front pointer is lower than back then exchange both.
                exchange(array,pointerTwo,pointerTwo-1);
            }

        }
    }
}
