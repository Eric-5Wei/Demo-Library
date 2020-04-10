package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Resource
    Environment environment;

    // 请求地址 http://localhost:8080/swagger-ui.html

    // 生成所有的 默认可以不写
    /*@Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo());
    }*/

    // 添加token  ---- 全局参数配置
    @Bean
    public Docket docket() {
        Parameter token = new ParameterBuilder().name("token")
                .description("用户登录令牌")
                .parameterType("header")
                .modelRef(new ModelRef("String"))
                .required(true)  // 必须填写
                .build();

        List<Parameter> parameters = new ArrayList<>();
        parameters.add(token);

        return new Docket(DocumentationType.SWAGGER_2)
                .globalOperationParameters(parameters);
    }

    // 分组 ----> start
    /*@Bean
    public Docket docketUser() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("用户")
                .select().paths(PathSelectors.ant("/user")).build();
    }

    @Bean
    public Docket docketHello() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("你好")
                .select().paths(PathSelectors.ant("/hello")).build();
    }*/
    // 分组 ----> end

    // 根据环境去识别是否可以访问swagger文档
    /*@Bean
    public Docket docket() {
        Profiles profiles = Profiles.of("dev", "test");
        boolean isEnable = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(Integer.class, Long.class)
                .enable(isEnable);
    }*/

    // 忽略请求参数
    /*@Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .ignoredParameterTypes(Integer.class, Long.class);
    }*/

    // 指定路径筛选
    /*@Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .paths(PathSelectors.ant("/htllo/**"))
                .build();
    }*/

    // 根据方法去扫描
    /*@Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(GetMapping.class))
                .build();
    }*/

    // 根据RestController类去扫描
    /*@Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.withClassAnnotation(RestController.class))
                .build();
    }
*/
    // 根据包路径去扫描生成接口文档
    /*@Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.example.controller"))
                .build();
    }*/

    private ApiInfo apiInfo() {
        Contact contact = new Contact("Eric-Wei", "www.zxcnb.cn", "1137478216@qq.com");
        return new ApiInfo("Swagger学习接口文档",
                "这是学习Swagger时生成的文档信息",
                "v1.0.0",
                "http://localhost:8080",
                contact,
                "",
                "",
                new ArrayList<>()
        );
    }
}
