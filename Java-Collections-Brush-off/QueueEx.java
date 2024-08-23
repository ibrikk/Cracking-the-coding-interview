import java.util.Queue;
import java.util.Iterator;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;

public class QueueEx {
  public static void main(String[] args) {
    Queue<Integer> queue = new LinkedList<>(Arrays.asList(1, 3, 8, 14, 9, 3));
    System.out.println(queue);

    Queue<Integer> queue2 = new LinkedList<>();
    queue2.offer(1);
    queue2.offer(3);
    queue2.offer(8);
    queue2.offer(14);
    queue2.offer(9);
    queue2.offer(3);
    System.out.println(queue2);

    Iterator<Integer> it = queue.iterator();

    while (it.hasNext()) {
      System.out.println("number " + it.next());
    }

    PriorityQueue<PairInt> pqInt = new PriorityQueue<>((a, b) -> Integer.compare(b.key, a.key));
    PriorityQueue<PairString> pqString = new PriorityQueue<>((a, b) -> b.key.compareTo(a.key));

  }

  class PairInt {
    int key;
    int value;

    public PairInt(int key, int value) {
      this.key = key;
      this.value = value;
    }
  }

  class PairString {
    String key;
    String value;

    public PairString(String key, String value) {
      this.key = key;
      this.value = value;
    }
  }
}
