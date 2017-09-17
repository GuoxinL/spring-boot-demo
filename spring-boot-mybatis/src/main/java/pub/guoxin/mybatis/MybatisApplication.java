package pub.guoxin.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by guoxin on 17-3-20.
 */
@SpringBootApplication(scanBasePackages = {"pub.guoxin"})
@EnableTransactionManagement //如果mybatis中service实现类中加入事务注解，需要此处添加该注解
@PropertySource({"classpath:application-mybatis.properties"})
public class MybatisApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(MybatisApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(MybatisApplication.class);
    }
}
