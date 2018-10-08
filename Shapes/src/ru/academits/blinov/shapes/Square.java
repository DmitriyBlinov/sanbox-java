package ru.academits.blinov.shapes;

public class Square implements Shape{
    private double length;

    public Square (double length) {
        this.length = length;
    }

    public double getPerimeter() {
        return length * 4;
    }

    public double getArea() {
        return Math.pow(length, 2);
    }

    public double getWidth() {
        return length;
    }
    public double getHeight() {
        return length;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("КВАДРАТ (")
                .append("a = " + getHeight() + ", ")
                .append("S = " + getArea() + ", ")
                .append("P = " + getPerimeter() + ")");

        return stringBuilder.toString();
    }
}
