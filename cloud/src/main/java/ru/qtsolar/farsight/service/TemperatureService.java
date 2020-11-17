package ru.qtsolar.farsight.service;


import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.qtsolar.farsight.domain.TemperatureSensor;
import ru.qtsolar.farsight.redis.repository.TemperatureSensorsRepository;

import java.util.List;

@Service
public class TemperatureService {

    @Autowired
    TemperatureSensorsRepository temperatureSensorsRepository;

    public Long saveTempSensor(TemperatureSensor temperatureSensor) {
        temperatureSensorsRepository.save(temperatureSensor);
        return temperatureSensor.getId();
    }

    public List getTemperatureSensors() {
        return IteratorUtils.toList(temperatureSensorsRepository.findAll().iterator());
    }
}
