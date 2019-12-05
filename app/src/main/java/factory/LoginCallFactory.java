package factory;
import service.supportexpressapi.LoginCall;
import service.supportexpressapi.LoginCallImpl;

public class LoginCallFactory {
    private LoginCallFactory() {
    }

    private enum Singleton {
        INSTANCE;
        private LoginCall loginCall = new LoginCallImpl();
        public LoginCall get() { return loginCall;}
    }
    public static LoginCall getLoginCall(){return LoginCallFactory.Singleton.INSTANCE.get();}
}
