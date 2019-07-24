package ru.qtsolar.farsight.dto.health;

public class HealthDTO {

    private String version;
    private boolean dbStatus;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public boolean isDbStatus() {
        return dbStatus;
    }

    public void setDbStatus(boolean dbStatus) {
        this.dbStatus = dbStatus;
    }
}
