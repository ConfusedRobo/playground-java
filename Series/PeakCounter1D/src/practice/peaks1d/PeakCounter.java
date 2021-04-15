package practice.peaks1d;

public class PeakCounter {

    public static void main(String[] args) {
        System.out.println("Test: " + countPeaks(new int[]{7, 4, 5, 4, 7, 4, 6, 5}));
    }

    public static int countPeaks(int[] array) {
        int peakCount = 0;
        var length = array.length;

        if (array[length - 1] >= array[length - 2]) {
            ++peakCount;
        }

        if (array[0] >= array[1]) {
            ++peakCount;
        }

        for (int i = 1; i < length - 1; i++) {
            if (array[i] >= array[i + 1] && array[i] >= array[i - 1]) {
                ++peakCount;
            }
        }
        return peakCount;
    }
}
