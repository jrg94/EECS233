import java.util.*;

/**
 * A class that tests the three sorting methods
 * @author Jeremy Griffith
 */
public class SortTest1 {
  
  /**
   * Reports data related to heapSort
   */
  public static void heapSortTest() {
    long[] test = new long[3];
    long[] test2 = new long[10];
    int[] toSort;
    long sSortTime, mSortTime, lSortTime, eSortTime;
    long sRevTime, mRevTime, lRevTime, eRevTime;
    long sRandTime, mRandTime, lRandTime, eRandTime;
    double sVariance, mVariance, lVariance, eVariance;
    // Creates a small sorted list and records the sorting time
    toSort = SortTest1.smallSorted();
    test = arrayHS(toSort);
    Arrays.sort(test);
    sSortTime = test[1];
    // Creates a medium sorted list and records the sorting time
    toSort = SortTest1.mediumSorted();
    test = arrayHS(toSort);
    Arrays.sort(test);
    mSortTime = test[1];
    // Creates a large sorted list and records the sorting time
    toSort = SortTest1.largeSorted();
    test = arrayHS(toSort);
    Arrays.sort(test);
    lSortTime = test[1];
    // Creates an extra large sorted list and records the sorting time
    toSort = SortTest1.extraLargeSorted();
    test = arrayHS(toSort);
    Arrays.sort(test);
    eSortTime = test[1];
    // Creates a small reverse sorted list and records the sorting time
    toSort = SortTest1.smallReverse();
    test = arrayHS(toSort);
    Arrays.sort(test);
    sRevTime = test[1];
    // Creates a medium reverse sorted list and records the sorting time
    toSort = SortTest1.mediumReverse();
    test = arrayHS(toSort);
    Arrays.sort(test);
    mRevTime = test[1];
    // Creates a large reverse sorted list and records the sorting time
    toSort = SortTest1.largeReverse();
    test = arrayHS(toSort);
    Arrays.sort(test);
    lRevTime = test[1];
    // Creates an extra large reverse sorted list and records the sorting time
    toSort = SortTest1.extraLargeReverse();
    test = arrayHS(toSort);
    Arrays.sort(test);
    eRevTime = test[1];
    // Creates a small random list and records the sorting time
    toSort = SortTest1.smallRand();
    test2 = arrayRandHS(toSort, "small");
    sRandTime = meanVal(test2);
    sVariance = varianceVal(test2, sRandTime);
    // Creates a medium random list and records the sorting time
    toSort = SortTest1.mediumRand();
    test2 = arrayRandHS(toSort, "medium");
    mRandTime = meanVal(test2);
    mVariance = varianceVal(test2, mRandTime);
    // Creates a large random list and records the sorting time
    toSort = SortTest1.largeRand();
    test2 = arrayRandHS(toSort, "large");
    lRandTime = meanVal(test2);
    lVariance = varianceVal(test2, lRandTime);
    // Creates an extra large random list and records the sorting time
    toSort = SortTest1.extraLargeRand();
    test2 = arrayRandHS(toSort, "extra large");
    eRandTime = meanVal(test2);
    eVariance = varianceVal(test2, eRandTime);
    System.out.print("[Sorted Small] " + sSortTime + " ms \n[Sorted Medium] " + mSortTime + 
                     " ms \n[Sorted Large] " + lSortTime + " ms \n[Sorted Extra Large] " + eSortTime + " ms");
    System.out.print("\n[Reverse Small] " + sRevTime + " ms \n[Reverse Medium] " + mRevTime + " ms \n[Reverse Large] " 
                       + lRevTime + " ms \n[Reverse Extra Large] " + eRevTime + " ms");
    System.out.print("\n[Random Small] " + sRandTime + " ms and has a variance of " + sVariance + 
                     "\n[Random Medium] " + mRandTime + " ms and has a variance of " + mVariance + 
                     "\n[Random Large] " + lRandTime + " ms and and has a variance of " + lVariance + 
                     "\n[Random Extra Large] " + eRandTime + " ms and has a variance of " + eVariance);
  }
  
