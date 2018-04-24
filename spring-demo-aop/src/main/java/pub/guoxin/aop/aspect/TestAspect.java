package pub.guoxin.aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import pub.guoxin.aop.anno.QueryCache;

import java.lang.reflect.Method;

/**
 * Created by guoxin on 17-11-23.
 */
@Aspect
@Component
public class TestAspect {

    @Pointcut("@annotation(pub.guoxin.aop.anno.QueryCache)")
    public void pointcut(){}

    @Around("pointcut()")
    public Object interceptor(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long beginTime = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) proceedingJoinPoint.getSignature();
        Method method = signature.getMethod(); //被拦截方法
        String namespace = method.getAnnotation(QueryCache.class).namespace();




        return null;
    }
}
