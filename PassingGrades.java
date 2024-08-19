import java.util.*;

public class PassingGrades {
  public static void main(String[] args) {
    int[] grades = { 25, 70, 75, 56, 43, 35 };
    ArrayList<Integer> result = passOrFailBruteForce(grades);
    System.out.println(result);

    int[] result2 = passOrFail(grades);
    for (int item : result2) {
      System.out.println(item);
    }
  }

  private static int[] passOrFail(int[] grades) {
    int left = 0;
    int right = grades.length - 1;

    while (left < right) {
      while (left < right && grades[left] < 50) {
        left++;
      }
      while (left < right && grades[right] > 50) {
        right--;
      }

      if (grades[left] > grades[right]) {
        int temp = grades[left];
        grades[left] = grades[right];
        grades[right] = temp;
      }
    }
    return grades;
  }

  private static ArrayList<Integer> passOrFailBruteForce(int[] grades) {
    ArrayList<Integer> passingGrades = new ArrayList<>();
    ArrayList<Integer> failingGrades = new ArrayList<>();
    for (int grade : grades) {
      if (grade > 50) {
        passingGrades.add(grade);
      } else {
        failingGrades.add(grade);
      }
    }
    failingGrades.addAll(passingGrades);
    return failingGrades;
  }
}
