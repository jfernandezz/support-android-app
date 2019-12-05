package factory;

import entity.Session;

public final class SessionFactory {
    private SessionFactory(){
    }
    private enum Singleton {
        INSTANCE;
        private Session session = new Session();
        public Session get() { return session;}
    }
    public static Session getSession() {
        return SessionFactory.Singleton.INSTANCE.get();
    }
}
