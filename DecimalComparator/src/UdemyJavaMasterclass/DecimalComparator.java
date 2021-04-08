package UdemyJavaMasterclass;

public class DecimalComparator {

    public static boolean areEqualByThreeDecimalPlaces(double decimalVarA, double decimalVarB) {

        return (int)(decimalVarA * 1000) == (int)(decimalVarB * 1000);

    }

}
