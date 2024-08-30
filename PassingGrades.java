import java.util.*;

public class PassingGrades {
  public static void main(String[] args) {
    int[] grades = { 25, 70, 75, 56, 43, 35 };
    ArrayList<Integer> result = passOrFail(grades);
    System.out.println(result);

    int[] result2 = passOrFailOptimized(grades);
    for (int item : result2) {
      System.out.print(item + " ");
    }
  }

  private static ArrayList<Integer> passOrFail(int[] grades) {
    ArrayList<Integer> failingGrades = new ArrayList<>();
    ArrayList<Integer> passingGrades = new ArrayList<>();
    for (int grade : grades) {
      if (grade >= 50) {
        passingGrades.add(grade);
      } else {
        failingGrades.add(grade);
      }
    }
    failingGrades.addAll(passingGrades);
    return failingGrades;
  }

  private static int[] passOrFailOptimized(int[] grades) {
    int[] failedAndPassedInOrder = new int[grades.length];
    int tempIndex = 0;
    for (int grade : grades) {
      if (grade < 50) {
        failedAndPassedInOrder[tempIndex++] = grade;
      }
    }
    for (int grade : grades) {
      if (grade >= 50) {
        failedAndPassedInOrder[tempIndex++] = grade;
      }
    }
    return failedAndPassedInOrder;
  }
}
