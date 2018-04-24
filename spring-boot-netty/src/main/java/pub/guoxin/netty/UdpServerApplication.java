package pub.guoxin.netty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by guoxin on 17-10-11.
 */
@SpringBootApplication
public class UdpServerApplication {

    public static void main(String[] args) throws Exception {
        SpringApplication application = new SpringApplication(UdpServerApplication.class);
        application.setWebEnvironment(false);
        application.run(args);
    }

}
