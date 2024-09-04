public class QuicksortMain {
  public static void main(String[] args) {
    int[] arr = { 10, 5, 1, 3, 2 };
    quickSort(arr, 0, arr.length - 1);
    for (int num : arr) {
      System.out.print(num + " ");
    }
  }

  private static void quickSort(int[] arr, int left, int right) {
    int partIndex = partition(arr, left, right);
    if (left < partIndex - 1) {
      quickSort(arr, left, partIndex - 1);
    }
    if (right > partIndex) {
      quickSort(arr, partIndex, right);
    }
  }

  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[(left + right) / 2];
    while (left <= right) {
      while (arr[left] < pivot)
        left++;
      while (arr[right] > pivot)
        right--;
      if (left <= right) {
        swap(arr, left, right);
        left++;
        right--;
      }
    }
    return left;
  }

  private static void swap(int[] arr, int left, int right) {
    int temp = arr[left];
    arr[left] = arr[right];
    arr[right] = temp;
  }
}