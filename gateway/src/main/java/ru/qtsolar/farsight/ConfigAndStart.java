package ru.qtsolar.farsight;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"ru.qtsolar.farsight.service", "ru.qtsolar.farsight.rest"})
@MapperScan({"ru.qtsolar.farsight.mapper"}) //Это настройка майбатиса, которую потом возможно архитектурно по другому построим, но пусть для рыбы пока будет.
public class ConfigAndStart {
    public static void main(String[] args) {
        SpringApplication.run(ConfigAndStart.class);
    }
}
