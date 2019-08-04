package ru.qtsolar.farsight.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qtsolar.farsight.dto.health.HealthDTO;
import ru.qtsolar.farsight.dto.sensors.PressureSensor;
import ru.qtsolar.farsight.service.CacheService;

import java.util.List;

//Вообще короче вот здесь должен быть не HTTP, а COAP. Поймали, положили в кэш значение, но для отладки написал так
@RestController(value = "/sensor")
public class AcceptedController {


    @Autowired
    CacheService cacheService;

    @GetMapping(value="/list")
    public ResponseEntity<List<PressureSensor>> checkHealth(){

        return ResponseEntity.ok().body(cacheService.getAllPressureSensor());

    }

    @PostMapping(value = "/load")
    public ResponseEntity<Long> checkHealth(@RequestBody PressureSensor pressureSensor){
        return ResponseEntity.ok().body(cacheService.loadPressureSensor(pressureSensor));
    }

}
