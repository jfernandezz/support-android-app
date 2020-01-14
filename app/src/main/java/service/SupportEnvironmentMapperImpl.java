package service;

import android.content.Context;

import java.util.concurrent.ConcurrentHashMap;

import Entity.SupportApplicarionProperty;
import Entity.SupportEnvironment;
import factory.SupportEnvironmentContainerFactory;

public class SupportEnvironmentContainerMapperImpl implements SupportEnvironmentContainerMapper {
    private SupportEnvironmentContainer supportEnvironmentContainer = SupportEnvironmentContainerFactory.getSupportEnvironmentContainer();

    @Override
    public SupportEnvironmentContainer extractSupportEnvironmentContainerFromApplicationPropertiesFile(String applicationPropertiesFileName, Context context) {
        ApplicationPropertiesReader applicationPropertiesReader = new ApplicationPropertiesReaderImpl(applicationPropertiesFileName, context);
        SupportApplicarionProperty supportApplicarionProperty = new SupportApplicarionProperty(applicationPropertiesReader);
        supportEnvironmentContainer.setSupportEnvironmentMap(buildSupportEnvironmentMap(supportApplicarionProperty));
        return supportEnvironmentContainer;
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
            supportEnvironmentMap.put(enviromentId, supportEnvironment);
        }
        return supportEnvironmentMap;
    }


}
