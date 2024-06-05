public class Palindrome {
    public static void main(String[] args) {
        Node ll = new Node(1);
        ll.next = new Node(2);
        ll.next.next = new Node(3);
        ll.next.next.next = new Node(4);
        ll.next.next.next.next = new Node(4);
        ll.next.next.next.next.next = new Node(3);
        ll.next.next.next.next.next.next = new Node(2);
        ll.next.next.next.next.next.next.next = new Node(1);

        boolean result = palindrome(ll);
        System.out.println(result);
    }

    private static boolean palindrome(Node list) {
        Node newList = new Node(list.data);
        Node curr = list;
        Node newCurr = newList;
        while (curr.next != null) {
            newCurr.next = new Node(curr.next.data);
            curr = curr.next;
            newCurr = newCurr.next;
        }
        newList = newList.reverse(newList);
        Node currList = list;
        Node currNewList = newList;
        while (currList != null) {
            if (currList.data != currNewList.data) {
                return false;
            }
            currList = currList.next;
            currNewList = currNewList.next;
        }
        return currList == null && currNewList == null;
    }
}

class Node {
    int data;
    Node next;
    int size;

    public Node(int data) {
        this.data = data;
        size = 1;
    }

    public void append(int data) {
        Node dataNode = new Node(data);
        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = dataNode;
    }

    public void delete(Node head, int data) {
        Node curr = head;
        if (curr.data == data) {
            head = head.next;
            return;
        }
        while (curr.next != null) {
            if (curr.next.data == data) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
    }

    public Node reverse(Node head) {
        Node curr = head;
        Node prev = null;
        while (curr != null) {
            Node following = curr.next;
            curr.next = prev;
            prev = curr;
            curr = following;
        }
        return prev;
    }
}