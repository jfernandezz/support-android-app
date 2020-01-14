package service;

import Entity.SupportEnvironment;

public interface CurrentSupportEnvironment {
    SupportEnvironment getCurrentEnvironment();
    void setCurrentEnvironment(SupportEnvironment currentEnvironment);
}
