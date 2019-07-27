package ru.qtsolar.farsight.redis.repository;

import org.springframework.data.repository.CrudRepository;
import ru.qtsolar.farsight.domain.PressureSensor;


public interface PressureSensorsRepository extends CrudRepository<PressureSensor, Long> {
}
