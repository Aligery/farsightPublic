package ru.qtsolar.farsight.redis.repository;

import org.springframework.data.repository.CrudRepository;
import ru.qtsolar.farsight.domain.TemperatureSensor;


public interface TemperatureSensorsRepository extends CrudRepository<TemperatureSensor, Long> {
}
