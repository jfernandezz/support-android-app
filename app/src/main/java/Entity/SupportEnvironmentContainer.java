package Entity;

import java.util.concurrent.ConcurrentHashMap;

public class SupportEnvironmentContainer {
    private SupportEnvironment currentEnvironment;
    private ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap;

    public SupportEnvironmentContainer() {
    }

    public SupportEnvironmentContainer(SupportEnvironment currentEnvironment, ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap) {
        this.currentEnvironment = currentEnvironment;
        this.supportEnvironmentMap = supportEnvironmentMap;
    }

    public SupportEnvironment getCurrentEnvironment() {
        return currentEnvironment;
    }

    public void setCurrentEnvironment(SupportEnvironment currentEnvironment) {
        this.currentEnvironment = currentEnvironment;
    }

    public ConcurrentHashMap<String, SupportEnvironment> getSupportEnvironmentMap() {
        return supportEnvironmentMap;
    }

    public void setSupportEnvironmentMap(ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap) {
        this.supportEnvironmentMap = supportEnvironmentMap;
    }
}
