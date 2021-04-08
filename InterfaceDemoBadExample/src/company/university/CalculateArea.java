package company.university;

/**
 * @author ConfusedRobo
 * Dated: 11-09-2020
 * Do not modify.
 */
public class CalculateArea implements Circle, Triangle, Rectangle, Square {
    private double area;

    @Override
    public double getCircleArea(double radius) {
        setArea(Math.PI * Math.pow(radius, 2));
        return area;
    }

    @Override
    public double getRectangleArea(double length, double breath) {
        setArea(length * breath);
        return area;
    }

    @Override
    public double getSquareArea(double sideA, double sideB) {
        setArea(sideA * sideB);
        return area;
    }

    @Override
    public double getTriangleArea(double base, double height) {
        setArea(0.5 * base * height);
        return area;
    }

    @Override
    public void setArea(double area) {
        this.area = area;
    }
}
