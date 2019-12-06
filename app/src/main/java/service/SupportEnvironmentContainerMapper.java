package service;

import android.content.Context;

import Entity.SupportEnvironmentContainer;

public interface SupportEnvironmentContainerMapper {
    SupportEnvironmentContainer extractSupportEnvironmentContainerFromApplicationPropertiesFile(Context Context);
}
