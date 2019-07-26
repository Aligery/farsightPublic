package ru.qtsolar.farsight.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.qtsolar.farsight.data.PressureSensor;
import ru.qtsolar.farsight.mapper.PressureMapper;

import java.util.List;

@Service
public class PressureService {

    @Autowired
    PressureMapper pressureMapper;

    public void entryPressureSensor(PressureSensor pressureSensor) {
        pressureMapper.insertPressureData(pressureSensor);
    }

    public List<PressureSensor> getAllPressureInformation() {
        return pressureMapper.listPressureSensor();
    }

//    public void entryPressureSensor(List<PressureSensor> pressureSensorList) {
//        pressureMapper.insertPressureData(pressureSensorList);
//    }
}
