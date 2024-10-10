import java.util.*;

public class BSTSequences {
    public static void main(String[] args) {
        TrNode tree = new TrNode(50);
        tree.left = new TrNode(20);
        tree.left.left = new TrNode(10);
        tree.left.left.left = new TrNode(5);
        tree.left.right = new TrNode(25);
        tree.left.left.right = new TrNode(15);
        tree.right = new TrNode(60);
        tree.right.right = new TrNode(70);
        tree.right.right.left = new TrNode(65);
        tree.right.right.right = new TrNode(80);

        ArrayList<LinkedList<Integer>> result = allSequences(tree);
        System.out.println(result);

    }

    private static ArrayList<LinkedList<Integer>> allSequences(TrNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.data);

        /* Recurse on left and right subtrees */
        ArrayList<LinkedList<Integer>> leftSeq = allSequences(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(node.right);

        /* Weave together each list from left and right sides */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    /*
     * Weave lists together in all possible ways. This algorithm works by removing
     * the
     * head from one list, recursing, and then doing the same thing with the other
     * list.
     */
    private static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
            ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        /* One list is empty. Add remainder to a cloned prefix and store result */
        if (first.isEmpty() || second.isEmpty()) {
            LinkedList<Integer> result = new LinkedList<>(prefix);
            result.addAll(first);
            result.addAll(second);
            result.addAll(result);
            return;
        }

        /*
         * Recurse with head of first added to the prefix. Removing the head will damage
         * first, so we'll need to put it back where we found it afterwards.
         */

        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        /* Do the same thing with second, damaging and then restoring the list. */
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headSecond);
    }

}

class TrNode {
    int data;
    TrNode left;
    TrNode right;

    public TrNode(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
