package ru.qtsolar.farsight.mqtt.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ru.qtsolar.farsight.mqtt.publisher.MQTTPublisherBase;

/**
 * MQTT Subscriber Base Interface
 *
 */
public interface MQTTSubscriberBase {

    Logger logger = LoggerFactory.getLogger(MQTTPublisherBase.class);

    /**
     * Subscribe message
     *
     * @param topic
     *
     */
    void subscribeMessage(String topic);

    /**
     * Disconnect MQTT Client
     */
    void disconnect();
}
