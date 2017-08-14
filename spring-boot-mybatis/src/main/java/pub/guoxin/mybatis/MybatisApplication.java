package pub.guoxin.mybatis;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Created by guoxin on 17-3-20.
 */
@SpringBootApplication
@ComponentScan("pub.guoxin")
@MapperScan(basePackages = "pub.guoxin")
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
