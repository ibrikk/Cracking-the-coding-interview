public class MagicIndex {
  public static void main(String[] args) {
    int[] array = { -10, -5, 0, 3, 7, 9 }; // Example array
    int magicIndex = findMagicIndex(array);
    if (magicIndex != -1) {
      System.out.println("Magic index found at: " + magicIndex);
    } else {
      System.out.println("No magic index found.");
    }
  }

  private static int findMagicIndex(int[] arr) {
    return findMagicIndex(arr, 0, arr.length - 1);
  }

  private static int findMagicIndex(int[] arr, int start, int end) {
    if (start > end) {
      return -1;
    }

    int mid = (start + end) / 2;

    if (arr[mid] == mid) {
      return mid;
    } else if (arr[mid] > mid) {
      return findMagicIndex(arr, start, mid - 1);
    } else {
      return findMagicIndex(arr, mid + 1, end);
    }
  }
}
