package ru.qtsolar.farsight.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qtsolar.farsight.data.PressureSensor;
import ru.qtsolar.farsight.service.PressureService;

import java.util.List;

@RestController
@RequestMapping("gateway")
public class GatewayResource {

    @Autowired
    PressureService pressureService;

    @PostMapping("/entryPressureSensor")
    public ResponseEntity<Long> entryPressure(@RequestBody PressureSensor pressureSensor){
        pressureService.entryPressureSensor(pressureSensor);
        return ResponseEntity.ok().body(1L);
    }

    @GetMapping("/listSensorPressure")
    public ResponseEntity<List<PressureSensor>> listSensors(){
        return ResponseEntity.ok().body(pressureService.getAllPressureInformation());
    }
}
