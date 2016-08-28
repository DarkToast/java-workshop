package marsrover.world;

public interface World {
    Point toNorth(Point start);
    Point toSouth(Point start);
    Point toWest(Point start);
    Point toEast(Point start);

    Point land();
}
