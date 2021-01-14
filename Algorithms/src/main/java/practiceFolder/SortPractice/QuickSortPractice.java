package practiceFolder.SortPractice;

import sortingAlgorithms.Example;

import java.util.Random;

public class QuickSortPractice extends Example {


    public static void sort(Comparable[] primaryArray){
        shuffleArray(primaryArray);
        quickSort(primaryArray,0, primaryArray.length);
    }
    private static void quickSort(Comparable[] primaryArray,int lo,int hi){
        if (hi<=lo){
            return;
        }
        int partitionArray=partition(primaryArray,lo,hi);
        quickSort(primaryArray,lo,partitionArray-1);

    }
    private static int partition(Comparable[] primaryArray,int lo,int hi){
        int first=lo;
        int last=hi+1;
        Comparable copyArray =primaryArray[lo];
        while (true){
            while (lessThan(primaryArray[++first],copyArray)){
                if (first==last){
                    break;
                }
            }
            while (lessThan(copyArray,primaryArray[--last]))
            {
                if (last==lo){
                    break;
                }
            }
            if (first>=last){
                break;
            }
        }
        exchange(primaryArray,lo,last);
        return last;

    }
    private static void shuffleArray(Comparable[] primaryArray)
    {
        Random randomizer=new Random();
        for (int i=0; i<primaryArray.length;i++)
        {
            int randomIndexToSwap= randomizer.nextInt(primaryArray.length); //this took some time to find, probably does not work lol
            Comparable tempArray=primaryArray[randomIndexToSwap];   //this is the random number generated and put in an array for us to store
            primaryArray[randomIndexToSwap]=primaryArray[i];        //here we swap the random index number by the index pointed by our for loop.
            primaryArray[i]=tempArray;  //here we swap the for loop index number location  with the number from the number in the random index location
        }
    }
}
