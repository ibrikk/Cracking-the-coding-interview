import java.util.*;

public class ListOfDepths {
  public static void main(String[] args) {
    TreeNode node = new TreeNode(1);
    node.left = new TreeNode(2);
    node.right = new TreeNode(3);
    node.right.right = new TreeNode(6);
    node.left.left = new TreeNode(4);
    node.left.right = new TreeNode(5);
    ArrayList<LinkedList<TreeNode>> result = createLevelLinkedList(node);
    System.out.println(result);
  }

  private static void createLevelLinkedList(TreeNode root, ArrayList<LinkedList<TreeNode>> lists, int level) {
    if (root == null)
      return; // base case

    LinkedList<TreeNode> list = null;
    if (lists.size() == level) { // Level not contained in list
      list = new LinkedList<>();
      /*
       * Levels are always traversed in order. So, if this is the first time we've
       * visited level i, we must have seen levels 0 thorigh i - 1. Wec can
       * therefore safely add the level at teh end
       */
      lists.add(list);
    } else {
      list = lists.get(level);
    }
    list.add(root);
    createLevelLinkedList(root.left, lists, level + 1);
    createLevelLinkedList(root.right, lists, level + 1);
  }

  private static ArrayList<LinkedList<TreeNode>> createLevelLinkedList(TreeNode root) {
    ArrayList<LinkedList<TreeNode>> lists = new ArrayList<>();
    createLevelLinkedList(root, lists, 0);
    return lists;
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
