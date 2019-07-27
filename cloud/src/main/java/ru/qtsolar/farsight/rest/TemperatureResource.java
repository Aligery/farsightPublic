package ru.qtsolar.farsight.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qtsolar.farsight.domain.TemperatureSensor;
import ru.qtsolar.farsight.redis.repository.TemperatureSensorsRepository;
import ru.qtsolar.farsight.service.TemperatureService;

import java.util.List;

@RestController
@RequestMapping("temperatureSensors")
public class TemperatureResource {

    @Autowired
    TemperatureService temperatureService;

    @PostMapping("/entry")
    ResponseEntity<Long> entryTemperature(@RequestBody TemperatureSensor temperatureSensor) {
        return ResponseEntity.ok().body(temperatureService.saveTempSensor(temperatureSensor));
    }


    @GetMapping("/list")
    ResponseEntity<List<TemperatureSensor>> listTemperatureSensors() {
        return ResponseEntity.ok().body(temperatureService.getTemperatureSensors());
    }


}
