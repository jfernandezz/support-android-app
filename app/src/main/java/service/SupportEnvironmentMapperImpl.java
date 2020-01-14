package service;

import android.content.Context;

import java.util.concurrent.ConcurrentHashMap;

import Entity.SupportApplicarionProperty;
import Entity.SupportEnvironment;
import factory.CurrentSupportEnvironmentFactory;
import factory.SupportEnvironmentContainerFactory;

public class SupportEnvironmentMapperImpl implements SupportEnvironmentMapper {
    private SupportEnvironmentContainer supportEnvironmentContainer = SupportEnvironmentContainerFactory.getSupportEnvironmentContainer();
    private CurrentSupportEnvironment currentSupportEnvironment = CurrentSupportEnvironmentFactory.getCurrentSupportEnvironment();


    @Override
    public void loadSupportEnvironmentsPreopertiesFromApplicationPropertiesFile(String applicationPropertiesFileName, Context context) {
        ApplicationPropertiesReader applicationPropertiesReader = new ApplicationPropertiesReaderImpl(applicationPropertiesFileName, context);
        loadSupportEnvironmentContainer(applicationPropertiesReader);
        loadCurrentSupportEnvironment(applicationPropertiesReader);
    }

    private CurrentSupportEnvironment loadCurrentSupportEnvironment(ApplicationPropertiesReader applicationPropertiesReader) {
        String defaultEnvironmentId = applicationPropertiesReader.getProperty("defaultEnvironmentId");
        SupportEnvironment defaultEnvironment = supportEnvironmentContainer.getEnvironmentById(defaultEnvironmentId);
        currentSupportEnvironment.setCurrentEnvironment(defaultEnvironment);
        return currentSupportEnvironment;
    }

    private SupportEnvironmentContainer loadSupportEnvironmentContainer(ApplicationPropertiesReader applicationPropertiesReader) {
        SupportApplicarionProperty supportApplicarionProperty = new SupportApplicarionProperty(applicationPropertiesReader);
        supportEnvironmentContainer.setSupportEnvironmentMap(buildSupportEnvironmentMap(supportApplicarionProperty));
        return supportEnvironmentContainer;
    }

    private ConcurrentHashMap<String, SupportEnvironment> buildSupportEnvironmentMap(SupportApplicarionProperty supportApplicarionProperty) {
        ConcurrentHashMap<String, SupportEnvironment> supportEnvironmentMap = new ConcurrentHashMap<String, SupportEnvironment>();
        String environmentIdAndPortArray[] = supportApplicarionProperty.getEnvironmentIdAndPortStringMap().split(",");
        for (String enviromentIdAndPortString : environmentIdAndPortArray) {
            String enviromentId = enviromentIdAndPortString.split(":")[0];
            String port = new String(enviromentIdAndPortString.split(":")[1]);
            SupportEnvironment supportEnvironment = new SupportEnvironment();
            supportEnvironment.setEnvironmentId(enviromentId);
            supportEnvironment.setServer(supportApplicarionProperty.getServer());
            supportEnvironment.setPort(port);
            supportEnvironment.setHttpProtocol(supportApplicarionProperty.getHttpProtocol());
            supportEnvironment.setUrlBase(supportEnvironment.getHttpProtocol() + "://" + supportEnvironment.getServer() + ":" + port);
            supportEnvironmentMap.put(enviromentId, supportEnvironment);
        }
        return supportEnvironmentMap;
    }


}
