package service;

import android.content.Context;

public interface SupportEnvironmentContainerMapper {
    SupportEnvironmentContainer extractSupportEnvironmentContainerFromApplicationPropertiesFile(String applicationPropertiesFileName, Context Context);
}
