package factory;

import service.SupportEnvironmentContainer;
import service.SupportEnvironmentContainerImpl;

public final class SupportEnvironmentContainerFactory {
    private SupportEnvironmentContainerFactory() {
    }

    private enum Singleton {
        INSTANCE;
        private SupportEnvironmentContainer currentEnvironmentService = new SupportEnvironmentContainerImpl();

        public SupportEnvironmentContainer get() {
            return currentEnvironmentService;
        }
    }

    public static SupportEnvironmentContainer getSupportEnvironmentContainer() {
        return SupportEnvironmentContainerFactory.Singleton.INSTANCE.get();
    }


}
