package ru.qtsolar.farsight.service;

import org.apache.commons.collections.IteratorUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.qtsolar.farsight.domain.Lamp;
import ru.qtsolar.farsight.redis.repository.LampsRepository;

import java.util.List;

@Service
public class LampService {

    @Autowired
    LampsRepository lampsRepository;

    public Long saveLamp(Lamp lamp) {
        lampsRepository.save(lamp);
        return lamp.getId();
    }

    public List getLamps() {
        return IteratorUtils.toList(lampsRepository.findAll().iterator());
    }
}
