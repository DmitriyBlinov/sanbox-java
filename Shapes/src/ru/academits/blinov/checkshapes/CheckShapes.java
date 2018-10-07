package ru.academits.blinov.checkshapes;

import ru.academits.blinov.shapes.*;

public class CheckShapes {
    public static Shape findMaxShape (Shape... shapes) {
        int maxShapeIndex = 0;
        for (int i = 0; i < shapes.length - 1; i++) {
            if (shapes[i].getArea() > shapes[i + 1].getArea()) {
                maxShapeIndex = i;
            }
        }
        return shapes[maxShapeIndex];
    }

    public static Shape findSecondMaxShape (Shape... shapes) {
        Shape maxShape = findMaxShape(shapes);
        int secondMaxShape = 0;
        for (int i = 0; i < shapes.length - 1; i++) {
            if ((shapes[i].getArea() > shapes[i + 1].getArea()) && (shapes[i].getArea() < maxShape.getArea())) {
                secondMaxShape = i;
            }
        }
        return shapes[secondMaxShape];
    }

    public static void main(String[] args) {
        Shape triangle1 = new Triangle(1,2,5,6,5,2);
        Shape square1 = new Square(5.0);
        Shape rectangle1 = new Rectangle(5.0,4.0);
        Shape circle1 = new Circle(5.0);
        Shape square2 = new Square(8.0);

    }
}
