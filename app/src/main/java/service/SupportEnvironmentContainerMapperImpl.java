package service;

import android.content.Context;

import java.util.concurrent.ConcurrentHashMap;

import Entity.SupportApplicarionProperty;
import Entity.SupportEnvironment;
import Entity.SupportEnvironmentContainer;

public class SupportEnvironmentContainerMapperImpl implements SupportEnvironmentContainerMapper {

    @Override
    public SupportEnvironmentContainer extractSupportEnvironmentContainerFromApplicationPropertiesFile(Context context) {
        ApplicationPropertiesReader applicationPropertiesReader = new ApplicationPropertiesReaderImpl("app.properties", context);
        SupportApplicarionProperty supportApplicarionProperty = buildSupportApplicarionProperty(applicationPropertiesReader);
        ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap = buildSupportEnvironmentMap(supportApplicarionProperty);
        SupportEnvironment currentEnvironment = supportEnvironmentMap.get(supportApplicarionProperty.getDefaultEnvironmentId());
        SupportEnvironmentContainer supportEnvironmentContainer = new SupportEnvironmentContainer(currentEnvironment ,supportEnvironmentMap);
        return supportEnvironmentContainer;
    }

    private SupportApplicarionProperty buildSupportApplicarionProperty(ApplicationPropertiesReader applicationPropertiesReader) {
        SupportApplicarionProperty supportApplicarionProperty = new SupportApplicarionProperty();
        supportApplicarionProperty.setHttpProtocol(applicationPropertiesReader.getProperty("httpProtocol"));
        supportApplicarionProperty.setServer(applicationPropertiesReader.getProperty("supportExpressServerIp"));
        supportApplicarionProperty.setEnvironmentIdAndPortStringMap(applicationPropertiesReader.getProperty("environmentIdAndPortMap"));
        supportApplicarionProperty.setDefaultEnvironmentId(applicationPropertiesReader.getProperty("defaultEnvironmentId"));
        return supportApplicarionProperty;
    }

    private ConcurrentHashMap<String, SupportEnvironment> buildSupportEnvironmentMap(SupportApplicarionProperty supportApplicarionProperty) {
        ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap = new ConcurrentHashMap<String, SupportEnvironment>();
        String environmentIdAndPortArray[] = supportApplicarionProperty.getEnvironmentIdAndPortStringMap().split(",");
        for (String enviromentIdAndPortString : environmentIdAndPortArray) {
            String enviromentId = enviromentIdAndPortString.split(":")[0];
            String port = enviromentIdAndPortString.split(":")[1];
            SupportEnvironment supportEnvironment = supportApplicarionProperty;
            supportEnvironment.setEnvironmentId(enviromentId);
            supportEnvironment.setPort(port);
            supportEnvironmentMap.put(enviromentId,supportEnvironment);
        }
        return supportEnvironmentMap;
    }


}
