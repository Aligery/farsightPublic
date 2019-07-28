package ru.qtsolar.farsight.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qtsolar.farsight.domain.PressureSensor;
import ru.qtsolar.farsight.service.PressureService;

import java.util.List;

@RestController
@RequestMapping("pressure")
@Api(value = "pressure rest ednpoint", description = "rest endpoint to manipulate and get info about pressure")
public class PressureResource {

    @Autowired
    PressureService pressureService;


    @PostMapping("/entry")
    @ApiOperation(value = "entry pressure", notes = "insert into redis data from pressure sensor", response = Long.class)
    public ResponseEntity<Long> entryPressure(@RequestBody PressureSensor pressureSensor){
        pressureService.entryPressureSensor(pressureSensor);
        return ResponseEntity.ok().body(1L);
    }

    @GetMapping("/list")
    @ApiOperation(value = "list data pressure", notes = "get all list from redis from pressure hash", response = PressureSensor[].class)
    public ResponseEntity<List<PressureSensor>> listPressure(){
        return ResponseEntity.ok().body(pressureService.getAllPressureInformation());
    }
}
