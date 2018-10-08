package ru.academits.blinov.shapes;

public class Square implements Shape {
    private double length;

    public Square(double length) {
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
        return "КВАДРАТ (" + "a = " + getHeight() + ", " + "S = " + getArea() + ", " + "P = " + getPerimeter() + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if ((obj == null) || (obj.getClass() != this.getClass())) {
            return false;
        }
        Square square = (Square) obj;
        return length == square.length;
    }

    @Override
    public int hashCode() {
        final int prime = 37;
        int hash = 1;
        hash = prime * hash + Double.hashCode(length);
        return hash;
    }
}