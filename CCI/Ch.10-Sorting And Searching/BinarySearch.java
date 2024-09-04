public class BinarySearch {
  public static void main(String[] args) {
    int[] arrToSort = { 10, 5, 1, 4, 2, 9 };
    quickSort(arrToSort, 0, arrToSort.length - 1);
    for (int num : arrToSort) {
      System.out.print(num + " ");
    }
    System.out.println();

    int foundIndex = binarySearch(arrToSort, 5); // 3
    System.out.println(foundIndex);

    int foundIndex2 = binarySearchRecursive(arrToSort, 5, 0, arrToSort.length - 1); // 3
    System.out.println(foundIndex2);

  }

  private static void quickSort(int[] arr, int left, int right) {
    int partIndex = partition(arr, left, right);
    if (left < partIndex - 1) {
      quickSort(arr, left, partIndex - 1);
    }
    if (partIndex < right) {
      quickSort(arr, partIndex, right);
    }
  }

  private static int partition(int[] arr, int left, int right) {
    int pivot = arr[(left + right) / 2];
    while (left <= right) {
      while (arr[left] < pivot) {
        left++;
      }
      while (arr[right] > pivot) {
        right--;
      }
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

  private static int binarySearch(int[] arr, int target) {
    int left = 0;
    int right = arr.length - 1;
    while (left <= right) {
      int mid = (left + right) / 2;
      if (arr[mid] > target) {
        right = mid - 1;
      } else if (arr[mid] < target) {
        left = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }

  private static int binarySearchRecursive(int[] arr, int target, int left, int right) {
    if (left > right) {
      return -1;
    }
    int mid = (left + right) / 2;
    if (arr[mid] > target) {
      return binarySearchRecursive(arr, target, left, mid - 1);
    } else if (arr[mid] < target) {
      return binarySearchRecursive(arr, target, mid + 1, right);
    } else {
      return mid;
    }
  }

}