package ru.qtsolar.farsight.rest;


import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "", notes = "")
    public ResponseEntity<List<PressureSensor>> checkHealth(){

        return ResponseEntity.ok().body(cacheService.getAllPressureSensor());

    }

    @PostMapping(value = "/load")
    @ApiOperation(value = "", notes = "t")
    public ResponseEntity<Long> checkHealth(@RequestBody PressureSensor pressureSensor){
        return ResponseEntity.ok().body(cacheService.loadPressureSensor(pressureSensor));
    }

}
