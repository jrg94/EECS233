/**
 * A demo class for FBList and its components
 * @author Jeremy Griffith
 */
public class ProjectDemo {
  
  /**
   * A static class that returns the number of people with the same area code
   * @param list takes a list of type FBList to be searched
   * @param prefix a long that represents the area code
   * @return a long that stands for the number of people in the same area code
   */
  public static long localsTotNum(FBList list, long prefix) {
    long counter = 0;
    for(int index = 0; index < list.size(); index++) {
      if (list.lookup(index) == null) {
      }
      else if (list.lookup(index).getPrefix() == prefix) {
        counter++;
      }
      else {
      }
    }
    return counter;
  }
  
  /**
   * Runs this class
   * @param args takes array of Strings
   */
  public static void main(String[] args) {
    Person a = new Person("Bob", 8145334);
    Person b = new Person("Chris", 7342341);
    Person c = new Person("Hank", 8143431);
    Person d = new Person("Joe", 6551223);
    Person e = new Person("Betty", 7346256);
    FBArrayList list1 = new FBArrayList();
    FBLinkedList list2 = new FBLinkedList();
    list1.insert(0,a);
    list1.insert(1,b);
    list1.insert(2,c);
    list1.insert(3,d);
    list1.insert(4,e);
    list2.insert(0,a);
    list2.insert(1,b);
    list2.insert(2,c);
    list2.insert(3,d);
    list2.insert(4,e);
    System.out.println("FBArrayList has " + localsTotNum(list1, 814) + " phone numbers in it that match this prefix.");
    System.out.println("FBLinkedList has " + localsTotNum(list2, 734) + " phone numbers in it that match this prefix.");
  }
}