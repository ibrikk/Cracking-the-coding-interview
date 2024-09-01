import java.util.*;

class Listy {
  private List<Integer> list;

  // Constructor to initialize Listy with a list of integers
  public Listy(List<Integer> list) {
    this.list = list;
  }

  // Method to return element at a specific index
  public int elementAt(int index) {
    if (index < 0 || index >= list.size()) {
      return -1; // Return -1 if the index is out of bounds
    }
    return list.get(index);
  }
}

public class SortedSearchNoSize {
  public static void main(String[] args) {
    // Create a Listy object with a sorted list of positive integers
    List<Integer> data = Arrays.asList(1, 3, 5, 7, 9, 10, 14, 18, 21);
    Listy listy = new Listy(data);

    int target = 10; // Element to search for
    int result = search(listy, target);

    if (result != -1) {
      System.out.println("Element " + target + " found at index: " + result);
    } else {
      System.out.println("Element " + target + " not found in the list.");
    }
  }

  private static int search(Listy list, int value) {
    int index = 1;
    // Exponentially increase the index until you go beyond the target value or
    // reach -1
    while (list.elementAt(index) != -1 && list.elementAt(index) < value) {
      index *= 2;
    }
    // Perform binary search in the determined range
    return binarySearch(list, value, index / 2, index);
  }

  private static int binarySearch(Listy list, int value, int low, int high) {
    while (low <= high) {
      int mid = (low + high) / 2;
      int middle = list.elementAt(mid);

      if (middle == -1 || middle > value) { // If out of bounds or middle is greater
        high = mid - 1;
      } else if (middle < value) {
        low = mid + 1;
      } else {
        return mid; // Value found
      }
    }
    return -1; // Value not found
  }
}
