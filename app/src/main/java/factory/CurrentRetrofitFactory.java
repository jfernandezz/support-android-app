package factory;

import Entity.CurrentRetrofit;

public class CurrentRetrofitFactory {
    private CurrentRetrofitFactory() {
    }

    private enum Singleton {
        INSTANCE;
        private CurrentRetrofit currentRetrofit = new CurrentRetrofit();
        public CurrentRetrofit get() { return currentRetrofit;}
    }
    public static CurrentRetrofit getCurrentRetrofit(){return CurrentRetrofitFactory.Singleton.INSTANCE.get();}

}
