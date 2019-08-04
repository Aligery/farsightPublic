package ru.qtsolar.farsight.redis.repository;


import org.springframework.data.repository.CrudRepository;
import ru.qtsolar.farsight.domain.Gateway;

import java.util.Optional;


public interface GatewayRepository extends CrudRepository<Gateway, String> {


}
