package pub.guoxin.aop;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by guoxin on 17-11-24.
 */
public interface CacheEnum<E extends CacheEnum> {

    /**
     * separator
     *
     * This separator is used to split the key string
     */
    String S = "_";

    /**
     * 缓存key参数
     *
     * @param args  有顺序的
     * @return      返回完整key
     */
    String getKey(Object... args);

    String getKeyPattern();
    /**
     * key所属模块名称
     *
     * @return
     */
    String getModuleName();

    /**
     *
     *
     * @return
     */
    String getSuffix();
    /**
     * 获取枚举值对应的枚举
     *
     * @param enumClass
     *            枚举类
     * @param enumValue
     *            枚举值
     * @return 枚举
     */
    static <E extends CacheEnum<E>> E getEnum(final Class<E> enumClass, final Integer enumValue) {
        if (enumValue == null) {
            return null;
        }
        try {
            return valueOf(enumClass, enumValue);
        } catch (final IllegalArgumentException ex) {
            return null;
        }
    }

    /**
     * 获取枚举值对应的枚举
     *
     * @param enumClass
     *            枚举类
     * @param enumValue
     *            枚举值
     * @return 枚举
     */
    static <E extends CacheEnum<E>> E valueOf(Class<E> enumClass, Integer enumValue) {
        if (enumValue == null)
            throw new NullPointerException("EnumValue is null");
        return getEnumMap(enumClass).get(enumValue);
    }

    /**
     * 获取枚举键值对
     *
     * @param enumClass
     *            枚举类型
     * @return 键值对
     */
    static <E extends CacheEnum<E>> Map<String, E> getEnumMap(Class<E> enumClass) {
        E[] enums = enumClass.getEnumConstants();
        if (enums == null)
            throw new IllegalArgumentException(enumClass.getSimpleName() + " does not represent an enum type.");
        Map<String, E> map = new HashMap<>(2 * enums.length);
        for (E t : enums) {
            map.put(t.getKeyPattern(), t);
        }
        return map;
    }
}
