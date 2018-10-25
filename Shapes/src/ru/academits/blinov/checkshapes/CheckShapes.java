package ru.academits.blinov.checkshapes;

import ru.academits.blinov.shapes.*;
import java.util.Arrays;
import java.util.Comparator;

public class CheckShapes {
    public static Shape findFigureWithMaxArea(Shape... shapes) {
        Comparator<Shape> comparator = Comparator.comparingDouble(Shape::getArea);
        Arrays.sort(shapes, comparator);
        return shapes[shapes.length - 1];
    }

    public static Shape findFigureWithSecondMaxPerimeter(Shape... shapes) {
        Comparator<Shape> comparator = Comparator.comparingDouble(Shape::getPerimeter);
        Arrays.sort(shapes, comparator);
        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape triangle1 = new Triangle(1, 2, 5, 6, 5, 2);
        Shape square1 = new Square(5.0);
        Shape rectangle1 = new Rectangle(5.0, 4.0);
        Shape circle1 = new Circle(4.0);
        Shape square2 = new Square(8.0);

        System.out.println("Наибольшая площадь: " + findFigureWithMaxArea(triangle1, square1, rectangle1, circle1, square2).toString());
        System.out.println("Второй по величине периметр: " + findFigureWithSecondMaxPerimeter(triangle1, square1, rectangle1, circle1, square2).toString());
    }
}