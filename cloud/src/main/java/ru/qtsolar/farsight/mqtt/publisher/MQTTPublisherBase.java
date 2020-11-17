package ru.qtsolar.farsight.mqtt.publisher;

/**
 * MQTT Publisher Configuration class
 *
 */
public interface MQTTPublisherBase {

    /**
     * Publish message
     *
     * @param topic
     * @param message
     */
    void publishMessage(String topic, String message);

    /**
     * Disconnect MQTT Client
     */
    void disconnect();

}