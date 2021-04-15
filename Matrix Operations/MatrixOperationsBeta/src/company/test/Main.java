package company.test;

public class Main {

    public static void main(String[] args) {
        Matrix matrixA = new Matrix(2, 2);
        Matrix matrixB = new Matrix(2, 2);

        System.out.println("Matrix - A");
        matrixA.setValues();
        System.out.println(matrixA);

        System.out.println("Matrix - B");
        matrixB.setValues();
        System.out.println(matrixB);

        matrixA.add(matrixB);
    }
}
