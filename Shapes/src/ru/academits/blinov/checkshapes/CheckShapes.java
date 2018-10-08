package ru.academits.blinov.checkshapes;

import ru.academits.blinov.shapes.*;

import java.util.Arrays;
import java.util.Comparator;

public class CheckShapes {
    public static Shape findMaxArea(Shape... shapes) {
        Comparator<Shape> comparator = Comparator.comparingDouble(Shape::getArea);
        Arrays.sort(shapes, comparator);
        return shapes[shapes.length - 1];
    }

    public static Shape findSecondMaxPerimeter(Shape... shapes) {
        Comparator<Shape> comparator = Comparator.comparingDouble(Shape::getPerimeter);
        Arrays.sort(shapes, comparator);
        return shapes[shapes.length - 2];
    }

    public static void main(String[] args) {
        Shape triangle1 = new Triangle(1,2,5,6,5,2);
        Shape square1 = new Square(5.0);
        Shape rectangle1 = new Rectangle(5.0,4.0);
        Shape circle1 = new Circle(4.0);
        Shape square2 = new Square(8.0);

        System.out.println("Фигура с наибольшей площадью: " + findMaxArea(triangle1, square1, rectangle1, circle1, square2).toString());
        System.out.println("Фигура со 2-м по величине периметром: " + findSecondMaxPerimeter(triangle1, square1, rectangle1, circle1, square2).toString());
    }
}
