package pub.guoxin.websocket.javax;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

/**
 * Create by guoxin on 2018/4/25
 */
public class JsonUtil {
    private static final ObjectMapper OBJECT_MAPPER;

    static {
        OBJECT_MAPPER = new ObjectMapper();
    }

    private JsonUtil() {
    }

    /**
     *
     * @param json  JSON 字符串
     * @param clazz 需要转换的类型
     * @return 类型对象
     */
    public static <T> T json2obj(String json, Class<T> clazz) {
        T obj = null;
        try {
            obj = OBJECT_MAPPER.readValue(json, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T> T json2obj(String json, TypeReference<T> typeReference) {
        T obj = null;
        try {
            obj = OBJECT_MAPPER.readValue(json, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return obj;
    }

    public static <T> String obj2json(T obj) {
        String json = null;
        try {
            json = OBJECT_MAPPER.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return json;
    }
}
