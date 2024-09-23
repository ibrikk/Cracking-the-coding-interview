public class CheckBalanced {
    public static void main(String[] args) {
        TreeNode d = new TreeNode(4, null, null);
        TreeNode e = new TreeNode(5, null, null);
        TreeNode f = new TreeNode(6, null, null);
        TreeNode g = new TreeNode(7, null, null);
        TreeNode c = new TreeNode(3, f, g);
        TreeNode b = new TreeNode(2, e, f);
        TreeNode a = new TreeNode(9, c, d);
        TreeNode root = new TreeNode(1, a, b);

        root.printTree(root);

        System.out.println();

        System.out.println(isBalanced(root));
        System.out.println(isBalancedOpt(root));
    }

    private static int getHeight(TreeNode root) {
        if (root == null)
            return -1;
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    private static boolean isBalanced(TreeNode root) {
        if (root == null)
            return true;
        int heightDiff = getHeight(root.left) - getHeight(root.right);
        if (Math.abs(heightDiff) > 1) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }

    }

    // Optimized

    private static int checkHeight(TreeNode root) {
        if (root == null)
            return -1;
        int leftHeight = checkHeight(root.left);
        if (leftHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE; // Pass error up
        int rightHeight = checkHeight(root.right);
        if (rightHeight == Integer.MIN_VALUE)
            return Integer.MIN_VALUE; // Pass error up

        int heightDiff = leftHeight - rightHeight;
        if (Math.abs(heightDiff) > 1) {
            return Integer.MIN_VALUE; // Found error - pass it back
        } else {
            return Math.max(rightHeight, heightDiff) + 1;
        }
    }

    private static boolean isBalancedOpt(TreeNode root) {
        return checkHeight(root) != Integer.MIN_VALUE;
    }

}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    public TreeNode(int data, TreeNode left, TreeNode right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }

    public void printTree(TreeNode node) {
        if (node == null)
            return;
        System.out.print(node.data);
        printTree(node.left);
        printTree(node.right);

    }
}
