/**
 * A class that represents a person
 * @author Jeremy Griffith
 */
public class Person {
  
  // The person's name
  private String personID;
  // The person's phone number
  private long phoneNum;
  
  /**
   * Constructs the instance of this class
   * @param personID the name of the person
   * @param phoneNum the number of this person
   */
  public Person(String personID, long phoneNum) {
    this.personID = personID;
    this.phoneNum = phoneNum;
  }
  
  /**
   * Returns the name of this person
   * @return the name of this person
   */
  public String getName() {
    return personID;
  }
  
  /**
   * Returns this person's number
   * @return this person's number
   */
  public long getNum() {
    return phoneNum;
  }
  
  /**
   * Returns the prefix of this persons phone number
   * @return the first three digits of this number
   */
  public long getPrefix() {
    int num = (int)phoneNum/10000;
    return num;
  }
}