  /**
   * Reports data related to quickSort
   */
  public static void quickSortTest() {
    long[] test = new long[3];
    long[] test2 = new long[10];
    int[] toSort;
    long sSortTime, mSortTime, lSortTime, eSortTime;
    long sRevTime, mRevTime, lRevTime, eRevTime;
    long sRandTime, mRandTime, lRandTime, eRandTime;
    double sVariance, mVariance, lVariance, eVariance;
    // Creates a small sorted list and records the sorting time
    toSort = SortTest1.smallSorted();
    test = arrayQS(toSort);
    Arrays.sort(test);
    sSortTime = test[1];
    // Creates a medium sorted list and records the sorting time
    toSort = SortTest1.mediumSorted();
    test = arrayQS(toSort);
    Arrays.sort(test);
    mSortTime = test[1];
    // Creates a large sorted list and records the sorting time
    toSort = SortTest1.largeSorted();
    test = arrayQS(toSort);
    Arrays.sort(test);
    lSortTime = test[1];
    // Creates an extra large sorted list and records the sorting time
    toSort = SortTest1.extraLargeSorted();
    test = arrayQS(toSort);
    Arrays.sort(test);
    eSortTime = test[1];
    // Creates a small reverse sorted list and records the sorting time
    toSort = SortTest1.smallReverse();
    test = arrayQS(toSort);
    Arrays.sort(test);
    sRevTime = test[1];
    // Creates a medium reverse sorted list and records the sorting time
    toSort = SortTest1.mediumReverse();
    test = arrayQS(toSort);
    Arrays.sort(test);
    mRevTime = test[1];
    // Creates a large reverse sorted list and records the sorting time
    toSort = SortTest1.largeReverse();
    test = arrayQS(toSort);
    Arrays.sort(test);
    lRevTime = test[1];
    // Creates an extra large reverse sorted list and records the sorting time
    toSort = SortTest1.extraLargeReverse();
    test = arrayQS(toSort);
    Arrays.sort(test);
    eRevTime = test[1];
    // Creates a small random list and records the sorting time
    toSort = SortTest1.smallRand();
    test2 = arrayRandQS(toSort, "small");
    sRandTime = meanVal(test2);
    sVariance = varianceVal(test2, sRandTime);
    // Creates a medium random list and records the sorting time
    toSort = SortTest1.mediumRand();
    test2 = arrayRandQS(toSort, "medium");
    mRandTime = meanVal(test2);
    mVariance = varianceVal(test2, mRandTime);
    // Creates a large random list and records the sorting time
    toSort = SortTest1.largeRand();
    test2 = arrayRandQS(toSort, "large");
    lRandTime = meanVal(test2);
    lVariance = varianceVal(test2, lRandTime);
    // Creates an extra large random list and records the sorting time
    toSort = SortTest1.extraLargeRand();
    test2 = arrayRandQS(toSort, "extra large");
    eRandTime = meanVal(test2);
    eVariance = varianceVal(test2, eRandTime);
    System.out.print("[Sorted Small] " + sSortTime + " ms \n[Sorted Medium] " + mSortTime + 
                     " ms \n[Sorted Large] " + lSortTime + " ms \n[Sorted Extra Large] " + eSortTime + " ms");
    System.out.print("\n[Reverse Small] " + sRevTime + " ms \n[Reverse Medium] " + mRevTime + " ms \n[Reverse Large] " 
                       + lRevTime + " ms \n[Reverse Extra Large] " + eRevTime + " ms");
    System.out.print("\n[Random Small] " + sRandTime + " ms and has a variance of " + sVariance + 
                     "\n[Random Medium] " + mRandTime + " ms and has a variance of " + mVariance + 
                     "\n[Random Large] " + lRandTime + " ms and and has a variance of " + lVariance + 
                     "\n[Random Extra Large] " + eRandTime + " ms and has a variance of " + eVariance);
  }
  
