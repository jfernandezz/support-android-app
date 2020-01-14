package service;

import android.content.Context;

import Entity.SupportEnvironment;
import factory.CurrentSupportEnvironmentFactory;
import factory.SupportEnvironmentContainerFactory;
import factory.SupportEnvironmentContainerMapperFactory;

public class SupportEnvironmetManagerImpl implements SupportEnvironmetManager {
    private SupportEnvironmentContainer supportEnvironmentContainer;
    private CurrentSupportEnvironment currentSupportEnvironment;
    private SupportEnvironmentMapper supportEnvironmentContainerMapper;

    public SupportEnvironmetManagerImpl() {
        supportEnvironmentContainer = SupportEnvironmentContainerFactory.getSupportEnvironmentContainer();
        currentSupportEnvironment = CurrentSupportEnvironmentFactory.getCurrentSupportEnvironment();
        supportEnvironmentContainerMapper = SupportEnvironmentContainerMapperFactory.getsupportEnvironmentContainerMapper();

    }

    @Override
    public SupportEnvironment setCurrentEnvironment(String environmentId) {
        SupportEnvironment newCurrentEnvironment = supportEnvironmentContainer.getEnvironmentById(environmentId);
        currentSupportEnvironment.setCurrentEnvironment(newCurrentEnvironment);
        return newCurrentEnvironment;
    }

    @Override
    public void initialize(String applicationPropertiesFileName, Context context) {
        supportEnvironmentContainerMapper.loadSupportEnvironmentsPreopertiesFromApplicationPropertiesFile(applicationPropertiesFileName, context);
    }
}
