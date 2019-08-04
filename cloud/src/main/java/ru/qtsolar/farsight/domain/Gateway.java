package ru.qtsolar.farsight.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("gateways")
public class Gateway {

    @Id
    private String id;
    private List<Long> foreingKeySensors;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<Long> getForeingKeySensors() {
        return foreingKeySensors;
    }

    public void setForeingKeySensors(List<Long> foreingKeySensors) {
        this.foreingKeySensors = foreingKeySensors;
    }
}
