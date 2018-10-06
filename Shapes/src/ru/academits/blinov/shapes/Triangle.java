package ru.academits.blinov.shapes;

public class Triangle implements Shape{
    private double x1;
    private double x2;
    private double y1;
    private double y2;
    private double x3;
    private double y3;

    public Triangle(double x1, double y1, double x2, double y2, double x3, double y3) {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.x3 = x3;
        this.y3 = y3;
    }

    public double getWidth() {
        return Math.max(Math.max(x1, x2), x3) - Math.min(Math.min(x1, x2), x3);
    }

    public double getHeight() {
        return Math.max(Math.max(y1, y2), y3) - Math.min(Math.min(y1, y2), y3);
    }

    public double getArea() {
        double lengthAB = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double lengthBC = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double lengthAC = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        double p = (lengthAB + lengthBC + lengthAC) / 2;

        return Math.sqrt(p * (p - lengthAB) * (p - lengthBC) * (p - lengthAC));
    }

    public double getPerimeter () {
        double lengthAB = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double lengthBC = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));
        double lengthAC = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

        return lengthAB + lengthBC + lengthAC;
    }
}