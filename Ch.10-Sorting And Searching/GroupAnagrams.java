import java.util.*;

class AnagramComparator implements Comparator<String> {
  public String sortChars(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }

  @Override
  public int compare(String s1, String s2) {
    return sortChars(s1).compareTo(sortChars(s2));
  }
}

public class GroupAnagrams {
  public static void main(String[] args) {
    String[] arr = { "listen", "silent", "enlist", "rat", "tar", "art" };
    Arrays.sort(arr, new AnagramComparator());
    for (String word : arr) {
      System.out.print(word + " ");
    }
    System.out.println();

    String[] array = { "listen", "silent", "enlist", "rat", "tar", "art" };
    sort(array);
    System.out.println(Arrays.toString(array));
  }

  private static void sort(String[] array) {
    // HashMap to group words by their sorted character form
    HashMap<String, ArrayList<String>> mapList = new HashMap<>();

    /* Group words by anagram */
    for (String s : array) {
      String key = sortChars(s);
      if (!mapList.containsKey(key)) {
        mapList.put(key, new ArrayList<>());
      }
      mapList.get(key).add(s);
    }

    /*
     * {
     * eilnst: [listen, silent, enlist]
     * art: [rat, tar, art]
     * }
     */

    /* Convert hash table to array */
    int index = 0;
    for (String key : mapList.keySet()) {
      ArrayList<String> list = mapList.get(key);
      for (String t : list) {
        array[index] = t;
        index++;
      }
    }
  }

  // Helper method to sort the characters in a string
  private static String sortChars(String s) {
    char[] content = s.toCharArray();
    Arrays.sort(content);
    return new String(content);
  }
}
