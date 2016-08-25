package marsrover;

import marsrover.rover.FastRover;
import marsrover.rover.Rover;
import marsrover.world.GlobeWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlInjection {
    public static void main(String[] args) {
        System.out.println(
            new XmlInjection().buildRover()
                .moveForward()
                .turnLeft()
                .moveForward()
                .getActualPosition().toString()
        );
    }

    public Rover buildRover() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/context.xml");

        return applicationContext.getBean(Rover.class);
    }
}
