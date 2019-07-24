package ru.qtsolar.farsight.rest;


import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.qtsolar.farsight.dto.health.HealthDTO;


//Just check availble system and translate it to user
@RestController
public class HealthController {

    @RequestMapping(value="/healthStatus", method = RequestMethod.GET)
    @ApiOperation(value = "healthStatus", notes = "check availeble system or not, and translate some  meta information to front")
    public ResponseEntity<HealthDTO> checkHealth(){
        HealthDTO healthDTO = new HealthDTO();
        healthDTO.setVersion("1.0");
        healthDTO.setDbStatus(true);
        return ResponseEntity.ok().body(healthDTO);
    }
}
