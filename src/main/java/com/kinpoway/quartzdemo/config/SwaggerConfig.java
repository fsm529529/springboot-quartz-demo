package com.kinpoway.quartzdemo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig implements WebMvcConfigurer {

    @Value("${server.port}")
    private String serverPort;

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("业务模块")
                .apiInfo(apiInfo())
                .select()
                //.apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))//这里采用包含注解的方式来确定要显示的接口
                //这里采用包扫描的方式来确定要显示的接口
                .apis(RequestHandlerSelectors.basePackage("com.kinpoway.quartzdemo.cotroller"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("QuartzDemo")
                .description("API文档")
                .termsOfServiceUrl("http://localhost:" + serverPort + "/swagger-ui.html#/")
                .contact(new Contact("金普威", "http://www.kinpoway.com", ""))
                .version("2.0")
                .build();
    }

}