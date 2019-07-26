package ru.qtsolar.farsight.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import ru.qtsolar.farsight.data.PressureSensor;

import java.util.List;

@Mapper
public interface PressureMapper {

    @Insert("INSERT INTO pressure_sensor(id, serialize_json) VALUES (#{id}, #{value}) " +
            "ON CONFLICT (id) DO UPDATE SET id = #{id}, serialize_json = #{value}")
    void insertPressureData(PressureSensor pressureSensor);

//    @Insert("INSERT INTO pressure_sensor(id, serialize_json) VALUES (DEFAULT, null)")
//    void insertPressureData(List<PressureSensor> pressureSensorList);
//
}
