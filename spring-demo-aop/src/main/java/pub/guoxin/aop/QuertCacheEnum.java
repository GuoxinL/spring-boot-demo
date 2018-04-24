package pub.guoxin.aop;

/**
 * Created by guoxin on 17-11-24.
 */
public enum QuertCacheEnum implements CacheEnum {
    DEMO {
        @Override
        public String getKey(Object... args) {
            StringBuffer buffer = new StringBuffer(getKeyPattern());
            for (Object obj : args) {
                buffer.append(S);
                buffer.append(obj.toString());
            }
            return buffer.toString();
        }

        @Override
        public String getKeyPattern() {
            return null;
        }

        @Override
        public String getModuleName() {
            return getModuleName() + S + getSuffix();
        }

        @Override
        public String getSuffix() {
            return null;
        }
    };

}
