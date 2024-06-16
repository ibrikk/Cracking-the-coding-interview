public class Quicksort {
  public static void main(String[] args) {
    // int[] arr = { 10, 7, 8, 9, 1, 5 };
    int[] arr = { 9, 7, 1, 12, 15 };
    int n = arr.length;

    System.out.println("Unsorted array:");
    printArray(arr);

    quickSort(arr, 0, n - 1);

    System.out.println("Sorted array:");
    printArray(arr);
  }

  public static void printArray(int[] arr) {
    for (int i : arr) {
      System.out.print(i + " ");
    }
    System.out.println();
  }

  public static void quickSort(int[] arr, int low, int high) {
    if (low < high) {
      int partitionIndex = partition(arr, low, high);

      quickSort(arr, low, partitionIndex - 1);
      quickSort(arr, partitionIndex + 1, high);
    }
  }

  private static int partition(int[] arr, int low, int high) {
    int i = low - 1;
    int pivot = arr[high];

    for (int j = low; j < high; j++) {
      if (arr[j] <= pivot) {
        i++;
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
      }
    }

    int temp = arr[i + 1];
    arr[i + 1] = pivot;
    arr[high] = temp;

    return i + 1;
  }

}
