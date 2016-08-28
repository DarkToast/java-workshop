package marsrover.world;

public class Point {
    public final int x;
    public final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        final String longitude = x < 0 ? (x * (-1)) + "° W" : x + "° E";
        final String latitude  = y < 0 ? (y * (-1)) + "° S" : y + "° N";

        return "(" + longitude + ", " + latitude + ")";
    }
}
