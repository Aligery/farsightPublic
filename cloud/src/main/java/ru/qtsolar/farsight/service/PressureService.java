package ru.qtsolar.farsight.service;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.qtsolar.farsight.domain.PressureSensor;
import ru.qtsolar.farsight.redis.repository.PressureSensorsRepository;

import java.util.List;

@Service
public class PressureService {

    @Autowired
    PressureSensorsRepository pressureSensorsRepository;

    public Long savePressureSensor(PressureSensor pressureSensor) {
        pressureSensorsRepository.save(pressureSensor);
        return pressureSensor.getId();
    }

    public List getPressureSensors() {
        return IteratorUtils.toList(pressureSensorsRepository.findAll().iterator());
    }
}
