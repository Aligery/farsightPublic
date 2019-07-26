package ru.qtsolar.farsight.rest;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import ru.qtsolar.farsight.dto.health.HealthDTO;


//Just check availble system and translate it to user
@RestController
public class HealthController {

    @RequestMapping(value="/healthStatus", method = RequestMethod.GET)
    public ResponseEntity<HealthDTO> checkHealth(){
        HealthDTO healthDTO = new HealthDTO();
        healthDTO.setVersion("1.0");
        healthDTO.setDbStatus(true);
        return ResponseEntity.ok().body(healthDTO);
    }
}
