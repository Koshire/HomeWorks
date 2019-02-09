package Geometry;

public class Triangle extends Figure implements TriangleType {

    private double a;
    private double b;
    private double c;

    public Triangle(Point firstPoint, Point secondPoint, Point thirdPoint) {
        super(firstPoint, secondPoint, thirdPoint);
        a = firstPoint.distance(secondPoint);
        b = secondPoint.distance(thirdPoint);
        c = thirdPoint.distance(firstPoint);
        this.setCounterHightPoints(3);
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double getC() {
        return c;
    }

    @Override
    public double figurePerimetr() {
        return a + b + c;
    }

    @Override
    public double figureSquare() {
        double halfPerimetr = figurePerimetr() / 2;
        return Math.sqrt(halfPerimetr * (halfPerimetr - a) * (halfPerimetr - b) * (halfPerimetr - c));
    }

    @Override
    public double triangleHight(double side) {
        return 2 * figureSquare() / side;
    }

    @Override
    public boolean isEquilateral() {
        return a == b && b == c;
    }

    @Override
    public boolean isTrueTriangle() {
        return this.getA() < this.getB() + this.getC() ||
                this.getB() < this.getA() + this.getC() ||
                this.getC() < this.getA() + this.getB() ||
                this.getC() == this.getB() && this.getB() == this.getA();
    }

    @Override
    public String toString() {
        String result = String.format("Стороны треугольника равны : %.2f, %.2f, %.2f, площадь = %.2f, периметр = %.2f"
                , a, b, c, this.figureSquare(), this.figurePerimetr());
        return isTrueTriangle() ? result : "Это не треугольник";
    }
}
