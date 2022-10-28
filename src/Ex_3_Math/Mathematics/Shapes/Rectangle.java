package Ex_3_Math.Mathematics.Shapes;

import Ex_3_Math.Mathematics.Exceptions.UnacceptableValueException;

public class Rectangle extends Shape {
    private double width;
    private double height;

    public static Rectangle create(double width, double height, String name) throws UnacceptableValueException {
        // ToDo
        // ???
        if (width < 0 || height < 0)
            throw new UnacceptableValueException("width or heignt < 0");
        var instance = new Rectangle();
        instance.name = name;
        instance.width = width;
        instance.height = height;
        return instance;
    }

    private Rectangle() {}

    @Override
    public double getArea() {
        return this.width * this.height;
    }

    @Override
    public String toString() {
        // ??
        return String.format("Name: %s, width: %f, height: %f", name, width, height);
    }
}
