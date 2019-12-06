package Entity;

public class SupportEnvironment {
    private String environmentId;
    private String server;
    private String port;
    private String httpProtocol;
    private String urlBase;

    public SupportEnvironment() {
    }

    public SupportEnvironment(String environmentId, String server, String port, String httpProtocol, String urlBase) {
        this.environmentId = environmentId;
        this.server = server;
        this.port = port;
        this.httpProtocol = httpProtocol;
        this.urlBase = urlBase;
    }

    public String getEnvironmentId() {
        return environmentId;
    }

    public void setEnvironmentId(String environmentId) {
        this.environmentId = environmentId;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getHttpProtocol() {
        return httpProtocol;
    }

    public void setHttpProtocol(String httpProtocol) {
        this.httpProtocol = httpProtocol;
    }

    public String getUrlBase() {
        return urlBase;
    }

    public void setUrlBase(String urlBase) {
        this.urlBase = urlBase;
    }
}
