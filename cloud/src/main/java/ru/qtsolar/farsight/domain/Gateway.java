package ru.qtsolar.farsight.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;

import java.util.List;

@RedisHash("gateways")
public class Gateway {

    @Id
    private Long id;
    private String message;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public Gateway(Long id, String message) {
        this.id = id;
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;

    }
}
