package ru.qtsolar.farsight.mapper;

import org.apache.ibatis.annotations.*;
import ru.qtsolar.farsight.data.PressureSensor;

import java.util.List;

//TODO вместо всего этого должно быть какое-то общение с редисом/influxdb

@Mapper
public interface PressureMapper {

    @Insert("INSERT INTO pressure_sensor(id, serialize_json) VALUES (#{id}, #{value}) " +
            "ON CONFLICT (id) DO UPDATE SET id = #{id}, serialize_json = #{value}")
    void insertPressureData(PressureSensor pressureSensor);
    //TODO
//    @Insert("INSERT INTO pressure_sensor(id, serialize_json) VALUES (DEFAULT, null)")
//    void insertPressureData(List<PressureSensor pressureSensorList);
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "value", column = "serialize_json")
    })
    @Select("SELECT id, serialize_json FROM pressure_sensor")
    List<PressureSensor> listPressureSensor();
}
