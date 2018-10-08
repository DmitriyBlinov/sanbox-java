package ru.academits.blinov.shapes;

public class Circle implements Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getWidth() {
        return radius * 2;
    }

    public double getHeight() {
        return radius * 2;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("КРУГ (")
                .append("d = " + getWidth() + ", ")
                .append("S = " + getArea() + ", ")
                .append("P = " + getPerimeter() + ")");

        return stringBuilder.toString();
    }
}
