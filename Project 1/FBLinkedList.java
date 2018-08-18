/**
 * A class that manipulates Objects through a LinkedList
 * @author Jeremy Griffith
 */
public class FBLinkedList implements FBList {
  
  // Stores the address of the first element in the list
  private LLNode<Person> head;
  
  /**
   * The constructor for this class
   */
  public FBLinkedList() {
    head = null;
  }
  
  /**
   * Returns the head node.
   * @return the head node
   */
  protected LLNode<Person> getHead() {
    return head;
  }
  
  /**
   * Changes the head node.
   * @param head  the first node of the new linked list
   */
  protected void setHead(LLNode<Person> head) {
    this.head = head;
  }
  
  /**
   * Returns the length of the linked list
   * @return the number of nodes in the list
   */
  public int size() {
    int lengthSoFar = 0;
    LLNode<Person> nodeptr = getHead();
    // Keeps track of the length until the end is met
    while (nodeptr != null) {
      lengthSoFar++;
      nodeptr = nodeptr.getNext();
    }
    return lengthSoFar;
  }
  
  /**
   * Inserts an element into the list
   * @param i the location of insertion
   * @param person the element you wish to insert
   */
  public void insert(int i, Person person) {
    LLNode<Person> nodeptr;
    // Creates the first node if the list does not exist
    if (size() == 0) {
      setHead(new LLNode<Person>(person, getHead()));
    }
    // Adds the element to the end if the input exceeds the length
    else if (i > size()) {
      nodeptr = head;
      for(int counter = 0; counter < size(); counter++) {
      }
      nodeptr.setNext(new LLNode<Person>(person, null));
    }
    // Otherwise, adds the element to the correct location
    else {
      nodeptr = head;
      for(int counter = 0; counter < i && nodeptr.getNext() != null; counter ++) {
        nodeptr = nodeptr.getNext();
      }
      nodeptr.setNext(new LLNode<Person>(person, nodeptr.getNext()));
    }
  }
  
  /**
   * Removes an element from the list
   * @param i the location of removal
   * @return the element being removed
   */
  public Person remove(int i) {
    LLNode<Person> nodeptr;
    int counter = 0;
    // Doesn't remove anything if the input is larger than the array
    if (i > this.size()) {
      return null;
    }
    // Otherwise, removes the element from index 'i'
    else {
      for(nodeptr = this.getHead(); counter < i - 1; counter = counter + 1) {
        nodeptr = nodeptr.getNext();
      }
      LLNode<Person> nextNode = nodeptr.getNext();
      nodeptr.setNext(nodeptr.getNext().getNext());
      nextNode.setNext(null);
      return nextNode.getElement();
    }
  }
    
  /**
   * Returns an element in the list based on an index
   * @param i the index
   * @return the element found at index 'i'
   */
  public Person lookup(int i) {
    LLNode<Person> nodeptr;
    int counter = 0;
    // Runs through to the index needed
    for(nodeptr = this.getHead(); counter < i; counter = counter + 1) {
        nodeptr = nodeptr.getNext(); 
    }
    return nodeptr.getElement();
  }
  
  /**
   * The iterator for the list
   * @return an Iterator object
   */
  public Iterator iterator(){
    Iterator iter = new Iterator();  
    return iter;
  }
  
  /**
   * The iterator class for FBLinkedList
   */
  public class Iterator {
    private LLNode<Person> nextNode;
    private int counter;
    
    /**
     * The constructor for the Iterator
     */
    private Iterator (){
      nextNode = head;
    }
    
    /**
     * Returns true if there is another element
     * @return true if there is an element after this element
     */
    public boolean hasNext() {
      if (nextNode.getElement() == null) {
        return false;
      }
      else {
        return true;
      }
    }
    
    /**
     * Returns the next element
     * @return the next element
     */
    public Person next() {
      LLNode<Person> node = nextNode;
      nextNode = nextNode.getNext();
      return node.getElement();
    }
  }
}