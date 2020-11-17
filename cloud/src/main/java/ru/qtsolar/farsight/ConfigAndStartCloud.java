package ru.qtsolar.farsight;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.task.TaskExecutor;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


//ADD Oauth configuration
@SpringBootApplication
@ComponentScan({"ru.qtsolar.farsight.service",
                "ru.qtsolar.farsight.rest",
                "ru.qtsolar.farsight.redis.repository",
                "ru.qtsolar.farsight.mqtt.*"})
 //Это настройка майбатиса, которую потом возможно архитектурно по другому построим, но пусть для рыбы пока будет.
@EnableSwagger2
public class ConfigAndStartCloud extends SpringBootServletInitializer {

    @Autowired
    Runnable MessageListener;

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(ConfigAndStartCloud.class);
    }


    //DELETE IN PRODUCTION AND ANNOTATION TOO
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build();
    }

    @Bean
    public CommandLineRunner schedulingRunner(@Qualifier("taskExecutor") TaskExecutor executor) {
        return args -> executor.execute(MessageListener);
    }


    public static void main(String[] args) {
        SpringApplication.run(ConfigAndStartCloud.class);
    }
}
