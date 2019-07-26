package ru.qtsolar.farsight;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ru.qtsolar.farsight.service", "ru.qtsolar.farsight.rest", "ru.qtsolar.farsight.repository"})
@MapperScan({"ru.qtsolar.farsight.mapper"}) //Это настройка майбатиса, которую потом возможно архитектурно по другому построим, но пусть для рыбы пока будет.
public class ConfigAndStartCloud {

    public static void main(String[] args) {

        SpringApplication.run(ConfigAndStartCloud.class);
    }
}
