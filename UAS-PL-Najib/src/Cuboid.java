public class Cuboid {
    private double length;
    private double width;
    private double height;

    public Cuboid(double length, double width, double height) {
        this.length = length;
        this.width = width;
        this.height = height;
    }

    public double getVolume() {
        return length * width * height;
    }

    public double getSurfaceArea() {
        return 2 * (length * width + width * height + height * length);
    }

    @Override
    public String toString() {
        return "Cuboid [length=" + length + ", width=" + width + ", height=" + height +
                ", volume=" + getVolume() + ", surfaceArea=" + getSurfaceArea() + "]";
    }
}
