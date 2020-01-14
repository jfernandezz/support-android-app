package factory;

import service.SupportEnvironmentMapper;
import service.SupportEnvironmentMapperImpl;

public class SupportEnvironmentContainerMapperFactory {
    private SupportEnvironmentContainerMapperFactory() {
    }
    private enum Singleton {
        INSTANCE;
        private SupportEnvironmentMapper supportEnvironmentContainerMapper = new SupportEnvironmentMapperImpl();
        public SupportEnvironmentMapper get() { return supportEnvironmentContainerMapper;}
    }
    public static SupportEnvironmentMapper getsupportEnvironmentContainerMapper(){return SupportEnvironmentContainerMapperFactory.Singleton.INSTANCE.get();}
}
