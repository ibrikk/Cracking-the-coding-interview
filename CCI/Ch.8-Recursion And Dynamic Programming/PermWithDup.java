import java.util.ArrayList;
import java.util.HashMap;

public class PermWithDup {
  public static void main(String[] args) {
    ArrayList<String> result = printPerms("abc");
    System.out.println(result);

  }

  private static ArrayList<String> printPerms(String s) {
    ArrayList<String> result = new ArrayList<>();
    HashMap<Character, Integer> map = buildFerqTable(s);
    System.out.println(map);
    printPerms(map, "", s.length(), result);
    return result;
  }

  private static HashMap<Character, Integer> buildFerqTable(String s) {
    HashMap<Character, Integer> map = new HashMap<>();
    for (char c : s.toCharArray()) {
      if (!map.containsKey(c)) {
        map.put(c, 0);
      }
      map.put(c, map.get(c) + 1);
    }
    return map;
  }

  private static void printPerms(HashMap<Character, Integer> map, String prefix, int remaining,
      ArrayList<String> result) {
        System.out.println(map);
        System.out.println(prefix);
        System.out.println(remaining);
        System.out.println(result);
    if (remaining == 0) {
      result.add(prefix);
      return;
    }

    for (Character c : map.keySet()) {
      int count = map.get(c);
      if (count > 0) {
        map.put(c, count - 1);
        printPerms(map, prefix + c, remaining - 1, result);
        map.put(c, count);
      }
    }
  }

}
