public class LoopDetection {
    public static void main(String[] args) {
        Node a = new Node("A");
        Node c = new Node("C");
        a.append("B");
        a.append(c);
        a.append("D");
        a.append("E");
        a.append("F");
        a.append("G");
        a.append(c);

        String result = loopDetect(a);
        System.out.println(result);
    }

    private static String loopDetect(Node head) {
        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (slow == null || fast == null) {
            return null;
        }

        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return fast.data;
    }
}

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
    }

    public void append(String data) {
        Node dataNode = new Node(data);
        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = dataNode;
    }

    public void append(Node node) {
        Node curr = this;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = node;
    }

    public Node delete(Node head, String data) {
        if (head.data == data) {
            head = head.next;
        }
        Node curr = head;
        while (curr.next != null) {
            if (curr.next.data == data) {
                Node deleted = curr.next;
                curr.next = curr.next.next;
                return deleted;
            }
            curr = curr.next;
        }
        return null;
    }
}


