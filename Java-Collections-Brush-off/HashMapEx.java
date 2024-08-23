import java.util.HashMap;
import java.util.TreeMap;
import java.util.Map;
import java.util.Iterator;

public class HashMapEx {
  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();
    map.put("A", "Angular");
    map.put("J", "Java");
    map.put("P", "Python");
    map.put("H", "Hibernate");

    for (Map.Entry<String, String> set : map.entrySet()) {
      System.out.println(set.getKey() + " = " + set.getValue());
    }

    map.forEach((key, value) -> System.out.println(key + " = " + value));

    Iterator<Map.Entry<String, String>> it = map.entrySet().iterator();

    while (it.hasNext()) {
      System.out.println(it.next());
    }

    for (String s : map.keySet()) {
      System.out.println(s);
    }

    for (String s : map.values()) {
      System.out.println(s);
    }

    HashMap<Integer, String> a = new HashMap<>();
    a.put(1, "Geeks");
    a.put(2, "ForGeeks");
    a.put(3, "GeeksForGeeks");
    System.out.println(a);
    System.out.println(a.containsKey(2));
    System.out.println(a.containsValue("Geeks"));

    String words = "Alice is girl and Bob is boy";
    String[] wordsArr = words.split(" ");
    HashMap<String, Integer> m = new HashMap<>();
    for (String word : wordsArr) {
      if (!m.containsKey(word)) {
        m.put(word, 1);
      } else {
        m.put(word, m.get(word) + 1);
      }
    }
    System.out.println(m);

    // A bit better approach but doesn't really matter
    for (String word : wordsArr) {
      if (m.get(word) == null) {
        m.put(word, 1);
      } else {
        m.put(word, m.get(word) + 1);
      }
    }
    System.out.println(m);

    HashMap<Character, Integer> b = new HashMap<>();
    b.put('A', 1);
    b.put('B', 2);
    b.put('C', 3);
    HashMap<Character, Integer> c = new HashMap<>();
    c.putAll(b);
    System.out.println(c);

    String words2 = "geeksforgeeks";
    char[] chars = words2.toCharArray();
    Map<Character, Integer> map2 = new HashMap<>();
    for (char ch : chars) {
      if (map2.get(ch) == null) {
        map2.put(ch, 1);
      } else {
        map2.put(ch, map2.get(ch) + 1);
      }
    }

    System.out.println(map2);

    for (Map.Entry<Character, Integer> item : map2.entrySet()) {
      System.out.println(item.getKey() + " : " + item.getValue());
    }

    // map2.forEach((key, value) -> System.out.println(key + " : " + value));


    TreeMap<Character, Integer> treemap = new TreeMap<>();
    treemap.putAll(map2);
  }
}