  /**
   * Reports data related to mergeSort
   */
  public static void mergeSortTest() {
    long[] test = new long[3];
    long[] test2 = new long[10];
    int[] toSort;
    long sSortTime, mSortTime, lSortTime, eSortTime;
    long sRevTime, mRevTime, lRevTime, eRevTime;
    long sRandTime, mRandTime, lRandTime, eRandTime;
    double sVariance, mVariance, lVariance, eVariance;
    // Creates a small sorted list and records the sorting time
    toSort = SortTest1.smallSorted();
    test = arrayMS(toSort);
    Arrays.sort(test);
    sSortTime = test[1];
    // Creates a medium sorted list and records the sorting time
    toSort = SortTest1.mediumSorted();
    test = arrayMS(toSort);
    Arrays.sort(test);
    mSortTime = test[1];
    // Creates a large sorted list and records the sorting time
    toSort = SortTest1.largeSorted();
    test = arrayMS(toSort);
    Arrays.sort(test);
    lSortTime = test[1];
    // Creates an extra large sorted list and records the sorting time
    toSort = SortTest1.extraLargeSorted();
    test = arrayMS(toSort);
    Arrays.sort(test);
    eSortTime = test[1];
    // Creates a small reverse sorted list and records the sorting time
    toSort = SortTest1.smallReverse();
    test = arrayMS(toSort);
    Arrays.sort(test);
    sRevTime = test[1];
    // Creates a medium reverse sorted list and records the sorting time
    toSort = SortTest1.mediumReverse();
    test = arrayMS(toSort);
    Arrays.sort(test);
    mRevTime = test[1];
    // Creates a large reverse sorted list and records the sorting time
    toSort = SortTest1.largeReverse();
    test = arrayMS(toSort);
    Arrays.sort(test);
    lRevTime = test[1];
    // Creates an extra large reverse sorted list and records the sorting time
    toSort = SortTest1.extraLargeReverse();
    test = arrayMS(toSort);
    Arrays.sort(test);
    eRevTime = test[1];
    // Creates a small random list and records the sorting time
    toSort = SortTest1.smallRand();
    test2 = arrayRandMS(toSort, "small");
    sRandTime = meanVal(test2);
    sVariance = varianceVal(test2, sRandTime);
    // Creates a medium random list and records the sorting time
    toSort = SortTest1.mediumRand();
    test2 = arrayRandMS(toSort, "medium");
    mRandTime = meanVal(test2);
    mVariance = varianceVal(test2, mRandTime);
    // Creates a large random list and records the sorting time
    toSort = SortTest1.largeRand();
    test2 = arrayRandMS(toSort, "large");
    lRandTime = meanVal(test2);
    lVariance = varianceVal(test2, lRandTime);
    // Creates an extra large random list and records the sorting time
    toSort = SortTest1.extraLargeRand();
    test2 = arrayRandMS(toSort, "extra large");
    eRandTime = meanVal(test2);
    eVariance = varianceVal(test2, eRandTime);
    System.out.print("[Sorted Small] " + sSortTime + " ms \n[Sorted Medium] " + mSortTime + 
                     " ms \n[Sorted Large] " + lSortTime + " ms \n[Sorted Extra Large] " + eSortTime + " ms");
    System.out.print("\n[Reverse Small] " + sRevTime + " ms \n[Reverse Medium] " + mRevTime + " ms \n[Reverse Large] " 
                       + lRevTime + " ms \n[Reverse Extra Large] " + eRevTime + " ms");
    System.out.print("\n[Random Small] " + sRandTime + " ms and has a variance of " + sVariance + 
                     "\n[Random Medium] " + mRandTime + " ms and has a variance of " + mVariance + 
                     "\n[Random Large] " + lRandTime + " ms and and has a variance of " + lVariance + 
                     "\n[Random Extra Large] " + eRandTime + " ms and has a variance of " + eVariance);
  }
  
  /**
   * Creates a sorted array of size 1000
   * @return an array of size 1000 of sorted integers
   */
  private static int[] smallSorted() {
    int[] small = new int[1000];
    // Builds the array
    for(int i = 0; i < 1000; i++) {
      small[i] = i;
    }
    return small;
  }
  
  /**
   * Creates a sorted array of size 10000
   * @return an array of size 10000 of sorted integers
   */
  private static int[] mediumSorted() {
    int[] medium = new int[10000];
    // Builds the array
    for(int i = 0; i < 10000; i++) {
      medium[i] = i;
    }
    return medium;
  }
  
