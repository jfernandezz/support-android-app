package Entity;

import service.ApplicationPropertiesReader;

public class SupportApplicarionProperty extends SupportEnvironment {
    String defaultEnvironmentId;
    String environmentIdAndPortStringMap;

    public SupportApplicarionProperty() {
    }

    public SupportApplicarionProperty (ApplicationPropertiesReader applicationPropertiesReader) {
        this.setHttpProtocol(applicationPropertiesReader.getProperty("httpProtocol"));
        this.setServer(applicationPropertiesReader.getProperty("supportExpressServerIp"));
        this.setEnvironmentIdAndPortStringMap(applicationPropertiesReader.getProperty("environmentIdAndPortMap"));
        this.setDefaultEnvironmentId(applicationPropertiesReader.getProperty("defaultEnvironmentId"));
    }


    public String getDefaultEnvironmentId() {
        return defaultEnvironmentId;
    }

    public void setDefaultEnvironmentId(String defaultEnvironmentId) {
        this.defaultEnvironmentId = defaultEnvironmentId;
    }

    public String getEnvironmentIdAndPortStringMap() {
        return environmentIdAndPortStringMap;
    }

    public void setEnvironmentIdAndPortStringMap(String environmentIdAndPortStringMap) {
        this.environmentIdAndPortStringMap = environmentIdAndPortStringMap;
    }
}
