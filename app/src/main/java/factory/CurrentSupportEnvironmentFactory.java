package factory;

import service.CurrentSupportEnvironment;
import service.CurrentSupportEnvironmentImpl;

public final class CurrentSupportEnvironmentFactory {
    private CurrentSupportEnvironmentFactory() {
    }

    private enum Singleton {
        INSTANCE;
        private CurrentSupportEnvironment currentSupportEnvironment = new CurrentSupportEnvironmentImpl();

        public CurrentSupportEnvironment get() {
            return currentSupportEnvironment;
        }
    }

    public static CurrentSupportEnvironment getCurrentSupportEnvironment() {
        return CurrentSupportEnvironmentFactory.Singleton.INSTANCE.get();
    }

}
