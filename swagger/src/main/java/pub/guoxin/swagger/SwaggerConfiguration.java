package pub.guoxin.swagger;

import com.google.common.base.Predicate;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.BasicErrorController;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by guoxin on 17-4-12.
 */
@Configuration
@EnableSwagger2
@EnableAutoConfiguration
public class SwaggerConfiguration extends WebMvcConfigurerAdapter {
    @Bean
    public Docket createRestApi() {
        Predicate<RequestHandler> predicate = new Predicate<RequestHandler>() {
            @Override
            public boolean apply(RequestHandler input) {
                Class<?> declaringClass = input.declaringClass();
                if (declaringClass == BasicErrorController.class)// 排除
                    return false;
                if (declaringClass.isAnnotationPresent(RestController.class)) // 被注解的类
                    return true;
                if (input.isAnnotatedWith(ResponseBody.class)) // 被注解的方法
                    return true;
                return false;
            }
        };
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
                .apis(predicate)
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("包含媒体、咨询、搜索引擎关键字、广告等类型接口的服务")//大标题
                .version("1.0")//版本
                .build();
    }

//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(PathSelectors.any())
//                .build();
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("Guoxin Spring Boot Demo")
//                .description("Guoxin Spring Boot Demo")
//                .termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
//                .license("Apache License Version 2.0")
//                .licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE")
//                .version("2.0")
//                .build();
//    }
}
