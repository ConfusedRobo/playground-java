package session.testing;

public class Main {

    public static Long[] fibonacciUpto(int length) {
        final double PHI = 0.5 * (1.0 + Math.sqrt(5.0));
        java.util.List<Long> series = new java.util.ArrayList<>(length);

        for (int term = 1; term < length; term++) {
            final long CURRENT_TERM = Math.round((Math.pow(PHI, term) / Math.sqrt(5.0)));
            series.add(CURRENT_TERM);
        }
        return (Long[]) series.toArray();
    }
}
