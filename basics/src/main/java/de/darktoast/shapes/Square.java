package de.darktoast.shapes;

public class Square implements Shape {
    private final int siteLength;

    public Square(int siteLength) {
        this.siteLength = siteLength;
    }

    public double area() {
        return siteLength * siteLength;
    }

    public double extensive() {
        return siteLength * 4;
    }
}
