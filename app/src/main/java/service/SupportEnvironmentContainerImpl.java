package service;

import java.util.concurrent.ConcurrentHashMap;

import Entity.SupportEnvironment;

public class SupportEnvironmentContainerImpl implements SupportEnvironmentContainer {

    private ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap;

    public SupportEnvironmentContainerImpl() {
    }

    public SupportEnvironmentContainerImpl(ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap) {
        this.supportEnvironmentMap = supportEnvironmentMap;
    }

    public ConcurrentHashMap<String, SupportEnvironment> getSupportEnvironmentMap() {
        return supportEnvironmentMap;
    }

    public void setSupportEnvironmentMap(ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap) {
        this.supportEnvironmentMap = supportEnvironmentMap;
    }

    @Override
    public SupportEnvironment getEnvironmentById(String environmentId) {
        return supportEnvironmentMap.get(environmentId);
    }
}
