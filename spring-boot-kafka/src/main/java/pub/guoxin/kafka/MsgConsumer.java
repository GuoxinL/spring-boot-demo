package pub.guoxin.kafka;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class MsgConsumer {
    @KafkaListener(topics = {"my-replicated-topic","my-replicated-topic2"})
    public void processMessage(String content) {
        System.out.println(content);
    }
}
