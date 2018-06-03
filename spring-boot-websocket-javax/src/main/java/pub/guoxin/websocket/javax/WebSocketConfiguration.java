package pub.guoxin.websocket.javax;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;
/**
 * Create by guoxin on 2018/4/28
 */
@Configuration
public class WebSocketConfiguration {
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
    // https://jira.spring.io/browse/SPR-12340
    @Bean
    public ServletContextAware endpointExporterInitializer(final ApplicationContext applicationContext) {
        return servletContext -> {
            ServerEndpointExporter exporter = new ServerEndpointExporter();
            exporter.setApplicationContext(applicationContext);
            exporter.afterPropertiesSet();
        };
    }

}