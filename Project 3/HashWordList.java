/**
 * A class that stores and manipulates a collection of HashWordNodes
 * @author Jeremy Griffith
 */
public class HashWordList {
  
  // Stores the head of the list
  private HashWordNode head;
  // Stores the length of the chain
  private int hashLength;
  
  /**
   * The constructor creates an empty Linked List for chaining
   */
  public HashWordList() {
    head = null;
    hashLength = 0;
  }
  
  /**
   * The constructor creates an empty Linked List for chaining
   * @param head the front of the list
   */
  public HashWordList(HashWordNode head) {
    this.head = head;
    hashLength = 0;
  }
  
  /**
   * Sets the head of the list
   * @param head the front of the list
   */
  public void setHead(HashWordNode head) {
    this.head = head;
  }
 
  /**
   * Returns the head of the list
   * @return the head
   */
  public HashWordNode getHead() {
    return head;
  }
  
  /**
   * Returns the chain length
   * @return the chain length
   */
  public int getHashLength() {
    return hashLength;
  }
  
  /**
   * Increments the length count
   */
  public void incrementHashLength() {
    hashLength = hashLength + 1;
  }
  
}