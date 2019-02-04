package lesson6;

public class HomeWork6Task1 {

    public static void main(String[] args) {
        Point valuePoint1 = new Point(2, -7);
        Point valuePoint2 = new Point(5, 1);
        System.out.printf("Дистанция от точки 1 до точки 2, равна : %.2f \n", valuePoint1.distance(valuePoint2));

        Rectangle testRectangle = new Rectangle(valuePoint1, valuePoint2);
        System.out.printf("Площадь прямоугольника равна : %d \n", testRectangle.rectangleSquare());
        System.out.printf("Длина диагонали прямоугольника : %.2f \n", testRectangle.rectangleDiagonal());
    }
}
