package marsrover.world

import spock.lang.Specification
import spock.lang.Subject

class GlobeWorldSpec extends Specification {

    @Subject
    def World world = new GlobeWorld()

    def "We always land on 0,51 on a globe world"() {
        when: "We land on the world"
        def point = world.land()

        then: "We are at 0,0"
        point.x == 0
        point.y == 51
    }

    def "Moving north increments the y attribute of a point"() {
        given: "A point in the world"
        def point = new Point(10, 10)

        when: "We're moving north"
        def newPoint = world.toNorth(point)

        then: "We are at 10,11"
        newPoint.x == 10
        newPoint.y == 11
    }

    def "Moving east increments the x attribute of a point"() {
        given: "A point in the world"
        def point = new Point(10, 10)

        when: "We're moving east"
        def newPoint = world.toEast(point)

        then: "We are at 11,10"
        newPoint.x == 11
        newPoint.y == 10
    }

    def "Moving west decrements the x attribute of a point"() {
        given: "A point in the world"
        def point = new Point(10, 10)

        when: "We're moving west"
        def newPoint = world.toWest(point)

        then: "We are at 9,10"
        newPoint.x == 9
        newPoint.y == 10
    }

    def "Moving south decrements the x attribute of a point"() {
        given: "A point in the world"
        def point = new Point(10, 10)

        when: "We're moving south"
        def newPoint = world.toSouth(point)

        then: "We are at 9,10"
        newPoint.x == 10
        newPoint.y == 9
    }

    def "Moving beyond the north pole"() {
        given: "A point in the world"
        def point = new Point(10, GlobeWorld.maxLatitude)

        when: "We're moving north"
        def newPoint = world.toNorth(point)

        then: "The new point is on the other side of the world"
        newPoint.x == -170
        newPoint.y == GlobeWorld.maxLatitude - 1
    }

    def "Moving beyond the north pole a seond time"() {
        given: "A point in the world"
        def point = new Point(-10, GlobeWorld.maxLatitude)

        when: "We're moving north"
        def newPoint = world.toNorth(point)

        then: "The new point is on the other side of the world"
        newPoint.x == 170
        newPoint.y == GlobeWorld.maxLatitude - 1
    }

    def "Moving beyond the south pole"() {
        given: "A point in the world"
        def point = new Point(-50, -GlobeWorld.maxLatitude)

        when: "We're moving south"
        def newPoint = world.toSouth(point)

        then: "The new point is on the other side of the world"
        newPoint.x == 130
        newPoint.y == -GlobeWorld.maxLatitude + 1
    }

    def "Moving beyond the south pole a second time"() {
        given: "A point in the world"
        def point = new Point(50, -GlobeWorld.maxLatitude)

        when: "We're moving south"
        def newPoint = world.toSouth(point)

        then: "The new point is on the other side of the world"
        newPoint.x == -130
        newPoint.y == -GlobeWorld.maxLatitude + 1
    }

    def "Moving east over the date line"() {
        given: "A point in the world"
        def point = new Point(GlobeWorld.maxLongitude, 0)

        when: "We're moving east"
        def newPoint = world.toEast(point)

        then: "The new point is on -179, 0"
        newPoint.x == -179
        newPoint.y == 0
    }

    def "Moving west over the date line"() {
        given: "A point in the world"
        def point = new Point(-GlobeWorld.maxLongitude, 0)

        when: "We're moving east"
        def newPoint = world.toWest(point)

        then: "The new point is on 179, 0"
        newPoint.x == 179
        newPoint.y == 0
    }

    def "Moving east over the zero meridian"() {
        given: "A point in the world"
        def point = new Point(0, 0)

        when: "We're moving east"
        def newPoint = world.toEast(point)

        then: "The new point is on 1, 0"
        newPoint.x == 1
        newPoint.y == 0
    }

    def "Moving west over the zero meridian"() {
        given: "A point in the world"
        def point = new Point(0, 0)

        when: "We're moving east"
        def newPoint = world.toWest(point)

        then: "The new point is on 179, 0"
        newPoint.x == -1
        newPoint.y == 0
    }
}
