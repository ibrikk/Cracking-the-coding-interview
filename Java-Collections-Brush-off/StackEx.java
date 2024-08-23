import java.util.Stack;
import java.util.Arrays;
import java.util.HashMap;

public class StackEx {
  public static void main(String[] args) {
    Stack<Integer> stack = new Stack<>();
    stack.push(10);
    stack.push(20);
    stack.push(30);
    stack.push(40);
    stack.push(50);
    System.out.println(stack);

    Stack<Integer> stack2 = new Stack<>();
    stack2.addAll(Arrays.asList(10, 20, 30, 40, 50));

    String s = "(()(()))";
    System.out.println(getClosingIndex(s));


    String binaryString = "110110";
    System.out.println(convertBinaryToUnary(binaryString));

  }

  private static int getClosingIndex(String s) {
    Stack<Integer> st = new Stack<>();
    HashMap<Integer, Integer> endIndex = new HashMap<>();

    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ')') {
        // If it's a closing bracket,
        // pop index of it's corresponding
        // opening bracke
        int startIndex = st.pop();

        // Insert the index of opening
        // bracket and closing bracket
        // as key-value pair in the
        // hashmap
        endIndex.put(startIndex, i);
      } else {
        // If it's an opening bracket,
        // push it's index into the stack
        st.push(i);
      }
    }
    return calcWeight(s, 0, s.length() - 1, endIndex);
  }

  private static int calcWeight(String s, int low, int high, HashMap<Integer, Integer> endIndex) {
    // Back to back
    if (low + 1 == high) {
      return 1;
    } else {
      // Nested. The closing parenthesis for ( at index 0 is at index 7, so the
      // structure is nested.
      int mid = endIndex.get(low); // the closing bracket for the low
      if (mid == high) {
        // if we're looking at the very end closing braket ) meaning it's a fully nested
        // structure like ((...))
        return 2 * calcWeight(s, low + 1, high - 1, endIndex);
      } else {
        // if the current substring is made up of two sequential structures (e.g.,
        // ()()),
        // the weight is calculated by summing the weights of the two parts.
        return calcWeight(s, low, mid, endIndex) + calcWeight(s, mid + 1, high, endIndex);
      }
    }
  }

  private static boolean convertBinaryToUnary(String s) {
    Stack<Character> stack = new Stack<>();
    for (char ch : s.toCharArray()) {
      if (!stack.isEmpty() && stack.peek() == ch) {
        stack.pop();
      } else {
        stack.push(ch);
      }
    }
    if (stack.size() <= 1) {
      return true;
    } else {
      return false;
    }
  }
}
