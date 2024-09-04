public class RankFromStream {
  private RankNode root = null;

  public static void main(String[] args) {
    RankFromStream rankFromStream = new RankFromStream();

    // Stream of integers in the order of appearance
    int[] stream = { 5, 1, 4, 4, 5, 9, 7, 13, 3 };

    // Track each number in the stream
    for (int number : stream) {
      rankFromStream.track(number);
    }

    // Test getRankOfNumber method
    System.out.println("Rank of 1: " + rankFromStream.getRankOfNumber(1)); // Expected output: 0
    System.out.println("Rank of 3: " + rankFromStream.getRankOfNumber(3)); // Expected output: 1
    System.out.println("Rank of 4: " + rankFromStream.getRankOfNumber(4)); // Expected output: 3
  }

  private void track(int number) {
    if (root == null) {
      root = new RankNode(number);
    } else {
      root.insert(number);
    }
  }

  private int getRankOfNumber(int number) {
    return root.getRank(number);
  }
}

class RankNode {
  public int left_size = 0;
  public RankNode left, right;
  public int data = 0;

  public RankNode(int d) {
    data = d;
  }

  public void insert(int d) {
    if (d <= data) {
      if (left != null) {
        left.insert(d);
      } else {
        left = new RankNode(d);
        left_size++;
      }
    } else {
      if (right != null)
        right.insert(d);
      else
        right = new RankNode(d);
    }
  }

  public int getRank(int d) {
    if (d == data) {
      return left_size;
    } else if (d < data) {
      if (left == null)
        return -1;
      else
        return left.getRank(d);
    } else {
      int right_rank = right == null ? -1 : right.getRank(d);
      if (right_rank == -1)
        return -1;
      else
        return left_size + 1 + right_rank;
    }
  }
}
