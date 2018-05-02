package pub.guoxin.websocket.spring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
public class GreetingController {

    @Autowired
    private SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Runnable runnable = () -> {
            do {
                try {
                    Thread.sleep(1000); // simulated delay
                } catch (InterruptedException ignored) {
                }
                log.info("for log /topic/greetings");
                messagingTemplate.convertAndSend("/topic/greetings", new Greeting("Hello, " + message.getName() + "!"));
            } while (true);
        };
        runnable.run();
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + message.getName() + "!");

    }


}
