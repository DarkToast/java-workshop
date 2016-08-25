package marsrover.world;

/**
 * latitude
 * ^
 * |
 * Y
 * |
 * +----X------> longitude
 */
public class GlobeWorld implements World {
    public static int maxLongitude = 180;
    public static int maxLatitude = 90;

    @Override
    public Point toNorth(Point start) {
        return checkCoordinateOverflow(new Point(start.x, start.y + 1));
    }

    @Override
    public Point toSouth(Point start) {
        return checkCoordinateOverflow(new Point(start.x, start.y - 1));
    }

    @Override
    public Point toWest(Point start) {
        return checkCoordinateOverflow(new Point(start.x - 1, start.y));
    }

    @Override
    public Point toEast(Point start) {
        return checkCoordinateOverflow(new Point(start.x + 1, start.y));
    }

    private Point checkCoordinateOverflow(final Point p) {
        return checkNorthPole(checkSouthPole(checkDateLine(p)));
    }

    private Point checkNorthPole(final Point p) {
        if(p.y > maxLatitude) {
            int latitude = maxLatitude - 1;
            return p.x < 0 ?
                new Point(p.x + maxLongitude, latitude) :
                new Point(p.x - maxLongitude, latitude);
        } else {
            return p;
        }
    }

    private Point checkSouthPole(final Point p) {
        if(p.y < -maxLatitude) {
            int latitude = -maxLatitude + 1;
            return p.x < 0 ?
                    new Point(p.x + maxLongitude, latitude) :
                    new Point(p.x - maxLongitude, latitude);
        } else {
            return p;
        }
    }

    private Point checkDateLine(final Point p) {
        if(p.x < -maxLongitude) {
            return new Point(maxLongitude - 1, p.y);
        } else if(p.x > maxLongitude) {
            return new Point(-maxLongitude + 1, p.y);
        } else {
            return p;
        }
    }

    @Override
    public Point land() {
        return new Point(0, 51);
    }
}
