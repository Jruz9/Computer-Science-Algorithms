package practiceFolder.SortPractice;

import sortingAlgorithms.Example;

public class ShellSortPractice extends Example {

    public static void shellSort(Comparable[] array){
        Integer arraySize= array.length;
        Integer currentSpot=1;

        while (currentSpot<arraySize/3)
        {
            currentSpot=(3*currentSpot)+1;
        }

        while (currentSpot>=1){
            for (int pointer=currentSpot;pointer<currentSpot++;pointer++)
            {
                for (int pointerTwo=pointer;pointerTwo>=currentSpot && lessThan(array[pointerTwo],array[pointerTwo-currentSpot]);pointerTwo-=currentSpot)
                {
                    exchange(array,pointerTwo,pointerTwo-currentSpot);
                }
                currentSpot=currentSpot/3;
            }
        }
    }

}
