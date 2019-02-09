package Geometry;

public class StartMe {

    public static void main(String[] args) {

        Point p1 = new Point(0, 0);
        Point p2 = new Point(5, 5);
        Point p3 = new Point(5, 0);
        Point p4 = new Point(0, 5);

        Triangle triangle = new Triangle(p1, p2, p4);
        Ellipse ellips = new Ellipse(p1, p2, 2);
        Rectangle rectangle = new Rectangle(p1, p2);
        Round round = new Round(p1, p2);

        System.out.println(ShapeUtils.isRound(round) ? round.toString() : "Фигура не круг.");
        System.out.println(ShapeUtils.isTriangle(triangle) ? triangle.toString() : "Фигура не треугольник.");
        System.out.println(ShapeUtils.isEllips(ellips) ? ellips.toString() : "Фигура не эллипс.");
        System.out.println(ShapeUtils.isRectangle(rectangle) ? rectangle.toString() : "Фигура не прямоугольник.");


    }
}
