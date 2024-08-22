import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.TreeSet;
import java.util.LinkedHashSet;

public class LinkedListEx {
  public static void main(String[] args) {
    LinkedList<Integer> ll = new LinkedList<>();
    ll.add(15);
    ll.add(10);
    ll.add(1);
    ll.add(40);
    ll.add(71);

    Iterator<Integer> it = ll.iterator();

    while (it.hasNext()) {
      System.out.print(it.next() + " ");
    }
    System.out.println();

    List<Integer> a = Arrays.asList(1, 2, 8, 7, 6);
    Set<Integer> hset = new HashSet<>(a);
    System.out.println(hset);

    Set<Integer> tset = new TreeSet<>();
    tset.add(3);
    tset.add(2);
    tset.add(1);
    System.out.println("tset: " + tset);

    Set<Integer> nlset = new LinkedHashSet<>();
    nlset.add(1);
    nlset.add(3);
    nlset.add(2);
    System.out.println("nlset: " + nlset);


    List<Integer> b = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
    System.out.println(b);
    List<Integer> c = new LinkedList<>(b);
    System.out.println(c);

    
    Integer[] d = {1, 2, 3, 4};
    LinkedList<Integer> lli = new LinkedList<>();
    lli.addAll(Arrays.asList(d));
  }

}
