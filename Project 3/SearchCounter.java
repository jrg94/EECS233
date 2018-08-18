import java.io.*;
import java.util.*;

/**
 * A class that records word occurences in a document
 * @author Jeremy Griffith
 */
public class SearchCounter {
  
  /**
   * Prints the contents of the table in the format (Word: Count)
   * @param table an array of HashWordLists
   */
  public static String printTable(HashWordList[] table) {
    HashWordNode nodeptr;
    StringBuilder builder = new StringBuilder();
    int totalChain = 0;
    // Runs through the hash table
    for (int i = 0; i < table.length; i++) {
      // Checks to see if this index contains an element
      if(table[i] != null) {
        totalChain = totalChain + table[i].getHashLength();
        // Runs through the chain in each table index
        for(nodeptr = table[i].getHead(); nodeptr != null; nodeptr = nodeptr.getNext()) {
          builder.append("(" + nodeptr.getWord() + ": " + nodeptr.getOccurrences() + ")");
        }
      }
    }
    // Appends a message detailing the average chain length
    builder.append(" The average chain length is " + (double)totalChain / table.length + 
                       " which is roughly " + Math.round((double)totalChain / table.length) + ".");
    return builder.toString();
  }
  
  /**
   * Hashes a word and stores it in the array
   * @param table takes a table
   * @param word takes a word to be hashed
   */
  public static void hash(HashWordList[] table, String word) {
    HashWordNode nodeptr;
    int i = Math.abs(word.hashCode()) % table.length;
    // Checks to see if this table contains a list at this index
    if (table[i] == null) {
      table[i] = new HashWordList(new HashWordNode(word));
    }
    // Otherwise, it checks the list for the word
    else {
      nodeptr = table[i].getHead();
      // Runs through the chain until it hits the word or it hits the end
      while (!nodeptr.getWord().equals(word) && nodeptr.getNext() != null) {
        nodeptr = nodeptr.getNext();
      }
      // If the loop stopped at a word, increment count
      if(nodeptr.getWord().equals(word)) {
        nodeptr.incrementOccurrences();
      }
      // Otherwise, insert the word at the end of the chain and increment the length of the chain
      else {
        nodeptr.setNext(new HashWordNode(word));
        table[i].incrementHashLength();
      }
    }
  }
  
  /**
   * Alternate version of the hash method used for rehashing
   * @param table the array that you wish to have an element hashed into
   * @param word a word that you wish to have hashed
   * @param occurrences the number of occurrences of this word
   */
  public static void hash(HashWordList[] table, String word, int occurrences) {
    HashWordNode nodeptr;
    int i = Math.abs(word.hashCode()) % table.length;
    // Checks to see if this table contains a list at this index
    if (table[i] == null) {
      table[i] = new HashWordList(new HashWordNode(word));
      table[i].getHead().setOccurrences(occurrences);
    }
    // Otherwise, it checks the list for the word
    else {
      nodeptr = table[i].getHead();
      // Runs through the chain until it hits the word or it hits the end
      while (!nodeptr.getWord().equals(word) && nodeptr.getNext() != null) {
        nodeptr = nodeptr.getNext();
      }
      // If the loop stopped at a word, increment count
      if(nodeptr.getWord().equals(word)) {
        nodeptr.incrementOccurrences();
      }
      // Otherwise, insert the word at the end of the chain and increment the length of the chain
      else {
        HashWordNode node = new HashWordNode(word);
        node.setOccurrences(occurrences);
        nodeptr.setNext(node);
        table[i].incrementHashLength();
      }
    }
  }
   
  /**
   * Counts the words in a document and records the counts in an output file
   */
  public void wordCount(String input_file, String output_file) {
    HashWordList[] hashTable = new HashWordList[2];
    int wordCount = 0;
    try {
      Scanner scanner = new Scanner(new FileReader(input_file));
      scanner.useDelimiter("[\\s\\p{Punct}]+");
      // Checks to see if the file has another word
      while(scanner.hasNext()) {
        String word = scanner.next();
        // Converts the word to lower case
        word = word.toLowerCase();
        wordCount = wordCount + 1;
        SearchCounter.hash(hashTable, word);
        // Checks to see if the number of words scanned is equal to or greater than the table size 
        if(wordCount >= hashTable.length) {
          HashWordList[] table = new HashWordList[2*hashTable.length];  
          HashWordNode nodeptr;
          // Runs through the hash table
          for (int i = 0; i < hashTable.length; i++) {
            // Checks to see if this index is null
            if(hashTable[i] != null) {
              // Runs through the list in this index
              for(nodeptr = hashTable[i].getHead(); nodeptr != null; nodeptr = nodeptr.getNext()) {
                SearchCounter.hash(table, nodeptr.getWord(), nodeptr.getOccurrences());
              }
            }
          }
          // Stores the new table
          hashTable = table;
        }
      }
      try {
        FileWriter outputFile = new FileWriter(output_file);
        PrintWriter file = new PrintWriter(outputFile);
        // Writes the contents of the table to a file
        file.write(SearchCounter.printTable(hashTable));
        // Saves and closes the file
        file.close();
      }
      catch(IOException e){
        System.out.println("This file does not exist.");
      }
    }
    // Catches an exception
    catch (FileNotFoundException e) {
      System.out.println("You did not enter a usable file.");
    }
  }
  
  /**
   * This class's main method
   */
  public static void main(String[] args) {
    // Checks to see how many arguments were entered
    if(args.length > 2) {
      System.out.println("You entered too many arguments.");
    }
    // Otherwise, attempts to run wordCount
    else {
      try {
        SearchCounter counter = new SearchCounter();
        counter.wordCount(args[0], args[1]);
      }
      // Shoots an error if there were no arguments entered
      catch (IndexOutOfBoundsException e) {
        System.out.println("You must enter at least two argument.");
      }
    }
  }
}