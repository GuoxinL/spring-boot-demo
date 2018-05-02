package pub.guoxin.websocket.javax;

import com.fasterxml.jackson.core.type.TypeReference;

import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.lang.reflect.Type;

/**
 * Create by guoxin on 2018/4/25
 */
public class ServerDecoder<T> implements Decoder.Text<T>{

    @Override
    public T decode(String s) throws DecodeException {
        return JsonUtil.json2obj(s, new TypeReference<T>() {
            @Override
            public Type getType() {
                return super.getType();
            }
        });
    }

    @Override
    public boolean willDecode(String s) {
        return false;
    }

    @Override
    public void init(EndpointConfig endpointConfig) {

    }

    @Override
    public void destroy() {

    }
}
