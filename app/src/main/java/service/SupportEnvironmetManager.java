package service;

import android.content.Context;

import Entity.SupportEnvironment;

public interface SupportEnvironmetManager {
    SupportEnvironment setCurrentEnvironment(String environmentId);
    void initialize(String applicationPropertiesFileName, Context Context);
}
