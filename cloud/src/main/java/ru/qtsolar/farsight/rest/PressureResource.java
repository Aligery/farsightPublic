package ru.qtsolar.farsight.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qtsolar.farsight.domain.PressureSensor;
import ru.qtsolar.farsight.mqtt.publisher.MQTTPublisherBase;
import ru.qtsolar.farsight.service.PressureService;

@RestController
@RequestMapping("pressure")
@Api(value = "pressure rest endpoint", description = "rest endpoint to manipulate and get info about pressure")
public class PressureResource {

    @Autowired
    PressureService pressureService;
    @Autowired
    MQTTPublisherBase publisher;


    @PostMapping("/entry")
    @ApiOperation(value = "entry pressure", notes = "insert into redis data from pressure sensor", response = Long.class)
    public ResponseEntity<Long> entryPressure(@RequestBody PressureSensor pressureSensor){
        pressureService.savePressureSensor(pressureSensor);
        return ResponseEntity.ok().body(1L);
    }

    @GetMapping("/list")
    @ApiOperation(value = "list data pressure", notes = "get all list from redis from pressure hash", response = PressureSensor[].class)
    public ResponseEntity listPressure(){
        return ResponseEntity.ok().body(pressureService.getPressureSensors());
    }


    @ApiOperation(value = "sent to someTopic written string message (just testing)")
    @RequestMapping(value = "/mqtt/send/pressureService", method = RequestMethod.GET)
    public ResponseEntity<String> index(@RequestParam("data") String data) {
        publisher.publishMessage("someTopic", data);
        return ResponseEntity.ok("Message sent to Broker");
    }
}