  /**
   * Creates a sorted array of size 100000
   * @return an array of size 100000 of sorted integers
   */
  private static int[] largeSorted() {
    int[] large = new int[100000];
    // Builds the array
    for(int i = 0; i < 100000; i++) {
      large[i] = i;
    }
    return large;
  }
  
  /**
   * Creates a sorted array of size 1000000
   * @return an array of size 1000000 of sorted integers
   */
  private static int[] extraLargeSorted() {
    int[] extraLarge = new int[1000000];
    // Builds the array
    for(int i = 0; i < 1000000; i++) {
      extraLarge[i] = i;
    }
    return extraLarge;
  }
  
  /**
   * Creates a reverse sorted array of size 1000
   * @return an array of size 1000 of reverse sorted integers
   */
  private static int[] smallReverse() {
    int[] small = new int[1000];
    // Builds the array
    for(int i = 0; i < 1000; i++) {
      small[i] = 999 - i;
    }
    return small;
  }
  
  /**
   * Creates a reverse sorted array of size 10000
   * @return an array of size 10000 of reverse sorted integers
   */
  private static int[] mediumReverse() {
    int[] medium = new int[10000];
    // Builds the array
    for(int i = 0; i < 10000; i++) {
      medium[i] = 9999 - i;
    }
    return medium;
  }
  
  /**
   * Creates a reverse sorted array of size 100000
   * @return an array of size 100000 of reverse sorted integers
   */
  private static int[] largeReverse() {
    int[] large = new int[100000];
    // Builds the array
    for(int i = 0; i < 100000; i++) {
      large[i] = 99999 - i;
    }
    return large;
  }
  
  /**
   * Creates a reverse sorted array of size 1000000
   * @return an array of size 1000000 of reverse sorted integers
   */
  private static int[] extraLargeReverse() {
    int[] extraLarge = new int[1000000];
    // Builds the array
    for(int i = 0; i < 1000000; i++) {
      extraLarge[i] = 999999 - i;
    }
    return extraLarge;
  }
  
  /**
   * Creates a random array of size 1000
   * @return an array of size 1000 of random integers
   */
  private static int[] smallRand() {
    int[] small = new int[1000];
    // Builds the array
    for(int i = 0; i < 1000; i++) {
      small[i] = (int)(Math.random() * 1000);
    }
    return small;
  }
  
  /**
   * Creates a random array of size 10000
   * @return an array of 10000 of random integers
   */
  private static int[] mediumRand() {
    int[] medium = new int[10000];
    // Builds the array
    for(int i = 0; i < 10000; i++) {
      medium[i] = (int)(Math.random() * 10000);
    }
    return medium;
  }
  
  /**
   * Creates a random array of size 100000
   * @return an array of size 100000 of random integers
   */
  private static int[] largeRand() {
    int[] large = new int[100000];
    // Builds the array
    for(int i = 0; i < 100000; i++) {
      large[i] = (int)(Math.random() * 100000);
    }
    return large;
  }
  
  /**
   * Creates a random array of size 1000000
   * @return an array of size 1000000 of random integers
   */
  private static int[] extraLargeRand() {
    int[] extraLarge = new int[1000000];
    // Builds the array
    for(int i = 0; i < 1000000; i++) {
      extraLarge[i] = (int)(Math.random() * 1000000);
    }
    return extraLarge;
  }
  
  /**
   * Returns the mean of the array
   * @return the mean value of an array
   */
  private static long meanVal(long[] arrOfSamples) {
    long sum = 0;
    for(int i = 0; i < arrOfSamples.length; i++) {
      sum = sum + arrOfSamples[i];
    }
    return sum/arrOfSamples.length;
  }
  
  /**
   * Returns the variance of the samples
   * @return the variance of the mean value of an array
   */
  private static double varianceVal(long[] arrOfSamples, long mean) {
    double sum = 0;
    for(int i = 0; i < arrOfSamples.length; i++) {
      sum = sum + Math.pow((arrOfSamples[i] - mean), 2);
    }
    return sum/(arrOfSamples.length - 1);
  }
  
  /**
   * Returns the time list that it takes to heapsort an array
   * @return the list of times
   */
  private static long[] arrayHS(int[] list) {
    long[] nums = new long[3];
    for (int i = 0; i < 3; i++) {
      int temp[] = list;
      long start = System.currentTimeMillis();
      Sort.heapSort(temp);
      long end = System.currentTimeMillis();
      nums[i] = (end - start);
    }
    return nums;
  }
  
