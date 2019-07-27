package ru.qtsolar.farsight.domain;


import org.springframework.data.redis.core.RedisHash;

@RedisHash("pressureSensors")
public class PressureSensor {
    private Long id;
    private String value;

    public PressureSensor(){}

    public PressureSensor(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
