import java.util.*;

public class PeaksAndValleys {
  public static void main(String[] args) {
    int[] arr = { 5, 8, 6, 2, 3, 4, 6 };

    sortValleyPeak(arr);
    for (int num : arr) {
      System.out.print(num);
    }
    System.out.println();

    int[] array = { 5, 8, 6, 2, 3, 4, 6 };

    sortValleyPeakOpt(array);
    for (int num : array) {
      System.out.print(num);
    }
  }

  private static void sortValleyPeak(int[] arr) {
    Arrays.sort(arr);
    for (int i = 1; i < arr.length; i += 2) {
      swap(arr, i - 1, i);
    }
  }

  private static void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }

  /* Optimal solution */
  private static void sortValleyPeakOpt(int[] arr) {
    for (int i = 1; i < arr.length; i += 2) {
      int biggestIndex = maxIndex(arr, i - 1, i, i + 1);
      if (i != biggestIndex) {
        swap(arr, i, biggestIndex);
      }
    }
  }

  private static int maxIndex(int[] arr, int prev, int curr, int following) {
    int len = arr.length;
    int prevValue = prev >= 0 && prev < len ? arr[prev] : Integer.MIN_VALUE;
    int currValue = curr >= 0 && curr < len ? arr[curr] : Integer.MIN_VALUE;
    int followingValue = following >= 0 && following < len ? arr[following] : Integer.MIN_VALUE;

    int max = Math.max(prevValue, Math.max(currValue, followingValue));
    if (prevValue == max)
      return prev;
    else if (currValue == max)
      return curr;
    else
      return following;
  }
}
