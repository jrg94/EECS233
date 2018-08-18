import java.util.*;

public class Sort {
  
  /**
   * Sorts the array as a heap
   * @param ray the input array
   */
  public static void heapSort(int[] ray) {
    // Turn the array into a max-at-top heap.
    buildHeap(ray);
    int endUnsorted = ray.length - 1;
    // Loops until endUnsorted exits the left end of the array
    while (endUnsorted > 0) {
      // Get the largest remaining item and put it to the end
      int largestRemaining = removeMax(ray, endUnsorted);
      ray[endUnsorted] = largestRemaining;
      endUnsorted--;
    }
  }
  
  /**
   * Sorts an array; Divide and Conquer with a pivot
   * @param ray the input array
   */
  public static void quickSort(int[] ray) {
    myQuickSort(ray, 0, ray.length - 1);
  }
  
  /**
   * Sorts an array; Divide and Conquer with auxillary space
   * @param ray the input array
   */
  public static void mergeSort(int[] ray) {
    int[] aux1 = ray;
    int[] aux2 = new int[ray.length];
    // As long as i is less than the length of the array, i is doubled
    for (int i=1; i < ray.length; i = i * 2) {
      // As long as the start index is less than the length of the array, start increments by twice i
      for (int start = 0; start < ray.length; start = start + (2 * i))
        merge(aux1, aux2, start, start + i, start + (2 * i));
      int[] temp = aux1;
      aux1 = aux2;
      aux2 = temp;
    }
    if (ray != aux1)
      // Copies aux1 into the original array
      for (int k = 0; k < ray.length; k++)
      ray[k] = aux1[k];
  }
  
  /**
   * Removes the max from the array
   */
  private static int removeMax(int[] ray, int end) {
    int toRemove = ray[0];
    ray[0] = ray[end];
    siftDown(ray, 0, end);
    return toRemove;
  }
  
  private static void siftDown(int[] ray, int index, int end) {
    // Item to be sifted
    int toSift = ray[index];
    // Index of the parent
    int parent = index;
    // Index of the left child
    int child = 2 * parent + 1;
    // While the index of the left child is less than the length of the array
    while (child < end) {
      // If the right child is bigger than the left one, use the right child for comparison.
      if (child +1 < end  && // if the right child exists
          ray[child] < ray[child + 1] )  // … and is bigger than the left child
        child = child + 1; // take the right child
      if (toSift >= ray[child])
        break; // we’re done
      // Sift down one level in the tree.
      ray[parent] = ray[child];
      ray[child] = toSift;
      parent = child;
      child = 2 * parent + 1;
    }
    ray[parent] = toSift;
  }
  
  /**
   * Forms a heap out of an array
   * @param array the input array
   */
  private static void buildHeap(int[] array) {
    // Builds the heap using the sift down method on every parent node
    for(int i = (array.length - 2)/2; i >= 0; i--) {
      siftDown(array, i, array.length - 1);
    }
  }

  /**
   * Arranges an array so all elements to the left of the pivot are less then the pivot and returns the split
   * @param arr the input array
   * @param first the index of the leftmost element from the subarray
   * @param last the index of the rightmost element from the subarray
   * @return the index of the pivot element
   */
  private static int partition(int[] arr, int first, int last) {
    int pivot = arr[(first + last)/2];
    // index going left to right
    int i = first - 1;
    // index going right to left
    int j = last + 1; 
    while (true) {
      // Increment i while the element at i is less than the pivot value
      do {
        i++;
      } while (arr[i] < pivot);
      // Increment j while the element at j is greater than the pivot value
      do {
        j--;
      } while (arr[j] > pivot);
      // Swap the elements if i is less than j
      if (i < j) {
        swap(arr, i, j);
      }
      // Otherwise, return the end of the left array
      else {
        // arr[j] = end of left array
        return j;  
      }
    }
  }
  
  /**
   * A recursive method that sorts the array
   * @param arr the input array
   * @param first the index of the leftmost element
   * @param last the index of the rightmost element
   */
  private static void myQuickSort(int[] arr, int first, int last) {
    // If the first index is greater than the last index then return
    if(first >= last) {
      return;
    }
    int split = partition(arr, first, last);
    // If first is less than the split, run myQuickSort
    if (first < split) {
      myQuickSort(arr, first, split);
    }
    // If split+1 is less than last, run myQuickSort
    if (split + 1 < last) {
      myQuickSort(arr, split + 1, last);
    }
  }
  
  /**
   * Swaps the two elements in an array
   * @param ray an array
   * @param first the left element
   * @param last the right element
   */
  private static void swap(int[] ray, int first, int last) {
    int left = ray[first];
    ray[first] = ray[last];
    ray[last] = left;
  }
  
  /**
   * Performs the merge
   * @param ray an input array
   * @param arr an auxillary array
   * @param start the furthest left index
   * @param middle the middle index
   * @param end the rightmost index
   */
  public static void merge(int[] ray, int[] arr, int start, int middle, int end) {
    // Checks to see if the middle marker is higher than the end of the list
    if (middle > ray.length) {
      middle = ray.length;
    }
    // Checks to see if the end marker extends passed the length of the array
    if (end > ray.length) {
      end = ray.length;
    }
    int i = start;
    int j = middle;
    // While k is less than the end, begin sorting
    for (int k = start; k < end; k++) {
      // If i marks the middle element, insert it in the array
      if (i == middle) {
        arr[k] = ray[j++];
      }
      // If index j matches index end, insert element i++ in index k
      else if (j == end) {
        arr[k] = ray[i++];
      }
      // If the element at j is less than the element at i, place element i in j
      else if (ray[j] < ray[i]) {
        arr[k] = ray[j++];
      }
      // Otherwise, insert element at i + 1 into k
      else {
        arr[k] = ray[i++];
      }
    }
  }
}