
package partition;

class Partition {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList(3);
        ll.append(5);
        ll.append(8);
        ll.append(5);
        ll.append(10);
        ll.append(2);
        ll.append(1);
        ll.partition(ll.head, 5);
        System.out.println("Finished!");

    }
}

class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }
}

class LinkedList {
    Node head;

    public LinkedList(int data) {
        head = new Node(data);
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
    }

    public void delete(int data) {
        if (head == null) {
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == data) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    Node partition(Node node, int x) {
        Node head = node;
        Node tail = node;

        while (node != null) {
            Node next = node.next;
            if (head.data < x) {
                node.next = head;
                head = node;
            } else {
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;

        return head;
    }

}