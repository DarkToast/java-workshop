package marsrover.world;

/**
 * ^
 * |
 * Y
 * |
 * +----X------>
 */
public class FlatWorld implements World {
    public static int maxX = 40;
    public static int maxY = 40;

    @Override
    public Point toNorth(Point start) {
        return checkWorldBorders(new Point(start.x, start.y + 1));
    }

    @Override
    public Point toSouth(Point start) {
        return checkWorldBorders(new Point(start.x, start.y - 1));
    }

    @Override
    public Point toWest(Point start) {
        return checkWorldBorders(new Point(start.x - 1, start.y));
    }

    @Override
    public Point toEast(Point start) {
        return checkWorldBorders(new Point(start.x + 1, start.y));
    }

    private Point checkWorldBorders(final Point p) {
        if(Math.abs(p.x) > maxX || Math.abs(p.y) > maxY) {
            throw new IllegalStateException("Ouh oh! We fell down the world.");
        } else {
            return p;
        }
    }

    @Override
    public Point land() {
        return new Point(0, 0);
    }
}
