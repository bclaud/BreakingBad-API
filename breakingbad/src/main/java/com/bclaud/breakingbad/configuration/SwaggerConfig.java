package com.bclaud.breakingbad.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
@EnableOpenApi
public class SwaggerConfig {

    @Bean
    public Docket userApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().apis(RequestHandlerSelectors.basePackage("com.bclaud"))
                .paths(PathSelectors.regex("/api.*")).build().apiInfo(metaInfo());
    }

    private ApiInfo metaInfo() {

        return new ApiInfoBuilder().title("BreakingBad API REST")
                .description("API developed for learning purposes. \n You can search for Breaking bad character's information and favorite them")
                .license("License to be defined").licenseUrl("tobedefinide").version("1.0")
                .contact(new Contact("Bruno Arrais Claudino", "https://www.bclaud.com.br", "bruarrais@gmail.com"))
                .build();
    }
}