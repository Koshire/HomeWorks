package lesson6;

public class Point {

    private int xCoordinate;
    private int yCoordinate;

    public Point(int xCoordinate, int yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public int getLenthToPoint(Point point) {
        return Math.abs(baseLenth(xCoordinate) - baseLenth(point.getxCoordinate()));
    }

    public int getWidthToPoint(Point point) {
        return Math.abs(baseLenth(yCoordinate) - baseLenth(point.getyCoordinate()));
    }

    public double distance(Point point) {
        return Math.sqrt(Math.pow(getLenthToPoint(point), 2) +
                         Math.pow(getWidthToPoint(point), 2));
    }

    private int baseLenth(int anyCoordinate) {
        return 0 - anyCoordinate;
    }
}
