package ru.qtsolar.farsight.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.qtsolar.farsight.data.PressureSensor;
import ru.qtsolar.farsight.service.PressureService;

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
}
