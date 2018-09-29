package com.hzgc.collect.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.hzgc"))
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
<<<<<<< HEAD
                .title("大数据FTP服务接口文档")
=======
                .title("大数据采集服务及人、车、脸属性相关服务接口文档")
>>>>>>> 6b7470c514cfa7a76ee08f7c5a5a76171b8e8094
                .version(getApplicationVersion())
                .build();
    }

    private String getApplicationVersion() {
        Package pkg = SwaggerConfig.class.getPackage();
        return (pkg.getImplementationVersion() != null ? pkg.getImplementationVersion() : "unknow");
    }
}
