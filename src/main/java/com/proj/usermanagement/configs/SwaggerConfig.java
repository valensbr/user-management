//package com.proj.usermanagement.configs;
//
//import org.springframework.context.annotation.Bean;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//
//import java.util.Collections;
//
//public class SwaggerConfig {
//
//    @Bean
//    public Docket docket(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .build()
//                .apiInfo(apiInfo());
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfo(
//                "REST API Service User-Management ",
//                "REST API Service User-Management",
//                "1.0.0 20230118",
//                "Terms of Service",
//                new Contact("Backend Developer case-management-service","www.user.go.id",""),
//                "License of API","API License URL", Collections.emptyList()
//        );
//    }
//}
