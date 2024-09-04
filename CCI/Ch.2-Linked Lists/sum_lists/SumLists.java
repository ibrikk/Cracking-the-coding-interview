package sum_lists;

public class SumLists {
    public static void main(String[] args) {
        LinkedList l1 = new LinkedList(7);
        l1.append(1);
        l1.append(6);

        LinkedList l2 = new LinkedList(5);
        l2.append(9);
        // l2.append(2);

        Node finalResult = addLists(l1, l2);
        System.out.println("Finished!");
    }

    public static Node addLists(LinkedList l1, LinkedList l2) {
        if (l1.size < l2.size) {
            l1.head = padList(l1.head, l2.size - l1.size);
        } else {
            l2.head = padList(l2.head, l1.size - l2.size);
        }

        PartialSum sum = addListHelper(l1.head, l2.head);

        if (sum.carry == 0) {
            return sum.sum;
        } else {
            Node result = insertBefore(sum.sum, sum.carry);
            return result;
        }
    }

    private static PartialSum addListHelper(Node n1, Node n2) {
        if (n1 == null | n2 == null) {
            return new PartialSum();
        }

        PartialSum sum = addListHelper(n1.next, n2.next);

        int val = sum.carry + n1.data + n2.data;

        Node result = insertBefore(sum.sum, val % 10);

        sum.sum = result;
        sum.carry = val / 10;

        return sum;
    }

    private static Node padList(Node n, int padding) {
        Node head = n;
        for (int i = 0; i < padding; i++) {
            head = insertBefore(head, 0);
        }
        return head;
    }

    private static Node insertBefore(Node curr, int data) {
        Node node = new Node(data);
        if (curr != null) {
            node.next = curr;
        }
        return node;
    }
}

class PartialSum {
    public Node sum;
    public int carry = 0;
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    public Node head;
    public int size;

    public LinkedList(int data) {
        Node dataNode = new Node(data);
        head = dataNode;
        size = 1;
    }

    public void append(int data) {
        Node dataNode = new Node(data);
        if (head == null) {
            head = dataNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = dataNode;
        curr = curr.next;
        size++;
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            head = head.next;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.data == data) {
                curr.next = curr.next.next;
                size--;
                return;
            }
            curr = curr.next;
        }
    }

    public void reverse() {

    }
}
