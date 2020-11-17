package ru.qtsolar.farsight.mqtt.handler;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static ru.qtsolar.farsight.mqtt.utils.TopicCreator.*;

public enum TopicsRegEx {

    OUT_DIM (createTopic(OUT, STRUCTURE, BUS_ID_PAT , DEVICES, DEV_ID_PAT, LIGHT, DIM)),
    OUT_STATUS (createTopic(OUT, STRUCTURE, BUS_ID_PAT, DEVICES, DEV_ID_PAT, STATUS));

    private String topic;
    private Pattern pattern;

    TopicsRegEx(String topic) {
        this.topic = topic;
        this.pattern = Pattern.compile(topic);
    }

    public String getTopic() {
        return topic;
    }

    public Matcher getMatcher(String text) {
        return pattern.matcher(text);
    }

}
