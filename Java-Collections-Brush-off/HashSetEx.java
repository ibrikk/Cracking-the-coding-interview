import java.util.HashSet;
import java.util.TreeSet;
import java.util.Set;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Collections;

public class HashSetEx {
  public static void main(String[] args) {
    Set<String> set = new HashSet<>(Arrays.asList("Geeks", "For", "ForGeeks", "GeeksforGeeks"));

    Set<String> set2 = new HashSet<>();
    set2.add("Geeks");
    set2.add("For");
    set2.add("ForGeeks");
    set2.add("GeeksforGeeks");

    System.out.println(set);
    System.out.println(set2);

    Integer[] a = { 1, 2, 3, 4, 5, 6 };
    for (int i = 0; i < a.length / 2; i++) {
      int temp = a[i];
      a[i] = a[a.length - 1 - i];
      a[a.length - 1 - i] = temp;
    }
    for (int n : a) {
      System.out.print(n);
    }
    System.out.println();



    HashSet<Integer> b = new HashSet<>(Arrays.asList(a));
    System.out.println(b);

    ArrayList<Integer> c = new ArrayList<>(b);
    Collections.sort(c);
    System.out.println(c);
    
    TreeSet<Integer> d = new TreeSet<>(c);
    System.out.println(d);

  }
}
