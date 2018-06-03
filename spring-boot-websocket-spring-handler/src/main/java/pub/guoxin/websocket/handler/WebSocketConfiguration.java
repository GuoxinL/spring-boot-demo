package pub.guoxin.websocket.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

/**
 * Create by guoxin on 2018/5/11
 */
@Configuration
public class WebSocketConfiguration implements WebSocketConfigurer {

    @Autowired
    private EchoWebSocketHandler echoWebSocketHandler;

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(echoWebSocketHandler, "/echo").withSockJS();
    }
}
