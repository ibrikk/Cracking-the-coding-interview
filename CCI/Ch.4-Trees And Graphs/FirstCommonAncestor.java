public class FirstCommonAncestor {
    public static void main(String[] args) {
        INode<Integer> node1 = new INode<>(1);
        INode<Integer> node2 = new INode<>(2);
        INode<Integer> ancestor = commonAncestor(node1, node2);
        System.out.println("Common Ancestor: " + (ancestor != null ? ancestor.data : "None"));
    }

    private static <T> INode<T> commonAncestor(INode<T> p, INode<T> q) {
        int delta = depth(p) - depth(q); // get difference in depths
        INode<T> first = delta > 0 ? q : p;
        INode<T> second = delta > 0 ? p : q;
        second = goUpBy(second, Math.abs(delta));

        /* Find where paths intersect. */
        while (first != second && first != null && second != null) {
            first = first.parent;
            second = second.parent;
        }

        return first == null || second == null ? null : first;
    }

    // BETTER APPROACH WITH LINKS TO PARENT
    <T> INode<T> commonAncestor(INode<T> root, INode<T> p, INode<T> q) {
        /* Check if either node is not in the tree, or if one covers the other. */
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        } else if (covers(p, q)) {
            return p;
        } else if (covers(q, p)) {
            return q;
        }

        /* Traverse upwards until you find a node that covers q. */
        INode<T> sibling = getSibling(p);
        INode<T> parent = p.parent;
        while (!covers(sibling, q)) {
            sibling = getSibling(parent);
            parent = parent.parent;
        }
        return parent;
    }

    private static <T> boolean covers(INode<T> root, INode<T> p) {
        if (root == null)
            return false;
        if (root == p)
            return true;
        return covers(root.left, p) || covers(root.right, p);
    }

    private static <T> INode<T> getSibling(INode<T> node) {
        if (node == null || node.parent == null) {
            return null;
        }
        INode<T> parent = node.parent;
        return parent.left == node ? parent.right : parent.left;
    }

    private static <T> INode<T> goUpBy(INode<T> node, int delta) {
        while (delta > 0 && node != null) {
            node = node.parent;
            delta--;
        }
        return node;
    }

    private static <T> int depth(INode<T> node) {
        int depth = 0;
        while (node != null) {
            node = node.parent;
            depth++;
        }
        return depth;
    }

    <T> INode<T> commonAncestorWithoutParent(INode<T> root, INode<T> p, INode<T> q) {
        /* Error check - one node is not in the tree. */
        if (!covers(root, p) || !covers(root, q)) {
            return null;
        }
        return ancestorHelper(root, p, q);
    }

    <T> INode<T> ancestorHelper(INode<T> root, INode<T> p, INode<T> q) {
        if (root == null || root == p || root == q) {
            return root;
        }

        boolean plsOnleft = covers(root.left, p);
        boolean qlsOnLeft = covers(root.left, q);
        if (plsOnleft != qlsOnLeft) { // Nodes are on different side
            return root;
        }
        INode<T> childSide = plsOnleft ? root.left : root.right;
        return ancestorHelper(childSide, p, q);
    }

    <T> INode<T> commonAncestorWithoutParentOptimized(INode<T> root, INode<T> p, INode<T> q) {
        Result<T> r = commonAncHelper(root, p, q);
        if (r.isAncestor) {
            return r.node;
        }
        return null;
    }

    private static <T> Result<T> commonAncHelper(INode<T> root, INode<T> p, INode<T> q) {
        if (root == null)
            return new Result<T>(null, false);

        if (root == p && root == q) {
            return new Result<T>(root, true);
        }

        Result<T> rx = commonAncHelper(root.left, p, q);
        if (rx.isAncestor) {// Found common ancestor
            return rx;
        }

        Result<T> ry = commonAncHelper(root.right, p, q);
        if (ry.isAncestor) {// Found common ancestor
            return ry;
        }

        if (rx.node != null && ry.node != null) {
            return new Result<T>(root, true); // This is the common ancestor
        } else if (root == p || root == q) {
            /*
             * If we're currently at p or q, and we also found one of those nodes in a
             * subtree, then this is truly an ancestor and the flag should be true.
             */
            boolean isAncestor = rx.node != null || ry.node != null;
            return new Result<T>(root, isAncestor);
        } else {
            return new Result<T>(rx.node != null ? rx.node : ry.node, false);

        }
    }
}

class INode<T> {
    T data;
    INode<T> left;
    INode<T> right;
    INode<T> parent;

    public INode(T data) {
        this.data = data;
    }
}

class Result<T> {
    public INode<T> node;
    public boolean isAncestor;

    public Result(INode<T> n, boolean isAnc) {
        node = n;
        isAncestor = isAnc;
    }
}
