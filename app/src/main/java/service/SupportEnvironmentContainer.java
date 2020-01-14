package service;

import java.util.concurrent.ConcurrentHashMap;

import Entity.SupportEnvironment;

public interface SupportEnvironmentContainer {
    SupportEnvironment getEnvironmentById(String environmentId);
    public ConcurrentHashMap<String, SupportEnvironment> getSupportEnvironmentMap();
    void setSupportEnvironmentMap(ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap);

}
