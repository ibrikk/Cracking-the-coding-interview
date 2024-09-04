public class SortedMerge {
  public static void main(String[] args) {
    int[] a = { 1, 4, 7, 0, 0, 0 };
    int[] b = { 2, 5, 6 };
    merge(a, b, 3, 3);

    for (int num : a) {
      System.out.print(num + " ");
    }
  }

  private static void merge(int[] a, int[] b, int lastA, int lastB) {
    int indexA = lastA - 1; // Index of last element in array A
    int indexB = lastB - 1; // Index of last element in array B
    int indexMerged = lastB + lastA - 1; // end of merged array

    /* Merge a and b, starting from the last element in each */
    while (indexB >= 0) {
      /* end of a is > than end of b */
      if (indexA >= 0 && a[indexA] > b[indexB]) {
        a[indexMerged] = a[indexA]; // copy element
        indexA--;
      } else {
        a[indexMerged] = b[indexB]; // copy element
        indexB--;
      }
      indexMerged--;
    }
  }
}
