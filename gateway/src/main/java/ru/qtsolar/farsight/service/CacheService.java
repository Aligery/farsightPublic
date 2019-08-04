package ru.qtsolar.farsight.service;

import kong.unirest.JacksonObjectMapper;
import kong.unirest.ObjectMapper;
import kong.unirest.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.qtsolar.farsight.dto.sensors.PressureSensor;
import ru.qtsolar.farsight.repository.PressureSensorCache;

import javax.annotation.PostConstruct;
import java.util.List;

@Service
public class CacheService {

    @Autowired
    PressureSensorCache pressureSensorCache;

    @PostConstruct // Может в main класс вынести как конфиг??
    void metaSettingsUnirest() {
        Unirest.config().setObjectMapper(new JacksonObjectMapper());
    }

    public List<PressureSensor> getAllPressureSensor(){
        return pressureSensorCache.getAll();
    }

    public Long loadPressureSensor(PressureSensor pressureSensor) {
        return pressureSensorCache.addPressureSensorToCache(pressureSensor);
    }




}
