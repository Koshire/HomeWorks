package lesson6;

public class Rectangle {
    private Point pointLeftUp;
    private Point pointRightDown;
    private int rectangleLength;
    private int rectangleWidth;

    public Rectangle(Point pointLeftUp, Point pointRightDown) {
        this.pointLeftUp = pointLeftUp;
        this.pointRightDown = pointRightDown;
        this.rectangleLength = pointLeftUp.getLenthToPoint(pointRightDown);
        this.rectangleWidth = pointLeftUp.getWidthToPoint(pointRightDown);
    }

    public int rectangleSquare() {
        return rectangleLength * rectangleWidth;
    }

    public double rectangleDiagonal() {
        return pointLeftUp.distance(pointRightDown);
    }
}
