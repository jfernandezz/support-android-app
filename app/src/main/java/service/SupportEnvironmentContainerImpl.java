package Entity;

import java.util.concurrent.ConcurrentHashMap;

public class SupportEnvironmentContainer {

    private ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap;

    public SupportEnvironmentContainer() {
    }

    public SupportEnvironmentContainer( ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap) {
        this.supportEnvironmentMap = supportEnvironmentMap;
    }

    public ConcurrentHashMap<String, SupportEnvironment> getSupportEnvironmentMap() {
        return supportEnvironmentMap;
    }

    public void setSupportEnvironmentMap(ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap) {
        this.supportEnvironmentMap = supportEnvironmentMap;
    }
}
