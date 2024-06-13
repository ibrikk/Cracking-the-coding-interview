package palindrome;

public class Palindrome {
  public static void main(String[] args) {
    LinkedList ll = new LinkedList(1);
    ll.append(2);
    ll.append(3);
    ll.append(3);
    ll.append(2);
    ll.append(1);

    LinkedList ll2 = ll.reverse(ll);

    Node currL1 = ll.head;
    Node currL2 = ll2.head;


    LinkedList ll3 = new LinkedList(1);
    ll3.append(2);
    ll3.append(3);
    ll3.append(4);
    ll3.append(5);
    ll3.append(6);

    LinkedList ll4 = ll.reverse(ll3);

    Node currL3 = ll3.head;
    Node currL4 = ll4.head;

  boolean result = isPalindrome(currL1, currL2);
  System.out.println(result);

  boolean result2 = isPalindrome(currL3, currL4);
  System.out.println(result2);
  }

  private static boolean isPalindrome(Node currL1, Node currL2) {
    while (currL1 != null && currL2 != null) {
      if (currL1.data != currL2.data) {
        return false;
      }
      currL1 = currL1.next;
      currL2 = currL2.next;
    }
    return currL1 == null && currL2 == null;
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
  public Node head;
  int size;

  public LinkedList(int data) {
    Node dataNode = new Node(data);
    head = dataNode;
    size = 1;
  }

  public void append(int data) {
    Node dataNode = new Node(data);

    if (head == null) {
      head = dataNode;
      size++;
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
    if (head == null) return;
    if (head.data == data) {
      head = head.next;
      size--;
      return;
    }
    Node curr = head;
    while (curr.next != null) {
      if (curr.next.data == data) {
        curr.next = curr.next.next;
        size--;
        return;
      }
      curr = curr.next;
    }
  }

  public LinkedList reverse(LinkedList ll) {
    LinkedList newLL = ll;
    Node curr = newLL.head;
    Node prev = null;
    while (curr != null) {
      Node following = curr.next;
      curr.next = prev;
      prev = curr;
      curr = following;
    }
    return ll;
  }
}
