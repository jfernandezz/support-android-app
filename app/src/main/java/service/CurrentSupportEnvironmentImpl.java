package service;

import Entity.SupportEnvironment;

public class CurrentSupportEnvironmentImpl implements CurrentSupportEnvironment{
    private SupportEnvironment currentEnvironment;

    public CurrentSupportEnvironmentImpl() {
    }


    @Override
    public SupportEnvironment getCurrentEnvironment() {
        return currentEnvironment;
    }

    @Override
    public void setCurrentEnvironment(SupportEnvironment currentEnvironment) {
          this.currentEnvironment = currentEnvironment;
    }
}
