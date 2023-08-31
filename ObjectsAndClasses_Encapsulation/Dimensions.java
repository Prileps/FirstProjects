package ObjectsAndClasses_Encapsulation;

public class Dimensions {
    private final double width;
    private final double length;
    private final double height;


    public Dimensions setWidth(double width) {
        return new Dimensions(width, length, height);
    }

    public Dimensions setLength(double length) {
        return new Dimensions(width, length, height);
    }

    public Dimensions setHeight(double height) {
        return new Dimensions(width, length, height);
    }


    public double getWidth() {
        return width;
    }

    public double getLength() {
        return length;
    }

    public double getHeight() {
        return height;
    }


    public Dimensions(double width, double length, double height) {
        this.width = width;
        this.length = length;
        this.height = height;
    }

    public double volume() {
        return (width * length * height);
    }

    public String toString() {
        return (width + "*" + length + "*" + height);
    }

}
