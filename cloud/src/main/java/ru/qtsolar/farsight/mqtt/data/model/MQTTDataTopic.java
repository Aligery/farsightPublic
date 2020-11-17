package ru.qtsolar.farsight.mqtt.data.model;

public class MQTTDataTopic {

    private String topic;
    private String message;

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
