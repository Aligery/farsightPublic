package ru.qtsolar.farsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;



//ADD Oauth configuration
@SpringBootApplication
@ComponentScan({"ru.qtsolar.farsight.service", "ru.qtsolar.farsight.rest", "ru.qtsolar.farsight.redis.repository"})
 //Это настройка майбатиса, которую потом возможно архитектурно по другому построим, но пусть для рыбы пока будет.
@EnableSwagger2
public class ConfigAndStartCloud {

    //DELETE IN PRODUCTION AND ANOTATION TOO
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }


    public static void main(String[] args) {

        SpringApplication.run(ConfigAndStartCloud.class);
    }
}
