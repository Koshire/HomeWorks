package Geometry;

public class Rectangle extends Figure implements RectangleType {

    private int rectangleLength;
    private int rectangleWidth;

    public Rectangle(Point firstPoint, Point secondPoint) {
        super(firstPoint, secondPoint);
        this.rectangleLength = firstPoint.getLenthToPoint(secondPoint);
        this.rectangleWidth = firstPoint.getWidthToPoint(secondPoint);
        this.setCounterHightPoints(4);
    }

    public double rectangleDiagonal() {
        return getFirstPoint().distance(getSecondPoint());
    }

    public int getRectangleLength() {
        return rectangleLength;
    }

    public int getRectangleWidth() {
        return rectangleWidth;
    }

    @Override
    public double figureSquare() {
        return rectangleWidth * rectangleWidth;
    }

    @Override
    public double figurePerimetr() {
        return (rectangleWidth + rectangleWidth) * 2;
    }

    @Override
    public boolean isQudrant() {
        return rectangleLength == rectangleWidth;
    }

    @Override
    public boolean isTrueRectangle() {
        return this.getRectangleWidth() != 0 && this.getRectangleLength() != 0;
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник со сторонами длиной : a = %d, b = %d, площадь = %.2f, периметр = %.2f",
                rectangleWidth, rectangleLength, this.figureSquare(), this.figurePerimetr());
    }
}
