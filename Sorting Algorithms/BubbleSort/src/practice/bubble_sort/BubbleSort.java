package practice.bubble_sort;

/**
 * This class provides the utility tools for
 * bubble sorting algorithms.
 * That is, both the naive and optimized
 * implementations have been coded.
 *
 * @author Confused Robo
 * Dated: 21-01-21 2:00 A.M.
 * */
public class BubbleSort {
    private final int[] array;

    public BubbleSort(int[] array) {
        this.array = array;
    }

    /**
     * This method implements the non-optimized i.e. the naive
     * approach to bubble sort.
     *
     * @return int[] i.e. the same array but, sorted
     * */
    // suppress side memory modification side effect warnings
    @SuppressWarnings("ConstantConditions")
    private int[] sortV1() {
        int[] array = this.array;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    // if the adjacent element is lesser than
                    // the current element then swap them and
                    // remember the changes
                    array = swap(array, i, j);
                }
            }
        }

        // return the same but modified array
        return array;
    }

    /**
     * This method sorts the array with preference of order
     * Also, uses the naive approach
     *
     * @param descending is the order specification
     * @return int[] array i.e. sorted and the same one but modified
     * */
    @SuppressWarnings("DuplicatedCode")
    public int[] sortV1(boolean descending) {
        // sorted array in ascending order
        int[] array = sortV1();
        if (!descending) {      // if preference is ascending
            return array;
        }

        // return the same but modified array
        return reverseArray(array);
    }

    /**
     * Swaps two array elements.
     *
     * @param array is the array where some part is to be swapped
     * @param des is the destination index
     * @param src is the source index number
     * @return int[] array that has one element swapped
     * */
    private int[] swap(int[] array, int src, int des) {
        // store/save the elements in variables
        int srcVal = array[src];
        int desVal = array[des];

        // swapping the values to their co-responding indices
        array[src] = desVal;
        array[des] = srcVal;

        // return the swapped array
        return array;
    }

    /**
     * This method just reverses an array
     *
     * @param array is the array to be reversed
     * @return int[] array
     * */
    private int[] reverseArray(int[] array) {
        var reverse = new int[array.length];
        // copies the array in reverse order to another
        for (int i = 0, j = array.length - 1; i < reverse.length;) {
            reverse[i++] = array[j--];
        }

        return reverse;
    }

    /**
     * The bubble sort algorithm can be optimized by observing that the
     * n-th pass finds the n-th largest element and puts it into its
     * final place. So, the inner loop can avoid looking at the last
     * n − 1 items when running for the n-th time. This method implements
     * this strategy
     *
     * @return int[] array
     * */
    @SuppressWarnings("ConstantConditions")
    private int[] sortV2() {
        int[] array = this.array;

        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    // if the adjacent element is lesser than
                    // the current element then swap them and
                    // remember the changes
                    array = swap(array, i, j);
                    // The bubble sort algorithm can be optimized by observing that the
                    // n-th pass finds the n-th largest element and puts it into its
                    // final place. So, the inner loop can avoid looking at the last
                    // n − 1 items when running for the n-th time - hence the "break;"
                    break;
                }
            }
        }

        // return the same but modified array
        return array;
    }

    /**
     * This method sorts the array with preference of order
     * Also, it uses the honest approach
     *
     * @param descending is the order specification
     * @return int[] array i.e. sorted and the same one but modified
     * */
    @SuppressWarnings("DuplicatedCode")
    public int[] sortV2(boolean descending) {
        // sorted array in ascending order
        int[] array = sortV2();
        if (!descending) {      // if preference is ascending
            return array;
        }

        // return the sorted array reversed
        return reverseArray(array);
    }

    /**
     * This is a fully optimised algorithm of bubble sort
     * Also, it uses honest approach
     *
     * @return int[] array i.e. sorted
     * */
    @SuppressWarnings("ConstantConditions")
    private int[] sortV3() {
        int[] array = this.array;

        for (int i = 0; i < array.length; i++) {
            boolean isSwapped = false;    // it will be reset after every iteration

            for (int j = i + 1; j < array.length - i; j++) {
                if (array[i] > array[j]) {
                    array = swap(array, i, j);
                    // will be set to true if the swap method executes and
                    // if the the adjacent element is greater than the
                    // current element then:
                    isSwapped = true;
                }

                // if there is no element to sort in this iteration
                // then exit the loop and move on to the next element
                if (!isSwapped) {
                    break;
                }
            }
        }

        return array;
    }

    /**
     * This method sorts the array with preference of order
     * Also, uses the optimised honest approach
     *
     * @param descending is the order specification
     * @return int[] array i.e. sorted and the same one but modified
     * */
    public int[] sortV3(boolean descending) {
        int[] array = sortV3();
        if (!descending) {
            return array;
        }

        return reverseArray(array);
    }
}