package ru.qtsolar.farsight.rest;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qtsolar.farsight.domain.TemperatureSensor;
import ru.qtsolar.farsight.service.TemperatureService;

import java.util.List;

@RestController
@RequestMapping("temperatureSensors")
@Api(value = "temperature rest ednpoint", description = "rest endpoint to manipulate and get info about temperature")
public class TemperatureResource {

    @Autowired
    TemperatureService temperatureService;

    @PostMapping("/entry")
    @ApiOperation(value = "entry temperature", notes = "insert into redis data from temperature sensor", response = Long.class)
    ResponseEntity<Long> entryTemperature(@RequestBody TemperatureSensor temperatureSensor) {
        return ResponseEntity.ok().body(temperatureService.saveTempSensor(temperatureSensor));
    }


    @GetMapping("/list")
    @ApiOperation(value = "list data temperature sensors", notes = "get all list from redis from temperature hash", response = TemperatureSensor[].class)
    ResponseEntity<List<TemperatureSensor>> listTemperatureSensors() {
        return ResponseEntity.ok().body(temperatureService.getTemperatureSensors());
    }


}
