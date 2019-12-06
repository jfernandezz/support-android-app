package Entity;

public class SupportApplicarionProperty extends SupportEnvironment {
    String defaultEnvironmentId;
    String environmentIdAndPortStringMap;

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
