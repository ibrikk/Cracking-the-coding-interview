import java.util.EmptyStackException;
import java.util.NoSuchElementException;

public class RefresherNew {
  
}

class Node<T> {
  T data;
  Node<T> next;

  public Node(T data) {
    this.data = data;
  }

}

class Stack<T> {
Node<T> top;

  public Stack(T data) {
    Node<T> newNode = new Node(data);
    top = newNode;
  }

  public T peek() {
    return (T) top.data; 
  }

  public void push(T data) {
    Node<T> node = new Node(data);
    node.next = top;
    top = node;
  }

  public T pop() {
    if (top == null) throw new EmptyStackException();
    Node<T> toBeDeleted = top;
    top = top.next;
    return toBeDeleted.data;
  }

  public boolean isEmpty() {
    return top == null;
  }
}

class Queue<T> {
  Node<T> first;
  Node<T> last;

  public void enqueue(T data) {
    Node<T> dataNode = new Node(data);
    if (last != null) {
      last.next = dataNode;
    }
    last = dataNode;
    if (first == null) {
      first = last;
    }
  }

  public T dequeue() {
    if (first == null) {
      throw new NoSuchElementException();
    }
    T toBeRemoved = first.data;
    first = first.next;
    return toBeRemoved;
  }

  public T peek() {
    if (first == null) throw new NoSuchElementException();
    return first.data;
  }

  public boolean isEmpty() {
    return first == null;
  }
}
