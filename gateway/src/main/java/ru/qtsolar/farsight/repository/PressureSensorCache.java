package ru.qtsolar.farsight.repository;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.qtsolar.farsight.dto.SensorInterface;
import ru.qtsolar.farsight.dto.sensors.PressureSensor;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Repository
public class PressureSensorCache {



    public List<PressureSensor> getAll(){
        //Ну тут короче как бы бля, должен обращаться к кэшу, Кирюша это с тебя
        List<PressureSensor> pressureSensorList = new ArrayList<>();
        PressureSensor pressureSensor1 = new PressureSensor(1L, "super1");
        PressureSensor pressureSensor2 = new PressureSensor(2L, "super2");
        PressureSensor pressureSensor3 = new PressureSensor(3L, "super3");
        PressureSensor pressureSensor4 = new PressureSensor(4L, "super4");
        pressureSensorList.add(pressureSensor1);
        pressureSensorList.add(pressureSensor2);
        pressureSensorList.add(pressureSensor3);
        pressureSensorList.add(pressureSensor4);
        return pressureSensorList;
    }

    public Long addPressureSensorToCache(PressureSensor pressureSensor) {
        return 0L;
    }


}
