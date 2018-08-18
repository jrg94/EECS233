import java.util.*;
import java.io.*;

/**
 * A class that codes a text in variable length binary Strings
 * @author Jeremy Griffith
 */
public class HuffmanEncoder implements HuffmanList {
  
  private CharNode head;
  private int length;
  private CharNode[] nodeRay;
  private int bitCount;
  
  /**
   * The list constructor
   */
  public HuffmanEncoder() {
    length = 0;
    head = null;
    nodeRay = new CharNode[200];
    bitCount = 0;
  }
  
  /**
   * Returns the head of the list
   * @return the head of the list
   */
  public CharNode getHead() {
    return head;
  }
  
  /**
   * Sets the head of the linked list
   * @param head takes a node to be set as the head
   */
  public void setHead(CharNode head) {
    this.head = head;
  }
  
  /**
   * Checks to see if the list is empty
   * @return true if the head of the list is equal to null
   */
  public boolean isEmpty() {
    return (getHead() == null);
  }
  
  /**
   * Returns the code array
   * @return nodeRay
   */
  public CharNode[] getArray() {
    return nodeRay;
  }
  
  /**
   * Returns the length of the linked list (The tope level of the tree)
   * @return the length of the linked list
   */
  public int length() {
    return length;
  }
  
  /**
   * Checks to see if this LinkedList contains this Object
   * @param character takes an Object to be searched for in the list
   * @return true if the LinkedList contains this object
   */
  public boolean contains(char character) {
    CharNode nodeptr = this.getHead();
    // Searches the Linked List for the character
    while(nodeptr != null && nodeptr.getChar() != character) {
      nodeptr = nodeptr.getNext();
    }
    if (nodeptr == null) {
      return false;
    }
    else if (nodeptr.getChar() == character) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /**
   * Add an element to the front of the linked list
   */
  public void addToFront(char element) {
    setHead(new CharNode(getHead(), element));
  }
  
  /**
   * Builds the LinkedList of characters and returns the head
   * @param inputFile takes a file
   * @return the head of the list
   */
  public CharNode assembleList(String inputFile) {
    try {
      Scanner scanner = new Scanner(new FileReader(inputFile));
      // Checks to see if the file has another word
      while(scanner.hasNext()) {
        String word = scanner.next();
        // Runs through the current word to store the occurences of each character
        for(int i = 0; i < word.length(); i++) {
          // Checks to see if the list contains the current character
          if (this.contains(word.charAt(i))) {
            CharNode nodeptr = this.getHead();
            while(nodeptr != null && nodeptr.getChar() != word.charAt(i)) {
              nodeptr = nodeptr.getNext();
            }
            nodeptr.incrementCount();
          }
          // Otherwise, the character is added to the front of the list
          else {
            this.addToFront(word.charAt(i));
            length = length + 1;
          }
        }
      }
    }
    catch (FileNotFoundException e) {
      System.out.println("You did not enter a usable file.");
    }
    // Converts the list to an array
    CharNode[] a = this.toArray();
    // Sorts the array
    Arrays.sort(a);
    // Converts the array back to a list
    head = toList(a);
    return head;
  }
  
  /**
   * Converts an array to a linked list
   */
  public static CharNode toList(CharNode[] ray) {
    HuffmanEncoder a = new HuffmanEncoder();
    a.setHead(ray[0]);
    CharNode nodeptr = a.getHead();
    // Builds a linked list from an array
    for(int i = 1; i < ray.length; i++, nodeptr = nodeptr.getNext()) {
      nodeptr.setNext(ray[i]);
    }
    return a.getHead();
  }
  
  /**
   * Creates an ArrayList of the elements in this list and in the same order
   * @return an ArrayList from this list
   */
  public CharNode[] toArray() {
    CharNode nodeptr = this.getHead();
    CharNode[] a = new CharNode[length];
    int i = 0;
    // Builds an array from a linked list
    while(nodeptr != null) {
      a[i] = nodeptr;
      nodeptr = nodeptr.getNext();
      i++;
    }
    return a;
  }
  
  /**
   * Builds the tree from the linked list
   * @param root the head of a linked list
   * @return the root of the tree
   */
  public CharNode assembleTree(CharNode root) {
    CharNode nodeptr;
    // Runs through the LinkedList until the list only has one node
    while(getHead().getNext() != null) {
      // Creates a temporary node
      CharNode a = new CharNode();
      CharNode b = this.getHead();
      CharNode c = this.getHead().getNext();
      // Sets the left node
      a.setLeft(b);
      // Sets the right node
      a.setRight(c);
      // Sets the new nodes frequency
      a.setFrequency(b.getFrequency() + c.getFrequency());
      // Moves the head pointer to the third node
      this.setHead(getHead().getNext().getNext());
      b.setNext(null);
      c.setNext(null);
      // first case: the new element goes in the front of the list
      if (this.isEmpty() || a.compareTo(this.getHead()) < 0) {
        this.setHead(a);
      }
      // second case, the new element does not go in the front of the list
      else {
        nodeptr = this.getHead();
        // stop when the nodeptr points to the node that the new element goes after
        while (nodeptr.getNext() != null && nodeptr.getNext().compareTo(a) < 0) {
          nodeptr = nodeptr.getNext();
        }
        a.setNext(nodeptr.getNext());
        nodeptr.setNext(a);
      }
    }
    return head;
  }
  
  /**
   * Assigns the Huffman Code to each of the nodes in the tree
   * @param root the root of a Huffman tree
   */
  public void traverse(CharNode root) { 
    // Traverses the left node of the subtree
    if(root.getLeft() != null) {
      // Checks to see if the parent node has a code (not the root of the entire tree)
      if(root.getCode() != null) {
        root.getLeft().setCode(root.getCode() + "0");
      }
      // Otherwise, initialize the left node
      else {
        root.getLeft().setCode("0");
      }
      traverse(root.getLeft());
    }
    // Traverse the right node of the subtree
    if(root.getRight() != null) {
      // Checks to see of the parent node has a code
      if(root.getCode() != null) {
        root.getRight().setCode(root.getCode() + "1");
      }
      // Otherwise, initialize the right node
      else {
        root.getRight().setCode("1");
      }
      traverse(root.getRight());
    }
  }
  
  /**
   * Builds an array from the tree
   * @param root the root of the tree
   */
  public void buildArray(CharNode root) {
    // Checks the root for an empty character
    if(root.getChar() != ' ') {
      int i = 0;
      for(; i < nodeRay.length && nodeRay[i] != null; i++) {
      }
      nodeRay[i] = root;
    }
    // If the root is empty, the method checks left recursively
    if(root.getLeft() != null) {
      buildArray(root.getLeft());
    }
    // And, it checks right recursively
    if(root.getRight() != null) {
      buildArray(root.getRight());
    }
  }
  
  /**
   * Returns the String code associated with this character
   * @param ray an array full of Character nodes
   * @param character takes a char and searches for it
   * @return a String of binary
   */
  public String encode(CharNode[] ray, char character) {
    int i = 0;
    for(; i < ray.length && ray[i].getChar() != character; i++) {
    }
    bitCount = bitCount + ray[i].getCode().length();
    return ray[i].getCode(); 
  }
  
  /**
   * Takes a file and compresses it to a new file
   * @param input_file an input file to be read
   * @param output_file a file to be written to
   */
  public void huffman_coder(String input_file, String output_file) {
    CharNode node = assembleTree(assembleList(input_file));
    int charCount = 0;
    traverse(node);
    buildArray(node);
    try {
      FileWriter outFile = new FileWriter(output_file);
      PrintWriter file = new PrintWriter(outFile);
      Scanner scanner = new Scanner(new FileReader(input_file));
      // Checks to see if the file has another word
      while(scanner.hasNext()) {
        String word = scanner.next();
        // Runs through the current word to write the new file
        for(int i = 0; i < word.length(); i++) {
          charCount++;
          // Writes the binary to the file
          file.write(encode(nodeRay,word.charAt(i)));
        }
      }
      // Saves the file
      file.close();
    }
    catch (FileNotFoundException e) {
      System.out.println("You did not enter a usable file.");
    }
    catch(IOException e) {
    }
    System.out.print("In the orignial text, there were " + charCount + " characters. This converts to around " 
                       + (charCount * 8) + " bits. My Huffman Encoder compressed the text file to " + bitCount + 
                     " bits. That saves nearly " + ((charCount * 8) - bitCount) + " bits.");
  }
}