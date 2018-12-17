package pub.guoxin.websocket.javax;

import org.springframework.beans.factory.BeanFactory;

import javax.websocket.server.ServerEndpointConfig;

/**
 * java.lang.IllegalStateException: Failed to find the root WebApplicationContext. Was ContextLoaderListener not used?
 * https://stackoverflow.com/questions/30483094/springboot-serverendpoint-failed-to-find-the-root-webapplicationcontext
 *
 * Create by guoxin on 2018/5/3
 */
public class CustomSpringConfigurator extends ServerEndpointConfig.Configurator {

    /**
     * Spring application context.
     */
    private static volatile BeanFactory context = ApplicationContextUtil.getApplicationContext();

    @Override
    public <T> T getEndpointInstance(Class<T> clazz) {
        return context.getBean(clazz);
    }

}