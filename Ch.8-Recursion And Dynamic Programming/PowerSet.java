import java.util.ArrayList;
import java.util.Arrays;

public class PowerSet {

  // Power Set: Write a method to return all subsets of a set.
  public static void main(String[] args) {
    // Initialize the set with values 1, 2
    ArrayList<Integer> set = new ArrayList<>(Arrays.asList(1, 2));

    // Call the method to get all subsets (the power set)
    ArrayList<ArrayList<Integer>> result = getSubsets(set, 0);

    // Print the result
    for (ArrayList<Integer> subset : result) {
      System.out.println(subset);
    }
  }

  private static ArrayList<ArrayList<Integer>> getSubsets(ArrayList<Integer> set, int index) {
    ArrayList<ArrayList<Integer>> allsubsets;
    if (set.size() == index) {
      allsubsets = new ArrayList<>();
      allsubsets.add(new ArrayList<Integer>());
    } else {
      allsubsets = getSubsets(set, index + 1);
      int item = set.get(index);
      ArrayList<ArrayList<Integer>> moresubsets = new ArrayList<>();
      for (ArrayList<Integer> subset : allsubsets) {
        ArrayList<Integer> newsubset = new ArrayList<>();
        newsubset.addAll(subset);
        newsubset.add(item);
        moresubsets.add(newsubset);
      }
      allsubsets.addAll(moresubsets);
    }
    return allsubsets;
  }
}
