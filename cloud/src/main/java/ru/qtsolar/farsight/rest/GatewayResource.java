package ru.qtsolar.farsight.rest;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.qtsolar.farsight.domain.Lamp;
import ru.qtsolar.farsight.domain.PressureSensor;
import ru.qtsolar.farsight.mqtt.data.model.LightBulbDataTopic;
import ru.qtsolar.farsight.mqtt.publisher.MQTTPublisherBase;
import ru.qtsolar.farsight.service.LampService;
import ru.qtsolar.farsight.service.PressureService;

import java.util.List;

import static ru.qtsolar.farsight.mqtt.utils.TopicCreator.*;

@RestController
@RequestMapping("gateway")
@Api(value = "gateway rest endpoint", description = "rest endpoint to manipulate and get info about pressure")
public class GatewayResource {

    @Autowired
    PressureService pressureService;
    @Autowired
    MQTTPublisherBase publisher;
    @Autowired
    LampService lampService;

    @RequestMapping(value = "/mqtt/send/gatewayService", method = RequestMethod.POST)
    @ApiOperation(value = "publish message to selected gatewayId, serverid, data by model")
    public ResponseEntity<String> index(@RequestBody LightBulbDataTopic bulb){
        //TODO валидируем data?
        publisher.publishMessage(createTopic(GATEWAY, bulb.getGatewayId(), IN, bulb.getServerId(), CONTROL, LIGHT, DIM), bulb.getData());
        return ResponseEntity.ok("Message sent to Broker");
    }

    @RequestMapping(value = "/lamps/list", method = RequestMethod.GET)
    @ApiOperation(value = "get list lamps id and value from redis")
    public ResponseEntity<List<Lamp>> getLamp() {
        return ResponseEntity.ok(lampService.getLamps());
    }

}
