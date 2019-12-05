package factory;


import service.LoginService;
import service.LoginServiceImpl;

public final class LoginServiceFactory {
    private LoginServiceFactory() {
    }

    private enum Singleton {
        INSTANCE;
        private LoginService loginService = new LoginServiceImpl();
        public LoginService get() { return loginService;}
    }
    public static LoginService getLoginService(){return Singleton.INSTANCE.get();}
}
