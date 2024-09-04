public class ThreeInOne {

    public static void main(String[] args) {

    }

    class FixedMultiStack {

        int numberOfStacks = 3;
        int stackCapacity; // per array
        int[] values;
        int[] sizes;

        public FixedMultiStack(int stackSize) {
            stackCapacity = stackSize;
            values = new int[stackSize * numberOfStacks];
            sizes = new int[numberOfStacks];
        }

        public void push(int stackNum, int value) throws Exception {
            if (isFull(stackNum)) {
                throw new Exception();
            }
            sizes[stackNum]++;
            values[indexOfTop(stackNum)] = value;
        }

        public int pop(int stackNum) throws Exception {
            if (isEmpty(stackNum)) {
                throw new Exception();
            }
            int topIndex = indexOfTop(stackNum);
            int value = values[topIndex];
            values[topIndex] = 0;
            sizes[stackNum]--;
            return value;
        }

        public int peek(int stackNum) throws Exception {
            if (isEmpty(stackNum)) {
                throw new Exception();
            }
            return values[indexOfTop(stackNum)];
        }



        private boolean isFull(int stackNum) {
            return sizes[stackNum] == stackCapacity;
        }

        private int indexOfTop(int stackNum) {
            int offset = stackNum * stackCapacity;
            int size = sizes[stackNum];
            return offset + size - 1;
        }

        private boolean isEmpty(int stackNum) {
            return sizes[stackNum] == 0;
        }
    }

    class Stack {

    }
}