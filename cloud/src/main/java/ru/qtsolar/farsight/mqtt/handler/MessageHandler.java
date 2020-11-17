package ru.qtsolar.farsight.mqtt.handler;

import ru.qtsolar.farsight.domain.Lamp;
import ru.qtsolar.farsight.mqtt.subscriber.MQTTSubscriber;
import ru.qtsolar.farsight.redis.repository.LampsRepository;

import java.util.regex.Matcher;

public class MessageHandler {
    public static void handleMessage(String topic, String message, LampsRepository lampsRepository) {
        for(TopicsRegEx topicRegEx : TopicsRegEx.values()) {
            Matcher matcher = topicRegEx.getMatcher(topic);
            if (matcher.find()){
                switch(topicRegEx.name()){
                    case("OUT_DIM"):
                        System.out.println("KEY - " + Long.parseLong(matcher.group(1) + matcher.group(2)));
                        System.out.println("data - " + message);
                        try {
                            lampsRepository.save(new Lamp(Long.parseLong(matcher.group(1) + matcher.group(2)),
                                                message));
                        } catch (Exception e){
                            System.out.println(e);
                        }

                        break;
                    case("OUT_STATUS"):
                        break;
                }
            }
        }

    }

}
