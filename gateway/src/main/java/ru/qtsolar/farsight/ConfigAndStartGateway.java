package ru.qtsolar.farsight;


import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

//Надо выпилить настройку DataSource нахуй, потому что у нас БД на gateway нет. Хотя по моей задумке, мета инфу будем получать с БД, но это логичнее сделать через GET запросы
@SpringBootApplication
@ComponentScan({"ru.qtsolar.farsight.service", "ru.qtsolar.farsight.rest", "ru.qtsolar.farsight.repository"})
@MapperScan({"ru.qtsolar.farsight.mapper"}) //Это настройка майбатиса, которую потом возможно архитектурно по другому построим, но пусть для рыбы пока будет.
@EnableScheduling
public class ConfigAndStartGateway {


    public static void main(String[] args) {

        SpringApplication.run(ConfigAndStartGateway.class);
    }
}
