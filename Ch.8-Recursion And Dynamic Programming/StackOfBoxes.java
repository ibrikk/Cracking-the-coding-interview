import java.util.*;

public class StackOfBoxes {
  public static void main(String[] args) {
    ArrayList<Box> boxes = new ArrayList<>();
    boxes.add(new Box(4, 6, 7));
    boxes.add(new Box(1, 2, 3));
    boxes.add(new Box(4, 5, 6));
    boxes.add(new Box(10, 12, 32));

    // Call the createStack method
    int maxHeight = createStack(boxes);
    System.out.println("Max height of the stack using createStack: " + maxHeight);

    // Call the createStackOpt method (optimized version)
    int maxHeightOpt = createStackOpt(boxes);
    System.out.println("Max height of the stack using createStackOpt: " + maxHeightOpt);
  }

  private static int createStack(ArrayList<Box> boxes) {
    /* Sort in descending order by height */
    Collections.sort(boxes, new BoxComparator());
    int maxHeight = 0;
    for (int i = 0; i < boxes.size(); i++) {
      int height = createStack(boxes, i);
      maxHeight = Math.max(maxHeight, height);
    }
    return maxHeight;
  }

  private static int createStack(ArrayList<Box> boxes, int bottomIndex) {
    Box bottom = boxes.get(bottomIndex);
    int maxHeight = 0;
    for (int i = bottomIndex; i < boxes.size(); i++) {
      if (boxes.get(i).canBeAbove(bottom)) {
        int height = createStack(boxes, i);
        maxHeight = Math.max(height, maxHeight);
      }
    }
    maxHeight += bottom.height;
    return maxHeight;
  }

  /* OPTIMIZED VERSION */

  private static int createStackOpt(ArrayList<Box> boxes) {
    Collections.sort(boxes, new BoxComparator());
    int[] stackMap = new int[boxes.size()];
    return createStackOpt(boxes, null, 0, stackMap);
  }

  private static int createStackOpt(ArrayList<Box> boxes, Box bottom, int offset, int[] stackMap) {
    if (offset >= boxes.size())
      return 0; // Base case

    /* height with this bottom */
    Box newBottom = boxes.get(offset);
    int heightWithBottom = 0;
    if (bottom == null || newBottom.canBeAbove(bottom)) {
      if (stackMap[offset] == 0) {
        stackMap[offset] = createStackOpt(boxes, newBottom, offset + 1, stackMap);
        stackMap[offset] += newBottom.height;
      }
      heightWithBottom = stackMap[offset];
    }

    /* without this bottom */
    int heightWithoutBottom = createStackOpt(boxes, bottom, offset + 1, stackMap);
    return Math.max(heightWithBottom, heightWithoutBottom);
  }

}

class BoxComparator implements Comparator<Box> {
  @Override
  public int compare(Box a, Box b) {
    return b.height - a.height;
  }
}

class Box {
  int height;
  int depth;
  int width;

  public Box(int height, int width, int depth) {
    this.height = height;
    this.width = width;
    this.depth = depth;
  }

  public boolean canBeAbove(Box other) {
    return this.width < other.width && this.height < other.height && this.depth < other.depth;
  }
}
