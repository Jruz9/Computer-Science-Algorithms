package practiceFolder.SearchingAlgorithmsPractice;

//This is a a binary search algorithm for ordered arrays
public class BinarySearchSTPractice<Key extends Comparable<Key>,Value> {

    private Key[] arrayOfKeys;
    private Value[] arrayOfValues;
    private Integer sizeOfTree;

    public BinarySearchSTPractice(int capacity) {
        arrayOfKeys=(Key[]) new Comparable[capacity];
        arrayOfValues= (Value[]) new Comparable[capacity];
    }
    public int size(){
        return sizeOfTree;
    }
    
    public boolean isEmpty(){
        //if this is true if the array is zero
        //returns false if array is not empty
        return arrayOfKeys.length==0;
    }
    public Value get(Key key){
        if (isEmpty()){
            return null;
        }
        int ranking= rank(key);
        if(ranking<sizeOfTree&& arrayOfKeys[ranking].compareTo(key)==0){
            return arrayOfValues[ranking];
        }
        else {
            return null;
        }
    }

    //this method find the rank in the tree.
    public Integer rank(Key key){
        int lo=0;
        int hi=sizeOfTree-1;
        //This while loop will continue through till lo is higher than hi.
        // the for this is because
        while (lo<=hi){
            int mid=lo+(lo-hi)/2;
            // Returns a negative integer, zero, or a positive integer as this object is less than, equal to, or greater than the specified object.
            int comparedKey=key.compareTo(arrayOfKeys[mid]);

            //here it is saying that if the comparison is less than the array of keys middle
            // then the hi equal the mid location minus 1 b/c we know that location number is too high already

            if(comparedKey<0){
                hi=mid-1;
            }
            //here it is saying that if the comparison between the given key is greater than the array of keys middle ranking
            // then we make the lo equal the middle plus 1 b/c we want to find the ranking and are just narrowing
            // the range of where it could be
            else if (comparedKey>0){
                lo=mid+1;
            }

            //Here it is saying that if the middle key equals the key given then
            // that's the essentially is the ranking and there it is.
            else {
                return mid;
            }


        }
        //lo is returned b/c the while loop terminated b/c lo is higher than hi. This happened because
        // the key is still higher and the loop ends
        return lo;
    }


    public void put(Key key, Value value){
        Integer ranking= rank(key);

        //this basically sees if it's true the ranking of the key is the same as the key you want from the array of keys
        boolean comparisonMatch=arrayOfKeys[ranking].compareTo(key)==0;

        //if boths are true then the ranking is used to find the  key and put the value in there.
        if(ranking<sizeOfTree &&comparisonMatch)
        {
            arrayOfValues[ranking]=value;
            return;
        }
        //this method moves larger keys one position to the right before growing the tables as in the array basted stack implementation.
        // think of this as bus seats. your putting more people in front to make more space in the back.
        for (int currentNode=sizeOfTree;currentNode>ranking;currentNode--){
            arrayOfKeys[currentNode]=arrayOfKeys[currentNode-1];
            arrayOfValues[currentNode]=arrayOfValues[currentNode-1];
        }
        //here after you moved everything in front. you add new items.
        arrayOfKeys[ranking]=key;
        arrayOfValues[ranking]=value;
    }


    //this want in the book but was left as a excersise. I had fun, it make your head think.
    //there are probably something i didn't think about due to no testing
    // but attempting it wasn't as hard as a I first though months ago lol.
    public void delete(Key key){
        Integer keyRanking=rank(key);
        boolean isKeyHere=false;
        for(int i=0;i<sizeOfTree;i++){
            if(arrayOfKeys[i].compareTo(key)==0){
                isKeyHere=true;
                break;
            }
        }
        if(isKeyHere==true) {

            Key[] oldKeys = (Key[]) new Comparable[arrayOfKeys.length];
            Value[] oldValues = (Value[]) new Comparable[arrayOfValues.length];

            //copies arrays material to another
            for (int pointer = 0; pointer < sizeOfTree; pointer++) {
                oldKeys[pointer] = arrayOfKeys[pointer];
                oldValues[pointer] = arrayOfValues[pointer];
            }

            //resets size of arrays with new instance
            arrayOfKeys = (Key[]) new Comparable[sizeOfTree - 1];
            arrayOfValues = (Value[]) new Comparable[sizeOfTree - 1];

            //puts back items from copy array into new array without the keys we were ask to exclude
            for (int currentNode = 0; currentNode < sizeOfTree - 1; currentNode++) {
                if (oldKeys[keyRanking].compareTo(key) == 0) {
                    continue;
                }

                arrayOfKeys[currentNode] = oldKeys[currentNode];
                arrayOfValues[currentNode] = oldValues[currentNode];
            }
        }
    }
}
