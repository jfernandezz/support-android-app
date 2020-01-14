package factory;

import service.SupportEnvironmetManager;
import service.SupportEnvironmetManagerImpl;

public class SupportEnvironmetManagerFactory {

    private SupportEnvironmetManagerFactory(){
    }
    private enum Singleton {
        INSTANCE;
        private SupportEnvironmetManager supportEnvironmetManager = new SupportEnvironmetManagerImpl();
        public SupportEnvironmetManager get() { return supportEnvironmetManager;}
    }
    public static SupportEnvironmetManager getSupportEnvironmetManager() {
        return SupportEnvironmetManagerFactory.Singleton.INSTANCE.get();
    }
}
