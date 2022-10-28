package Ex_3_Math.Mathematics.Shapes;

import Ex_3_Math.Mathematics.Exceptions.UnacceptableValueException;

public class Circle extends Shape {
    public static Circle create(double radius, String name) throws UnacceptableValueException {
        // ToDo
        // ???
        if (radius < 0)
            throw new UnacceptableValueException("radius < 0");

        var instance = new Circle();
        instance.name = name;
        instance.radius = radius;
        return instance;
    }

    public double radius;

    private Circle() {}

    public double getRadius() {
        return radius;
    }

    @Override
    public double getArea() {
        return Math.pow(radius, 2) * Math.PI;
    }
}
