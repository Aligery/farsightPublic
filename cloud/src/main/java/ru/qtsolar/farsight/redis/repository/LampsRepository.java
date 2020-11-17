package ru.qtsolar.farsight.redis.repository;

import org.springframework.data.repository.CrudRepository;
import ru.qtsolar.farsight.domain.Lamp;


public interface LampsRepository extends CrudRepository<Lamp, Long> {
}
