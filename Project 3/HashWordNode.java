/**
 * A node class that stores information about a word
 * @author Jeremy Griffith
 */
public class HashWordNode {
  
  // Stores the next node in the chain
  private HashWordNode next;
  // Stores the occurences of this word
  private int occurrences;
  // Stores the word
  private String word;
  
  /**
   * The constructor
   * @param word the word to add to the node
   */
  public HashWordNode(String word) {
    this.word = word;
    occurrences = 1;
    next = null;
  }
  
  /**
   * Returns this node's word
   * @return word
   */
  public String getWord() {
    return word;
  }
  
  /**
   * Returns the occurrences of this word
   * @return occurrences
   */
  public int getOccurrences() {
    return occurrences;
  }
  
  /**
   * Sets the occurrences for the node
   * @param occur the number of occurrences
   */
  public void setOccurrences(int occur) {
    this.occurrences = occur;
  }
  
  /**
   * Increments the occurrences
   */
  public void incrementOccurrences() {
    occurrences = occurrences + 1;
  }
  
  /**
   * Sets the next node
   * @param next the next node
   */
  public void setNext(HashWordNode next) {
    this.next = next;
  }
  
  /**
   * Returns the next node
   * @return the next node
   */
  public HashWordNode getNext() {
    return next;
  }
  
}