package ru.qtsolar.farsight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ru.qtsolar.farsight.service", "ru.qtsolar.farsight.rest", "ru.qtsolar.farsight.redis.repository"})
 //Это настройка майбатиса, которую потом возможно архитектурно по другому построим, но пусть для рыбы пока будет.
public class ConfigAndStartCloud {

    public static void main(String[] args) {

        SpringApplication.run(ConfigAndStartCloud.class);
    }
}
