package pub.guoxin.aop.anno;

import java.lang.annotation.*;

/**
 * Created by guoxin on 17-11-24.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER})
@Documented
public @interface QueryCacheKey {
}
