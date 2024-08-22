import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ArrayListEx {
  public static void main(String[] args) {

    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    System.out.println(arr);

    arr.remove(1);
    System.out.println(arr);

    arr.set(1, 2);
    System.out.println(arr);

    Integer[] a = { 8, 4, 3, 5, 2 };
    Arrays.sort(a, Collections.reverseOrder());
    for (int num : a) {
      System.out.print(num + ",");
    }
    System.out.println();

    List<Integer> b = new ArrayList<>();
    b = Arrays.asList(a);
    System.out.println(b);

    Collections.sort(b);
    System.out.println(b);

    List<Integer> c = new ArrayList<>();
    Integer[] d = { 1, 2, 3, 4 };

    List<Integer> e = new ArrayList<>();
    Integer[] f = { 4, 2, 3, 1 };
    c = Arrays.asList(d);
    e = Arrays.asList(f);

    System.out.println(c.equals(e));

  }
}
