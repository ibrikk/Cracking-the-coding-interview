import java.util.ArrayList;

public class PermWithoutDup {
  public static void main(String[] args) {
    ArrayList<String> result = getPerms("abc");
    System.out.println(result);

    ArrayList<String> result2 = getPerms2("abcd");
    System.out.println(result2);

    ArrayList<String> result3 = getPerms3("abcd");
    System.out.println(result3);
  }

  private static ArrayList<String> getPerms(String str) {
    if (str == null) {
      return null;
    }

    ArrayList<String> permutations = new ArrayList<String>();
    if (str.length() == 0) {
      permutations.add("");
      return permutations;
    }

    char first = str.charAt(0); // get the first char
    String remainder = str.substring(1); // remove the first char
    ArrayList<String> words = getPerms(remainder);

    for (String word : words) {
      for (int j = 0; j <= word.length(); j++) {
        String s = insertCharAt(word, first, j);
        permutations.add(s);
      }
    }
    return permutations;
  }

  private static String insertCharAt(String word, char c, int j) {
    String start = word.substring(0, j);
    String end = word.substring(j);
    return start + c + end;
  }

  private static ArrayList<String> getPerms2(String remainder) {
    int len = remainder.length();
    ArrayList<String> result = new ArrayList<>();
    if (len == 0) {
      result.add("");
    }

    for (int i = 0; i < len; i++) {
      // Remove char i and find permutations of remaining characters
      String before = remainder.substring(0, i);
      String after = remainder.substring(i + 1, len);
      ArrayList<String> partials = getPerms2(before + after);

      for (String s : partials) {
        // Prepend char i to each permutation
        result.add(remainder.charAt(i) + s);
      }
    }
    return result;
  }

  private static ArrayList<String> getPerms3(String str) {
    ArrayList<String> result = new ArrayList<>();
    getPerms3("", str, result);
    return result;
  }

  private static void getPerms3(String prefix, String remainder, ArrayList<String> result) {
    if (remainder.length() == 0) {
      result.add(prefix);
    }
    int len = remainder.length();
    for (int i = 0; i < len; i++) {
      String before = remainder.substring(0, i);
      String after = remainder.substring(i + 1, len);
      char c = remainder.charAt(i);
      getPerms3(prefix + c, before + after, result);
    }
  }
}
