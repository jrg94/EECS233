import java.io.*;
import java.util.*;
/**
 * A class that sorts an array three different ways
 * @author Jeremy Griffith
 */
public class SortTest2 {
  
  /**
   * Returns the time that it takes to sort a list
   * @return the time that it takes to sort a list
   */
  private static long timer(int[] list, String sort) {
    long start = 0;
    long end = 0;
    // If the input string is ms, run mergesort
    if(sort.equals("ms")) {
      start = System.currentTimeMillis();
      Sort.mergeSort(list);
      end = System.currentTimeMillis();
    }
    // If the input String is qs, run quicksort
    else if(sort.equals("qs")) {
      start = System.currentTimeMillis();
      Sort.quickSort(list);
      end = System.currentTimeMillis();
    }
    // If the input String is hs, run heapsort
    else if(sort.equals("hs")) {
      start = System.currentTimeMillis();
      Sort.heapSort(list);
      end = System.currentTimeMillis();
    } 
    // If none of the strings match, print this message
    else {
      System.out.println("Incorrect String Input");
    }
    return (end-start);
  }
  
  /**
   * Takes a file and an array and prints it into the file
   */
  public static void writeToFile(PrintWriter file, int[] toPrint) {
    for(int i = 0; i < toPrint.length; i++) {
      file.println(toPrint[i]);
    }
    file.close();
  }
  
  /**
   * Reads a file and the tests three sorting algorithms on it
   */
  public static void main(String[] args) {
    int[] toSort = new int[10];
    try {
      PrintWriter fileHS = new PrintWriter(new FileWriter("jrg170HS.txt"));
      PrintWriter fileQS = new PrintWriter(new FileWriter("jrg170QS.txt"));
      PrintWriter fileMS = new PrintWriter(new FileWriter("jrg170MS.txt"));
      Scanner scanner = new Scanner(new FileReader(args[0]));
      // Builds the array as long as there are tokens in the file
      int i;
      for(i = 0; scanner.hasNext(); i++) {
        // As long as i does not overcome the last index of the array, an int is added to the array
        if(i < toSort.length) {
          toSort[i] = Integer.parseInt(scanner.next());
        }
        // Otherwise, the array needs to be expanded
        else {
          int[] temp = new int[toSort.length * 10];
          for(int j = 0; j < toSort.length; j++) {
            temp[j] = toSort[j];
          }
        i = i - 1;
        toSort = temp;
        }
      }
      // Creates a new array to the correct size to eliminate the zeros
      int[] temp = new int[i];
      // Builds the final array to be sorted
      for(int j = 0; j < i; j++) {
        temp[j] = toSort[j];
      }
      toSort = temp;
      // Test results for the heapsort
      System.out.println("HSjrg170 " + timer(temp, "hs"));
      writeToFile(fileHS, temp);
      // Test results for the quicksort
      temp = toSort;
      System.out.println("QSjrg170 " + timer(temp, "qs"));
      writeToFile(fileQS, temp);
      // Test results for the mergesort
      temp = toSort;
      System.out.println("MSjrg170 " + timer(temp, "ms"));
      writeToFile(fileMS, temp);
    }
    catch(ArrayIndexOutOfBoundsException e) {
      System.out.println("You must enter one file name, or I did a poor job with my loops and index i.");
    }
    catch(FileNotFoundException e) {
      System.out.println("You did not enter a usable file.");
    }
    catch(IOException e) {
      System.out.println("Try another file.");
    }
  }
}