package factory;

import Entity.SupportEnvironmentContainer;

public final class SupportEnvironmentContainerFactory {
    private SupportEnvironmentContainerFactory() {
    }

    private enum Singleton {
        INSTANCE;
        private SupportEnvironmentContainer currentEnvironmentService = new SupportEnvironmentContainer();

        public SupportEnvironmentContainer get() {
            return currentEnvironmentService;
        }
    }

    public static SupportEnvironmentContainer getSupportEnvironmentContainer() {
        return SupportEnvironmentContainerFactory.Singleton.INSTANCE.get();
    }


}
