package ru.qtsolar.farsight.service;


import kong.unirest.JacksonObjectMapper;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.qtsolar.farsight.repository.PressureSensorCache;

import javax.annotation.PostConstruct;

@Service
public class CloudService {

    @Autowired
    PressureSensorCache pressureSensorCache;

    @Scheduled(fixedRate = 10000)
    public void sendToCloud() {
        System.out.println("SENDED EVERY 10000ms");
        //Unirest realisation to cloud how to get ip cloud???
        //TODO: Configure to sent ArrayList and insert one long Insert is better in the future
        pressureSensorCache.getAll().forEach(k->{
            Unirest.post("http://localhost:8081/gateway/entryPressureSensor")
                    .header("content-type", "application/json")
                    .body(k).asEmpty();
        });
    }
}
