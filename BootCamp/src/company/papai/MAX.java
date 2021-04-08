package company.papai;

public class MAX extends NSS {
    private int max;

    MAX() {
        max = 18;
    }

    public int output() {
        for (int i = 0; i <= 50; i++) {
            if (max < getAge()[i] && getAge()[i] < 23) {
                max = getAge()[i];
            }
        }

        return max;
    }
}
