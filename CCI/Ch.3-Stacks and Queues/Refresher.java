public class Refresher {

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

  public Node delete(Node head, int data) {
    if (head.data == data) {
      head = head.next;
      return head;
    }
    Node curr = this;
    while (curr.next != null) {
      if (curr.next.data == data) {
        Node removed = curr.next;
        curr.next = curr.next.next;
        return removed;
      }
      curr = curr.next;
    }
    return null;
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
