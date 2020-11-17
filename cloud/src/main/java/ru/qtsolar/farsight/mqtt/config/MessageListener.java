package ru.qtsolar.farsight.mqtt.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ru.qtsolar.farsight.mqtt.subscriber.MQTTSubscriberBase;

import static ru.qtsolar.farsight.mqtt.utils.TopicCreator.*;

@Component
public class MessageListener implements Runnable{

    @Autowired
    MQTTSubscriberBase subscriber;

    @Override
    public void run() {
        while(true) {
            subscriber.subscribeMessage(createTopic(OUT, STRUCTURE, PLUS, DEVICES, PLUS, LIGHT, DIM));
        }

    }

}