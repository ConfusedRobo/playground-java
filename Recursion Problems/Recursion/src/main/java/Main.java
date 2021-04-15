public class Main {

    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }

    public static int sum(int[] array) {
        return sum(array, 0);
    }

    public static int sum(int[] array, int index) {
        if (index == array.length) return 0;
        return array[index] + sum(array, index + 1);
    }

    public static int search(int[] array, int key) {
        return search(array, 0, array.length - 1, key);
    }

    public static int search(int[] array, int left, int right, int find) {
        if (left <= right) {
            int middle = left + (right - left) / 2;
            if (array[middle] == find) return middle;
            return array[middle] > find ? search(array, left, middle - 1, find)
                                        : search(array, middle + 1, right, find);
        }
        return -1;
    }

    public static int frequency(int[] array, int key) {
        return frequency(array, 0, key);
    }

    public static int frequency(int[] array, int index, int key) {
        if (index == array.length) return 0;
        return array[index] == key ? 1 + frequency(array, index + 1, key) : frequency(array, index + 1, key);
    }
}
