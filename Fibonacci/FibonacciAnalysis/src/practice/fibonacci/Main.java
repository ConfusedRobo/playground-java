package practice.fibonacci;

public class Main {

    public static long fibExponential(int term) {
        return term == 0 || term == 1 ? term : fibExponential(term - 1) + fibExponential(term - 2);
    }

    public static long fibLinear(int n) {
        if (n == 0) return 0;

        long[] f = new long[n + 1];
        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i <= n; i++) f[i] = f[i - 1] + f[i - 2];
        return f[n];
    }
}
