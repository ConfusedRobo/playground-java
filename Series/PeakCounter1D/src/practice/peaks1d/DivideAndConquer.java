package practice.peaks1d;

public class DivideAndConquer {

    public static void main(String[] args) {
        int[] array = new int[]{5, 4, 37, 82, 65, 6, 8, 3, 24, 56, 2, 34, 7, 6, 89, 23, 76, 89};
        System.out.println(binaryPeak(array, array.length / 2));
    }

    public static int binaryPeak(int[] array, int middle) {
        if (middle == 0 && array[0] > array[1]) return 0;
        if (middle == array.length - 1 && array[middle] > array[middle - 1]) return array.length - 1;

        if (array[middle] < array[middle - 1]) return binaryPeak(array, middle - 1);
        else if (array[middle] < array[middle + 1]) return binaryPeak(array, middle + 1);
        else return middle;
    }
}
