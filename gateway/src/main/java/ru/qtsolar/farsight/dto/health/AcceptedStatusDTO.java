package ru.qtsolar.farsight.dto.health;

public class AcceptedStatusDTO {

    private boolean status_cloud;
    private String version_cloud;
    private String version_gateway;

    public boolean isStatus_cloud() {
        return status_cloud;
    }

    public void setStatus_cloud(boolean status_cloud) {
        this.status_cloud = status_cloud;
    }

    public String getVersion_cloud() {
        return version_cloud;
    }

    public void setVersion_cloud(String version_cloud) {
        this.version_cloud = version_cloud;
    }

    public String getVersion_gateway() {
        return version_gateway;
    }

    public void setVersion_gateway(String version_gateway) {
        this.version_gateway = version_gateway;
    }
}
