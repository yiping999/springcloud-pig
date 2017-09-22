package com.piggymetrics.user;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.google.common.base.Predicates;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 
 * @Title: Swagger设置类
 * @Package com.lovnx.charge 
 * @author yezhiyuan   
 * @date 2017年5月10日 上午9:45:55 
 * @version V1.0
 */
@Configuration  
@ComponentScan(basePackages = { "com.piggymetrics.user.controller.*" })//配置controller路径
@EnableSwagger2
@SuppressWarnings({"unchecked","deprecation"})
public class Swagger2 {  

    @Bean  
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)  
                .apiInfo(apiInfo())  
                .select()
                .paths(Predicates.or(
                //这里添加你需要展示的接口
                        PathSelectors.ant("/users/**"),
                        PathSelectors.ant("/xxx/**"),
                        PathSelectors.ant("/qqq/**"),
                        PathSelectors.ant("/eee/**")
                                    )
                        )
                .build();  
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()  
                .title("API平台名字")
                .description("说明RESTful APIs")
                .contact("xxx@qq.com") 
                .version("1.0")
                .build();  
    }
}  