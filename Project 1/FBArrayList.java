/**
 * A class that manipulates an array of Objects
 * @author Jeremy Griffith
 */
public class FBArrayList implements FBList {
  
  // Stores the array for this data structure
  private Person[] arrayList;
  
  /**
   * The cosntructor for this class
   */
  public FBArrayList() {
    arrayList = new Person[10];
  }
  
  /**
   * Returns the size of the list
   * @return the size of the list
   */
  public int size() {
    return arrayList.length;
  }
  
  /**
   * Inserts an element into the list
   * @param i the index in the array
   * @param person the person to be placed in the list
   */
  public void insert(int i, Person person) {
    // Checks to see if i is outside the array
    if (i > arrayList.length - 1) {
      arrayList[arrayList.length - 1] = person;
    }
    // Checks to see if 'i' is empty
    else if(arrayList[i] != null) {
      // Checks to see if the last element is empty
      if(arrayList[arrayList.length - 1] != null) {
        Person[] newArray = new Person[arrayList.length + 10];
        // Creates a larger array from the original array
        for(int index = 0; index < arrayList.length; index++) {
          newArray[index] = arrayList[index];
        }
        arrayList = newArray;
      }
      // If it is empty, it is okay to shift the array down
      else {
        // Shifts the array down (Works best if array is sorted)
        for(int index = (arrayList.length - 1); index >= i; index--) {
          arrayList[index] = arrayList[index - 1];
        }
        arrayList[i] = person;
      }
    }
    // If 'i' is empty, the element is placed in the hole
    else {
      arrayList[i] = person;
    }
  }
  
  /**
   * Removes an element from the list
   * @param i the location of removal
   * @return the item being removed
   */
  public Person remove(int i) {
    // Checks to see if 'i' is outside the array
    if (i > arrayList.length) {
      return null;
    }
    // Checks to see if the element at 'i' is null
    else if (arrayList[i] == null) {
      return null;
    }
    // Otherwise, the program removes element 'i'
    else {
      Person p = arrayList[i];
      arrayList[i] = null;
      return p;
    }
  }
    
  /**
   * Returns an element in the list based on an index
   * @param i the location to be searched
   * @return the item at location 'i'
   */
  public Person lookup(int i) {
    return arrayList[i];
  }
  
  /**
   * Returns an iterator
   * @return the iterator
   */
  public Iterator iterator(){
    Iterator iter = new Iterator();  
    return iter;
  }
  
  /**
   * The Iterator class
   */
  public class Iterator {
    private Person nextNode;
    private int counter;
    
    /**
     * The Iterator constructor
     */
    private Iterator (){
      nextNode = arrayList[0];
      counter = 1;
    }
    
    /**
     * Returns true if the sequence contains another element
     * @return true if the next element does not equal null
     */
    public boolean hasNext() {
      if (nextNode == null) {
        return false;
      }
      else {
        return true;
      }
    }
    
    /**
     * Returns the next element in the sequence
     * @return the next element in the sequence
     */
    public Person next() {
      nextNode = arrayList[counter];
      counter++;
      return arrayList[counter - 1];
    }
  } 
}