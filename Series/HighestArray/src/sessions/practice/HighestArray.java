package sessions.practice;

import java.util.Arrays;

public class HighestArray {

    public static void main(String[] args) {
        System.out.println(isHighAll(new int[]{1, 2, 3, 4, 5}, new int[]{1, 2, 3, 6, 7}));
        System.out.println(isHighAll(new int[]{1, 2, 3, 6, 7}, new int[]{1, 2, 3, 4, 5}));
        System.out.println(isHighAll(new int[]{1, 8, 3, 4, 5}, new int[]{1, 2, 3, 9, 7}));
    }

    public static boolean isHighAll(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        return compareLastTwo(a, b) || compareLastTwo(b, a);
    }

    public static boolean compareLastTwo(int[] a, int[] b) {
        var isN1Greater = b[b.length - 1] > a[a.length - 1] && b[b.length - 1] > a[a.length - 2];
        var isN2Greater = b[b.length - 2] > a[a.length - 1] && b[b.length - 2] > a[a.length - 2];
        return isN1Greater && isN2Greater;
    }
}
