package pub.guoxin.websocket.javax;


import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Create by guoxin on 2018/4/25
 */
public class ServerEncoder<T> implements Encoder.Text<T>{

    @Override
    public String encode(T t) throws EncodeException {
        return JsonUtil.obj2json(t);
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
