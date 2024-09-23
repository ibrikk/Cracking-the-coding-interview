public class ValidateBST {
    public static void main(String[] args) {
        // Create a sample binary search tree
        TreeNodee root = new TreeNodee(10);
        root.left = new TreeNodee(5);
        root.right = new TreeNodee(15);
        root.left.left = new TreeNodee(2);
        root.left.right = new TreeNodee(7);
        root.right.left = new TreeNodee(12);
        root.right.right = new TreeNodee(20);

        // Call the checkBST method to validate if the tree is a BST
        boolean isValid = checkBST(root);
        if (isValid) {
            System.out.println("The tree is a valid BST.");
        } else {
            System.out.println("The tree is not a valid BST.");
        }
    }

    private static boolean checkBST(TreeNodee n) {
        return checkBST(n, null, null);
    }

    private static boolean checkBST(TreeNodee n, Integer min, Integer max) {
        if (n == null)
            return true;
        if ((min != null && n.data <= min) || (max != null && n.data > max)) {
            return false;
        }
        if (!checkBST(n.left, min, n.data) || !checkBST(n.right, n.data, max)) {
            return false;
        }
        return true;
    }

}

class TreeNodee {
    int data;
    TreeNodee left;
    TreeNodee right;

    // Constructor that only takes the data
    public TreeNodee(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }

    // Constructor that takes data and child nodes
    public TreeNodee(int data, TreeNodee left, TreeNodee right) {
        this.data = data;
        this.left = left;
        this.right = right;
    }
}