  /**
   * Returns the time list that it takes to heapsort an array
   * @returns the list of times
   */
  private static long[] arrayQS(int[] list) {
    long[] nums = new long[3];
    for (int i = 0; i < 3; i++) {
      int temp[] = list;
      long start = System.currentTimeMillis();
      Sort.quickSort(temp);
      long end = System.currentTimeMillis();
      nums[i] = (end - start);
    }
    return nums;
  }
  
  /**
   * Returns the time list that it takes to heapsort an array
   * @return the list of times
   */
  private static long[] arrayMS(int[] list) {
    long[] nums = new long[3];
    for (int i = 0; i < 3; i++) {
      int temp[] = list;
      long start = System.currentTimeMillis();
      Sort.quickSort(temp);
      long end = System.currentTimeMillis();
      nums[i] = (end - start);
    }
    return nums;
  }
  
  /**
   * Returns the time that it takes to heapsort an array
   * @return the time it takes to heapsort an array
   */
  private static long randHS(String size) {
    int temp[] = new int[10];
    if(size.equals("small")) {
      temp = smallRand();
    }
    else if (size.equals("medium")) {
      temp = mediumRand();
    }
    else if (size.equals("large")) {
      temp = largeRand();
    }
    else if (size.equals("extra large")) {
      temp = extraLargeRand();
    }
    long start = System.currentTimeMillis();
    Sort.heapSort(temp);
    long end = System.currentTimeMillis();
    return (end - start);
  }
  
  /**
   * Returns the time that it takes to quicksort an array
   * @return the time it takes to quicksort an array
   */
  private static long randQS(String size) {
    int temp[] = new int[10];
    if(size.equals("small")) {
      temp = smallRand();
    }
    else if (size.equals("medium")) {
      temp = mediumRand();
    }
    else if (size.equals("large")) {
      temp = largeRand();
    }
    else if (size.equals("extra large")) {
      temp = extraLargeRand();
    }
    long start = System.currentTimeMillis();
    Sort.quickSort(temp);
    long end = System.currentTimeMillis();
    return (end - start);
  }
  
  /**
   * Returns the time that it takes to quicksort an array
   * @return the time it takes to mergesort an array
   */
  private static long randMS(String size) {
    int temp[] = new int[10];
    if(size.equals("small")) {
      temp = smallRand();
    }
    else if (size.equals("medium")) {
      temp = mediumRand();
    }
    else if (size.equals("large")) {
      temp = largeRand();
    }
    else if (size.equals("extra large")) {
      temp = extraLargeRand();
    }
    long start = System.currentTimeMillis();
    Sort.mergeSort(temp);
    long end = System.currentTimeMillis();
    return (end - start);
  }
  
  /**
   * Returns the array of times to sort an array with heapsort
   * @return the list of times
   */
  private static long[] arrayRandHS(int[] list, String size) {
    long[] times = new long[10];
    for(int i = 0; i < 10; i++) {
      long time = randHS(size);
      times[i] = time;
    }
    return times;
  }
  
  /**
   * Returns the array of times to sort an array with quicksort
   * @return the list of times
   */
  private static long[] arrayRandQS(int[] list, String size) {
    long[] times = new long[10];
    for(int i = 0; i < 10; i++) {
      long time = randQS(size);
      times[i] = time;
    }
    return times;
  }
  
   /**
   * Returns the array of times to sort an array with quicksort
   * @return the list of times
   */
  private static long[] arrayRandMS(int[] list, String size) {
    long[] times = new long[10];
    for(int i = 0; i < 10; i++) {
      long time = randMS(size);
      times[i] = time;
    }
    return times;
  }
  
  /**
   * Runs the study
   */
  public static void main(String[] args) {
    System.out.println("Heapsort Test:");
    SortTest1.heapSortTest();
    System.out.println("\nQuicksort Test:");
    SortTest1.quickSortTest();
    System.out.println("\nMergesort Test:");
    SortTest1.mergeSortTest();
  }
  
}