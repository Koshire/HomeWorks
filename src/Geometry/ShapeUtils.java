package Geometry;

public class ShapeUtils {

    Figure figure;

    public ShapeUtils(Figure figure) {
        this.figure = figure;
    }

    public static boolean isRectangle(Figure rectangle) {
        return rectangle.getCounterHightPoints() == 4 && ((Rectangle) rectangle).isTrueRectangle();
    }

    public static boolean isTriangle(Figure triangle) {
        return triangle.getCounterHightPoints() == 3 && ((Triangle) triangle).isTrueTriangle();
    }

    public static boolean isRound(Figure round) {
        return round.getCounterHightPoints() == 0;
    }

    public static boolean isEllips(Figure ellips) {
        return ellips.getCounterHightPoints() == 1;
    }

}
