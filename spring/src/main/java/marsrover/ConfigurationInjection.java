package marsrover;

import marsrover.rover.Rover;
import marsrover.rover.SlowRover;
import marsrover.world.FlatWorld;
import marsrover.world.GlobeWorld;
import marsrover.world.World;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigurationInjection {

    public static void main(String[] args) {
        System.out.println(
            new ConfigurationInjection().buildRover()
                .moveForward()
                .turnLeft()
                .moveForward()
                .getActualPosition().toString()
        );
    }

    public Rover buildRover() {
        ApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(RoverConfig.class);

        return applicationContext.getBean(Rover.class);
    }

    @Configuration
    static class RoverConfig {
        @Bean(name = "flatWorld")
        World flatWorld() {
            return new FlatWorld();
        }

        @Bean(name = "globeWorld")
        World globeWorld() {
            return new GlobeWorld();
        }

        @Bean(name = "rover")
        Rover rover(@Autowired @Qualifier("globeWorld") World world) {
            return new SlowRover(world);
        }
    }
}
