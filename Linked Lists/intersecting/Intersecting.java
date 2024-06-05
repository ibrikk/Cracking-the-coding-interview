package intersecting;

public class Intersecting {
    public static void main(String[] args) {
        // Creating nodes for the first linked list
        Node list1 = new Node(1);
        list1.append(2);
        list1.append(3);

        // Creating nodes for the second linked list
        Node list2 = new Node(4);
        list2.append(5);

        // Creating a common node for intersection
        Node commonNode = new Node(6);

        // Connecting both lists to the common node
        list1.appendNode(commonNode);
        list2.appendNode(commonNode);

        // Continue adding nodes to each list
        list1.append(7);
        list1.append(8);
        list2.append(9);
        list2.append(10);

        // Print the two lists
        System.out.println("List 1:");
        list1.printList();
        System.out.println("\nList 2:");
        list2.printList();

        intersects(list2, list2);

    }

    private static Node intersects(Node l1, Node l2) {
        if (l1 == null || l2 == null)
            return null;

        Result result1 = getTailAndSize(l1);
        Result result2 = getTailAndSize(l2);

        if (result1.tail != result2.tail) {
            return null;
        }

        Node shorter = result1.size < result2.size ? l1 : l2;
        Node longer = shorter == l1 ? l2 : l1;

        /* Advance the pointer for the longer linked list by difference in lengths. */
        longer = getKthNode(longer, Math.abs(result1.size - result2.size));
        /* Move both pointers until you have a collision. */
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        /* Return either one. */
        return longer;

    }

    private static Result getTailAndSize(Node list) {
        Node curr = list;
        int size = 0;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        return new Result(curr, size);
    }

    private static Node getKthNode(Node head, int k) {
        Node curr = head;
        while (curr != null && k > 0) {
            curr = curr.next;
            k--;
        }
        return curr;
    }

}

class Result {
    Node tail;
    int size;

    public Result(Node tail, int size) {
        this.tail = tail;
        this.size = size;
    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public void append(int data) {
        Node dataNode = new Node(data);
        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = dataNode;
    }

    // Method to append a specific node to the end of the list
    public void appendNode(Node node) {
        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    // Method to print the linked list
    public void printList() {
        Node curr = this;
        while (curr != null) {
            System.out.print(curr.data + " ");
            curr = curr.next;
        }
    }

    public Node delete(Node head, int data) {
        if (head.data == data) {
            head = head.next;
            return head;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == data) {
                curr.next = curr.next.next;
                return head;
            }
            curr = curr.next;
        }
        return head;

    }
}
