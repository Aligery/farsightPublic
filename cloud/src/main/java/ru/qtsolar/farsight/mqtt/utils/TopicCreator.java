package ru.qtsolar.farsight.mqtt.utils;

public class TopicCreator {

    public static final String GATEWAY = "gateway";
    public static final String IN = "in";
    public static final String CONTROL = "control";
    public static final String LIGHT = "light";
    public static final String DIM = "dim";
    public static final String OUT = "out";
    public static final String STRUCTURE = "structure";
    public static final String DEVICES = "devices";
    public static final String STATUS = "status";
    public static final String PLUS = "+";

    public static final String BUS_ID_PAT = "(\\d+)"; //TODO уточнить
    public static final String DEV_ID_PAT = "(\\d+)"; //скобки нужны для выделения группы

    private static final String SLASH = "/";


    public static String createTopic(String... topics){
        StringBuilder topic = new StringBuilder();
        for (String topic1 : topics) {
            topic.append(SLASH);
            topic.append(topic1);
        }
        return topic.toString();
    }
}
