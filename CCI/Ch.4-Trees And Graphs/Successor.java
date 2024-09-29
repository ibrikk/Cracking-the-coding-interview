public class Successor {
    public static void main(String[] args) {
        TreeNode<Integer> root = new TreeNode<>(20);
        TreeNode<Integer> node10 = new TreeNode<>(10);
        TreeNode<Integer> node30 = new TreeNode<>(30);
        TreeNode<Integer> node5 = new TreeNode<>(5);
        TreeNode<Integer> node15 = new TreeNode<>(15);
        TreeNode<Integer> node25 = new TreeNode<>(25);
        TreeNode<Integer> node35 = new TreeNode<>(35);
        TreeNode<Integer> node17 = new TreeNode<>(17);

        // Step 2: Establish relationships (Building the BST)
        root.left = node10;
        node10.parent = root;

        root.right = node30;
        node30.parent = root;

        node10.left = node5;
        node5.parent = node10;

        node10.right = node15;
        node15.parent = node10;

        node15.right = node17;
        node17.parent = node15;

        node30.left = node25;
        node25.parent = node30;

        node30.right = node35;
        node35.parent = node30;

        // The BST structure is as follows:
        /*
         * 20
         * / \
         * 10 30
         * / \ / \
         * 5 15 25 35
         * \
         * 17
         */

        TreeNode<Integer> target = node15;

        TreeNode<Integer> successor = root.inorderSucc(target);

        if (successor != null) {
            System.out.println("In-order successor of " + target.data + " is " + successor.data + ".");
        } else {
            System.out.println("In-order successor of " + target.data + " does not exist.");
        }
    }
}

class TreeNode<T> {
    T data;
    TreeNode<T> left;
    TreeNode<T> right;
    TreeNode<T> parent;

    public TreeNode(T data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.parent = null;
    }

    public TreeNode<T> inorderSucc(TreeNode<T> n) {
        if (n == null)
            return null;

        /*
         * Case 1: If the node has a right subtree, return the leftmost child of the
         * right subtree.
         */
        if (n.right != null) {
            return leftMostChild(n.right);
        } else {
            /*
             * Case 2: If the node has no right subtree, traverse up using parent pointers.
             */
            TreeNode<T> currentNode = n;
            TreeNode<T> parentNode = currentNode.parent;

            // Traverse up until we find a node that is the left child of its parent
            while (parentNode != null && parentNode.left != currentNode) {
                currentNode = parentNode;
                parentNode = parentNode.parent;
            }
            return parentNode; // This could be null if no successor exists
        }
    }

    private TreeNode<T> leftMostChild(TreeNode<T> n) {
        if (n == null)
            return null;
        while (n.left != null) {
            n = n.left;
        }
        return n;
    }
}
