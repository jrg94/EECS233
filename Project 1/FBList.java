/**
 * An ADT that provides the frame for implementation
 * @author Jeremy Griffith
 */
public interface FBList {
  
  /**
   * Returns the size of the list
   * @return size of the list
   */
  public int size();
  
  /**
   * Inserts a new component into the list
   * @param i specifies the location in the list
   * @param person provides the Object to insert into the list
   */
  public void insert(int i, Person person);
  
  /**
   * Removes an item from the list
   * @param i specifies the location in the list
   * @return the Object that was removed
   */
  public Person remove(int i);
  
  /**
   * Returns a Person at a specified index
   * @param i specifies the location in the list
   * @return the Object that was at index i
   */
  public Person lookup(int i);
}