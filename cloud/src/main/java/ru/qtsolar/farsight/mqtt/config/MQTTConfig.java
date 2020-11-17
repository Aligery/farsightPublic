package ru.qtsolar.farsight.mqtt.config;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;

/**
 * MQTT Core Configuration
 *
 */
public abstract class MQTTConfig {

    private final String broker = "127.0.0.1";
    private final String userName = "testUserName";
    private final String password = "demoPassword";
    private final String TCP = "tcp://";

    private Integer port = 1883; /* Default port */

    protected final int qos = 2;
    protected final String SSL = "ssl://";
    protected String clientId = "Server";

    protected Boolean hasSSL = false; /* By default SSL is disabled */
    protected String brokerUrl = this.TCP + this.broker + ":" + this.port;
    protected MqttClient mqttClient = null;
    protected MqttConnectOptions connectionOptions = null;
    protected MemoryPersistence persistence = null;

    /**
     * Custom Configuration
     *
     * @param broker
     * @param port
     * @param ssl
     * @param withUserNamePass
     */
    protected abstract void config(String broker, Integer port, Boolean ssl, Boolean withUserNamePass);

    /**
     * Default Configuration
     */
    protected abstract void config();

    protected void setUpConf(Boolean ssl, Boolean withUserNamePass) throws MqttException {
        //TODO поддержка SSL
        //TODO авторизация
        this.persistence = new MemoryPersistence();
        this.connectionOptions = new MqttConnectOptions();
        this.mqttClient = new MqttClient(brokerUrl, clientId, persistence);
        this.connectionOptions.setCleanSession(true);
        if (withUserNamePass) {
            this.connectionOptions.setPassword(this.password.toCharArray());
            this.connectionOptions.setUserName(this.userName);
        }
    }
}