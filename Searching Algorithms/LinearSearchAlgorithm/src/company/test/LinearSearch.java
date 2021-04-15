package company.test;

public class LinearSearch {
    private final int[] array;
    private int foundAt;

    public LinearSearch(int[] array) {
        this.array = array;
        foundAt = -1;
    }

    public int getFoundAt() {
        return foundAt;
    }

    public boolean isFound(int key) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == key) {
                foundAt = i;
                return true;
            }
        }

        return false;
    }
}