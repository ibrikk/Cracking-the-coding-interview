// import java.util.EmptyStackException;
// import java.util.NoSuchElementException;

// class Stack<T> {
//     private Node<T> top;

//     public Stack(T data) {
//         Node<T> top = new Node(data);
//         this.top = top;
//     }

//     public T pop() {
//         if (top == null)
//             throw new EmptyStackException();
//         T item = (T) top.getData();
//         top = top.next;
//         return item;
//     }

//     public void push(T data) {
//         Node dataNode = new Node(data);
//         dataNode.next = top;
//         top = dataNode;
//     }

//     public T peek() {
//         return (T) top.data;
//     }

//     public boolean isEmpty() {
//         return top == null;
//     }
// }

// class Queue<T> {
//     T data;
//     Node<T> first;
//     Node<T> last;

//     public Queue(T data) {
//         this.data = data;
//     }

//     public void enqueue(T data) {
//         Node<T> dataNode = new Node(data);
//         if (last != null) {
//             last.next = dataNode;
//         }
//         last = dataNode;
//         if (first == null) {
//             first = last;
//         }
//     }

//     public T dequeue() {
//         if (first == null)
//             throw new NoSuchElementException();
//         Node<T> item = first;
//         first = first.next;
//         return item.getData();
//     }

//     public T peek() {
//         if (first == null)
//             throw new NoSuchElementException();
//         return first.getData();
//     }

//     public boolean isEmpty() {
//         return first == null;
//     }
// }

// class Node<T> {
//     T data;
//     Node<T> next;

//     public Node(T data) {
//         this.data = data;
//     }

//     public T getData() {
//         return data;
//     }
// }
