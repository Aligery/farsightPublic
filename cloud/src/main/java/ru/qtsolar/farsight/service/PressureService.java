package ru.qtsolar.farsight.service;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import ru.qtsolar.farsight.domain.PressureSensor;
import ru.qtsolar.farsight.redis.repository.PressureSensorsRepository;

import java.util.List;

@Service
public class PressureService {

    @Autowired
    PressureSensorsRepository pressureSensorsRepository;

    public void entryPressureSensor(PressureSensor pressureSensor) {
        pressureSensorsRepository.save(pressureSensor);
    }

    public List<PressureSensor> getAllPressureInformation() {

        return IteratorUtils.toList(pressureSensorsRepository.findAll().iterator());
    }

//    public void entryPressureSensor(List<TemperatureSensor> pressureSensorList) {
//        pressureMapper.insertPressureData(pressureSensorList);
//    }
}
