public class MinimalTree {
  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 6 };
    TreeNode result = createMinimalBST(arr);
    result.toString(result);

  }

  private static TreeNode createMinimalBST(int[] array) {
    return createMinimalBST(array, 0, array.length - 1);
  }

  private static TreeNode createMinimalBST(int[] arr, int start, int end) {
    if (end < start)
      return null;
    int mid = (start + end) / 2;
    TreeNode n = new TreeNode(arr[mid]);
    n.left = createMinimalBST(arr, start, mid - 1);
    n.right = createMinimalBST(arr, mid + 1, end);
    return n;
  }
}

class TreeNode {
  public int val;
  public TreeNode left;
  public TreeNode right;

  public TreeNode(int val) {
    this.val = val;
  }

  public void toString(TreeNode result) {
    if (result != null) {
      System.out.println(result.val);
      toString(result.left);
      toString(result.right);
    }
  }

}
