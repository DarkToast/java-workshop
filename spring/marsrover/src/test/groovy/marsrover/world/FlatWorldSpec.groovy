package marsrover.world

import spock.lang.Specification
import spock.lang.Subject

class FlatWorldSpec extends Specification {

    @Subject
    def world = new FlatWorld()

    def "We always land on 0,0 on a flat world"() {
        when: "We land on the world"
        def point = world.land()

        then: "We are at 0,0"
        point.x == 0
        point.y == 0
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

    def "Moving too far north and we fell off the world"() {
        given: "A point in the world"
        def point = new Point(10, FlatWorld.maxY)

        when: "We're moving north"
        world.toNorth(point)

        then: "We expect an illegal state exception"
        thrown(IllegalStateException)
    }

    def "Moving too far south and we fell off the world"() {
        given: "A point in the world"
        def point = new Point(10, -FlatWorld.maxY)

        when: "We're moving south"
        world.toSouth(point)

        then: "We expect an illegal state exception"
        thrown(IllegalStateException)
    }

    def "Moving too far east and we fell off the world"() {
        given: "A point in the world"
        def point = new Point(FlatWorld.maxY, 0)

        when: "We're moving east"
        world.toEast(point)

        then: "We expect an illegal state exception"
        thrown(IllegalStateException)
    }

    def "Moving too far west and we fell off the world"() {
        given: "A point in the world"
        def point = new Point(-FlatWorld.maxY, 0)

        when: "We're moving west"
        world.toWest(point)

        then: "We expect an illegal state exception"
        thrown(IllegalStateException)
    }
}
