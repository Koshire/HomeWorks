package Geometry;

public abstract class Figure implements FigureUtils {
    private Point firstPoint;
    private Point secondPoint;
    private Point thirdPoint;
    private int counterHightPoints;

    public Figure(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        counterHightPoints = 2;
    }

    public Figure(Point firstPoint, Point secondPoint, Point thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
        counterHightPoints = 3;
    }

    public Point getFirstPoint() {
        return firstPoint;
    }

    public Point getSecondPoint() {
        return secondPoint;
    }

    public Point getThirdPoint() {
        return thirdPoint;
    }

    public abstract double figurePerimetr();

    boolean isCompareSquare(Figure figure) {
        return this.figureSquare() == figure.figureSquare();
    }

    public void setCounterHightPoints(int counterHightPoints) {
        this.counterHightPoints = counterHightPoints;
    }

    public int getCounterHightPoints() {
        return counterHightPoints;
    }
}
