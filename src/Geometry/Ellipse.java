package Geometry;

public class Ellipse extends Round {

    private double halfAxis1;
    private double halfAxis2;

    public Ellipse(Point firstPoint, Point secondPoint, double halfAxis1) {
        super(firstPoint, secondPoint);
        this.halfAxis1 = halfAxis1;
        halfAxis2 = firstPoint.distance(secondPoint);
        setCounterHightPoints(1);
    }

    @Override
    public double figureSquare() {
        return 2 * Math.PI * halfAxis1 * halfAxis2;
    }

    @Override
    public double figurePerimetr() {
        return 2 * Math.PI * Math.sqrt((Math.pow(halfAxis1, 2) + Math.pow(halfAxis2, 2)) / 2);
    }


    @Override
    public String toString() {
        return String.format("Эллипс, полуоси которого рывны %.2f и %.2f, в точке с координатами: х= %d" +
                        ", y= %d, площадь = %.2f, периметр = %.2f", halfAxis1, halfAxis2, getFirstPoint().getxCoordinate(),
                getFirstPoint().getyCoordinate(), this.figureSquare(), this.figurePerimetr());
    }
}
