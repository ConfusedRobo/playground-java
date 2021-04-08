package company.test;

public class Main {

    public static void main(String[] args) {
        //Bit negation or, 1's complement.
        System.out.println(Integer.toBinaryString(42));
        System.out.println(Integer.toBinaryString(~42));

        System.out.println(Integer.toBinaryString(10) + "\t" + Integer.toBinaryString(12));

        //AND gate of 1010 and 1100 i.e. 10 and 12.
        System.out.println(Integer.toBinaryString(10 & 12));

        //OR gate of 1010 and 1100 i.e. 10 and 12.
        System.out.println(Integer.toBinaryString(12 | 10));

        //XOR gate of 1010 and 1100 i.e. 10 and 12.
        System.out.println(Integer.toBinaryString(10 ^ 12));

        //Signed left shift: here, it shifts by 3 places.
        System.out.println(Integer.toBinaryString(10 << 3));
        System.out.println(-9 << 3);

        //Signed right shift: here, it shifts by 3 places.
        System.out.println(Integer.toBinaryString(10 >> 3));
        System.out.println(-9 >> 3);

        //Unsigned left shift: here, it shifts by 3 places.
        System.out.println(Integer.toBinaryString(10 >>> 3));
        System.out.println(-9 >>> 3);
    }
}
