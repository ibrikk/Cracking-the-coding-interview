public class FindDuplicate {
  public static void main(String[] args) {
    int[] array = { 1, 2, 3, 2, 4, 5, 6, 7, 8, 9, 10, 7, 15, 16, 17, 15 }; // Example input
    checkDuplicates(array);
  }

  private static void checkDuplicates(int[] array) {
    BitSet bs = new BitSet(32000);
    for (int i = 0; i < array.length; i++) {
      int num = array[i];
      int num0 = num - 1; // bitset starts at 0, numbers start at 1
      if (bs.get(num0)) {
        System.out.println(num);
      } else {
        bs.set(num0);
      }
    }
  }
}

class BitSet {
  int[] bitset;

  public BitSet(int size) {
    bitset = new int[(size >> 5) + 1]; // divide by 32
  }

  public boolean get(int pos) {
    int wordNumber = (pos >> 5); // divide by 32
    int bitNumber = (pos & 0x1F); // mod 32
    return (bitset[wordNumber] & (1 << bitNumber)) != 0;
  }

  public void set(int pos) {
    int wordNumber = (pos >> 5); // divide by 32
    int bitNumber = (pos & 0x1F); // mod 32
    bitset[wordNumber] |= 1 << bitNumber;
  }
}
