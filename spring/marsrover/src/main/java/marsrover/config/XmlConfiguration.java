package marsrover.config;

import marsrover.rover.Rover;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class XmlConfiguration implements RoverConfig {
    @Override
    public Rover buildRover() {
        ApplicationContext applicationContext =
                new ClassPathXmlApplicationContext("/context.xml");

        return applicationContext.getBean(Rover.class);
    }
}
