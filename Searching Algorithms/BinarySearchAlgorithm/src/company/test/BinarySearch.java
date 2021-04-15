package company.test;

/**
 * @author ConfusedRobo
 * Do not modify.
 */
public class BinarySearch {
    private final int[] array;
    private int low;
    private int high;
    private int foundAt;

    public BinarySearch(int[] array) {
        foundAt = -1;
        this.array = array;
        low = 0;
        high = array.length - 1;
    }

    public boolean isFound(int key) {
        while (low <= high) {
            int midIndex = (low + high) / 2;

            if (array[midIndex] < key) {
                low = midIndex + 1;
            } else if (array[midIndex] == key) {
                foundAt = midIndex;
                return true;
            } else {
                high = midIndex - 1;
            }
        }

        return false;
    }

    public int getFoundAt() {
        return foundAt;
    }
}