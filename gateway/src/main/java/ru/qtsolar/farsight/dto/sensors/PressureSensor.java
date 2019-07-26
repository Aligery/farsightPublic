package ru.qtsolar.farsight.dto.sensors;

import ru.qtsolar.farsight.dto.SensorInterface;

public class PressureSensor implements SensorInterface {

    private Long id;
    private String value;


    public PressureSensor(){};

    public PressureSensor(Long id, String value) {
        this.id = id;
        this.value = value;
    }

    @Override
    public String getValue() {
        return value;
    }

    @Override
    public void setValue(String value) {
        this.value=value;
    }

    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }
}
