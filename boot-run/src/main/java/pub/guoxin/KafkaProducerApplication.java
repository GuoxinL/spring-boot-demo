package pub.guoxin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import pub.guoxin.kafka.MsgConsumer;
import pub.guoxin.kafka.MsgProducer;

@SpringBootApplication
public class KafkaProducerApplication {

    public static void main(String[] args) throws InterruptedException {
        ApplicationContext applicationContext = SpringApplication.run(KafkaProducerApplication.class, args);
        MsgProducer producer = applicationContext.getBean(MsgProducer.class);
        MsgConsumer consumer = applicationContext.getBean(MsgConsumer.class);
        while (true) {
            producer.send();
            Thread.sleep(10000);
        }
    }
}
