package pub.guoxin.mongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by guoxin on 17-8-12.
 */
@SpringBootApplication
@ComponentScan("pub.guoxin")
public class MongoApplication {
    public static void main(String[] args) {
        SpringApplication.run(MongoApplication.class, args);

    }
}
