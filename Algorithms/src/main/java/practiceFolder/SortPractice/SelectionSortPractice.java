package practiceFolder.SortPractice;
import sortingAlgorithms.Example;

//an arraylist implementation would probably make more sense to be honest
public class SelectionSortPractice extends Example  {

    public static void  sort(Comparable[] array){
        int arraySize=array.length;

        for (int pointerOne = 0; pointerOne<arraySize; pointerOne++)
        {
            Integer minimumNumber=pointerOne;   //this intializes the minimum number
            for (int pointerTwo = pointerOne+1; pointerTwo<arraySize; pointerTwo++){
                if(lessThan(array[pointerOne],array[minimumNumber])){
                    //if the pointer one array location is lower than the array minimum number, it is now assign the new lowest number
                    minimumNumber=pointerTwo;   //this basically assigns the location pointer of where the minimum number is located (kinda smart and stupid)
                }
                else{
                    exchange(array,pointerOne,minimumNumber);
                }

            }
        }


    }
}
