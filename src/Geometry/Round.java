package Geometry;

public class Round extends Figure {

    private double radius;

    public Round(Point firstPoint, Point secondPoint) {
        super(firstPoint, secondPoint);
        radius = firstPoint.distance(secondPoint);
        this.setCounterHightPoints(0);
    }

    @Override
    public double figurePerimetr() {
        return 2 * Math.PI * radius;
    }

    @Override
    public double figureSquare() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getDiametr() {
        return radius * 2;
    }

    public double getRadius() {
        return radius;
    }

    @Override
    public String toString() {
        return String.format("Круг радиус которого : %.2f, в точке с координатами: х= %d, y=%d," +
                        " площадь = y=%.2f, периметр = %.2f", radius, getFirstPoint().getxCoordinate(),
                getFirstPoint().getyCoordinate(), this.figureSquare(), this.figurePerimetr());
    }
}
