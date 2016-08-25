package de.darktoast

import de.darktoast.shapes.Square
import spock.lang.Specification
import spock.lang.Unroll

class SquareSpec extends Specification {
    def "A square's extensive is four times of its side"() {
        given: "A square with a side length of 4"
        def square =  Mock(Square)

        when: "We calculate the extensive"
        double extensive = square.extensive()

        then: "We get the extensive amount of 16"
        extensive == 16.0D

        and: "the mock was called one time"
        1 * square.extensive() >> 16
    }

    @Unroll
    def "A square's area its side length (#side) high two"() {
        given: "A square with a side length of 4"
        def square = new Square(side)

        when: "We calculate the area"
        double area = square.area()

        then: "We get the extensive amount of 16"
        area == expectedArea

        where:
        side    |   expectedArea
        5       |   25.0
        12      |   144.0
    }

}