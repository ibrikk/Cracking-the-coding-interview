public class BinarySearch {
  public static void main(String[] args) {
    int[] arr = { 9, 3, 5, 2, 7 };
    quickSort(arr, 0, arr.length - 1);
    for (int num : arr) {
      System.out.print(num);
    }
    System.out.println();
    int index = binSearch(arr, 7);
    System.out.println(index);

    int index2 = binSearchRecursively(arr, 7, 0, arr.length - 1);
    System.out.println(index2);
  }

  private static int binSearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;

    while (left <= right) {
      int mid = (left + right) / 2;
      if (arr[mid] == target) {
        return mid;
      } else if (arr[mid] < target) {
        left = mid + 1;
      } else {
        right = mid - 1;
      }
    }
    return -1;
  }

  private static int binSearchRecursively(int[] arr, int target, int left, int right) {
    if (left > right) {
      return -1;
    }
    int mid = (left + right) / 2;
    if (arr[mid] > target) {
      return binSearchRecursively(arr, target, left, mid - 1);
    } else if (arr[mid] < target) {
      return binSearchRecursively(arr, target, mid + 1, right);
    } else {
      return mid;
    }
  }

  private static void quickSort(int[] arr, int left, int right) {
    int pIdx = partition(arr, left, right);
    if (left < pIdx - 1) {
      quickSort(arr, left, pIdx - 1);
    }
    if (pIdx < right) {
      quickSort(arr, pIdx, right);
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
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

        left++;
        right--;
      }
    }
    return left;
  }
}
